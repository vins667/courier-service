package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.ServiceMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.ServiceMaster}.
 */
public interface ServiceMasterService {

    /**
     * Save a serviceMaster.
     *
     * @param serviceMasterDTO the entity to save.
     * @return the persisted entity.
     */
    ServiceMasterDTO save(ServiceMasterDTO serviceMasterDTO);

    /**
     * Get all the serviceMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ServiceMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" serviceMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ServiceMasterDTO> findOne(Long id);

    /**
     * Delete the "id" serviceMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the serviceMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ServiceMasterDTO> search(String query, Pageable pageable);
}
