package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.CompanyMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.CompanyMaster}.
 */
public interface CompanyMasterService {

    /**
     * Save a companyMaster.
     *
     * @param companyMasterDTO the entity to save.
     * @return the persisted entity.
     */
    CompanyMasterDTO save(CompanyMasterDTO companyMasterDTO);

    /**
     * Get all the companyMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CompanyMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" companyMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CompanyMasterDTO> findOne(Long id);

    /**
     * Delete the "id" companyMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the companyMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CompanyMasterDTO> search(String query, Pageable pageable);
}
