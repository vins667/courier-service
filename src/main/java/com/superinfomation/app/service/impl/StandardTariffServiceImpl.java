package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.StandardTariffService;
import com.superinfomation.app.domain.StandardTariff;
import com.superinfomation.app.repository.StandardTariffRepository;
import com.superinfomation.app.repository.search.StandardTariffSearchRepository;
import com.superinfomation.app.service.dto.StandardTariffDTO;
import com.superinfomation.app.service.mapper.StandardTariffMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link StandardTariff}.
 */
@Service
@Transactional
public class StandardTariffServiceImpl implements StandardTariffService {

    private final Logger log = LoggerFactory.getLogger(StandardTariffServiceImpl.class);

    private final StandardTariffRepository standardTariffRepository;

    private final StandardTariffMapper standardTariffMapper;

    private final StandardTariffSearchRepository standardTariffSearchRepository;

    public StandardTariffServiceImpl(StandardTariffRepository standardTariffRepository, StandardTariffMapper standardTariffMapper, StandardTariffSearchRepository standardTariffSearchRepository) {
        this.standardTariffRepository = standardTariffRepository;
        this.standardTariffMapper = standardTariffMapper;
        this.standardTariffSearchRepository = standardTariffSearchRepository;
    }

    /**
     * Save a standardTariff.
     *
     * @param standardTariffDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StandardTariffDTO save(StandardTariffDTO standardTariffDTO) {
        log.debug("Request to save StandardTariff : {}", standardTariffDTO);
        StandardTariff standardTariff = standardTariffMapper.toEntity(standardTariffDTO);
        standardTariff = standardTariffRepository.save(standardTariff);
        StandardTariffDTO result = standardTariffMapper.toDto(standardTariff);
        standardTariffSearchRepository.save(standardTariff);
        return result;
    }

    /**
     * Get all the standardTariffs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StandardTariffDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StandardTariffs");
        return standardTariffRepository.findAll(pageable)
            .map(standardTariffMapper::toDto);
    }


    /**
     * Get one standardTariff by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StandardTariffDTO> findOne(Long id) {
        log.debug("Request to get StandardTariff : {}", id);
        return standardTariffRepository.findById(id)
            .map(standardTariffMapper::toDto);
    }

    /**
     * Delete the standardTariff by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StandardTariff : {}", id);

        standardTariffRepository.deleteById(id);
        standardTariffSearchRepository.deleteById(id);
    }

    /**
     * Search for the standardTariff corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StandardTariffDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of StandardTariffs for query {}", query);
        return standardTariffSearchRepository.search(queryStringQuery(query), pageable)
            .map(standardTariffMapper::toDto);
    }
}
