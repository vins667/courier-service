package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.CountryMasterService;
import com.superinfomation.app.domain.CountryMaster;
import com.superinfomation.app.repository.CountryMasterRepository;
import com.superinfomation.app.repository.search.CountryMasterSearchRepository;
import com.superinfomation.app.service.dto.CountryMasterDTO;
import com.superinfomation.app.service.mapper.CountryMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link CountryMaster}.
 */
@Service
@Transactional
public class CountryMasterServiceImpl implements CountryMasterService {

    private final Logger log = LoggerFactory.getLogger(CountryMasterServiceImpl.class);

    private final CountryMasterRepository countryMasterRepository;

    private final CountryMasterMapper countryMasterMapper;

    private final CountryMasterSearchRepository countryMasterSearchRepository;

    public CountryMasterServiceImpl(CountryMasterRepository countryMasterRepository, CountryMasterMapper countryMasterMapper, CountryMasterSearchRepository countryMasterSearchRepository) {
        this.countryMasterRepository = countryMasterRepository;
        this.countryMasterMapper = countryMasterMapper;
        this.countryMasterSearchRepository = countryMasterSearchRepository;
    }

    /**
     * Save a countryMaster.
     *
     * @param countryMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CountryMasterDTO save(CountryMasterDTO countryMasterDTO) {
        log.debug("Request to save CountryMaster : {}", countryMasterDTO);
        CountryMaster countryMaster = countryMasterMapper.toEntity(countryMasterDTO);
        countryMaster = countryMasterRepository.save(countryMaster);
        CountryMasterDTO result = countryMasterMapper.toDto(countryMaster);
        countryMasterSearchRepository.save(countryMaster);
        return result;
    }

    /**
     * Get all the countryMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CountryMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CountryMasters");
        return countryMasterRepository.findAll(pageable)
            .map(countryMasterMapper::toDto);
    }


    /**
     * Get one countryMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CountryMasterDTO> findOne(Long id) {
        log.debug("Request to get CountryMaster : {}", id);
        return countryMasterRepository.findById(id)
            .map(countryMasterMapper::toDto);
    }

    /**
     * Delete the countryMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CountryMaster : {}", id);

        countryMasterRepository.deleteById(id);
        countryMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the countryMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CountryMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of CountryMasters for query {}", query);
        return countryMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(countryMasterMapper::toDto);
    }
}
