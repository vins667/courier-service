package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.CompanyMasterService;
import com.superinfomation.app.domain.CompanyMaster;
import com.superinfomation.app.repository.CompanyMasterRepository;
import com.superinfomation.app.repository.search.CompanyMasterSearchRepository;
import com.superinfomation.app.service.dto.CompanyMasterDTO;
import com.superinfomation.app.service.mapper.CompanyMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link CompanyMaster}.
 */
@Service
@Transactional
public class CompanyMasterServiceImpl implements CompanyMasterService {

    private final Logger log = LoggerFactory.getLogger(CompanyMasterServiceImpl.class);

    private final CompanyMasterRepository companyMasterRepository;

    private final CompanyMasterMapper companyMasterMapper;

    private final CompanyMasterSearchRepository companyMasterSearchRepository;

    public CompanyMasterServiceImpl(CompanyMasterRepository companyMasterRepository, CompanyMasterMapper companyMasterMapper, CompanyMasterSearchRepository companyMasterSearchRepository) {
        this.companyMasterRepository = companyMasterRepository;
        this.companyMasterMapper = companyMasterMapper;
        this.companyMasterSearchRepository = companyMasterSearchRepository;
    }

    /**
     * Save a companyMaster.
     *
     * @param companyMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CompanyMasterDTO save(CompanyMasterDTO companyMasterDTO) {
        log.debug("Request to save CompanyMaster : {}", companyMasterDTO);
        CompanyMaster companyMaster = companyMasterMapper.toEntity(companyMasterDTO);
        companyMaster = companyMasterRepository.save(companyMaster);
        CompanyMasterDTO result = companyMasterMapper.toDto(companyMaster);
        companyMasterSearchRepository.save(companyMaster);
        return result;
    }

    /**
     * Get all the companyMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CompanyMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CompanyMasters");
        return companyMasterRepository.findAll(pageable)
            .map(companyMasterMapper::toDto);
    }


    /**
     * Get one companyMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CompanyMasterDTO> findOne(Long id) {
        log.debug("Request to get CompanyMaster : {}", id);
        return companyMasterRepository.findById(id)
            .map(companyMasterMapper::toDto);
    }

    /**
     * Delete the companyMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CompanyMaster : {}", id);

        companyMasterRepository.deleteById(id);
        companyMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the companyMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CompanyMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of CompanyMasters for query {}", query);
        return companyMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(companyMasterMapper::toDto);
    }
}
