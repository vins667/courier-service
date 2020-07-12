package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.CityMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.CityMaster}.
 */
public interface CityMasterService {

    /**
     * Save a cityMaster.
     *
     * @param cityMasterDTO the entity to save.
     * @return the persisted entity.
     */
    CityMasterDTO save(CityMasterDTO cityMasterDTO);

    /**
     * Get all the cityMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CityMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" cityMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CityMasterDTO> findOne(Long id);

    /**
     * Delete the "id" cityMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the cityMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CityMasterDTO> search(String query, Pageable pageable);
}
