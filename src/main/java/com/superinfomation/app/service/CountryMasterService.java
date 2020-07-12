package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.CountryMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.CountryMaster}.
 */
public interface CountryMasterService {

    /**
     * Save a countryMaster.
     *
     * @param countryMasterDTO the entity to save.
     * @return the persisted entity.
     */
    CountryMasterDTO save(CountryMasterDTO countryMasterDTO);

    /**
     * Get all the countryMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CountryMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" countryMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CountryMasterDTO> findOne(Long id);

    /**
     * Delete the "id" countryMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the countryMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CountryMasterDTO> search(String query, Pageable pageable);
}
