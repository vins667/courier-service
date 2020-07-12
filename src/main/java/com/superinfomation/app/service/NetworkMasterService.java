package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.NetworkMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.NetworkMaster}.
 */
public interface NetworkMasterService {

    /**
     * Save a networkMaster.
     *
     * @param networkMasterDTO the entity to save.
     * @return the persisted entity.
     */
    NetworkMasterDTO save(NetworkMasterDTO networkMasterDTO);

    /**
     * Get all the networkMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NetworkMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" networkMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NetworkMasterDTO> findOne(Long id);

    /**
     * Delete the "id" networkMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the networkMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NetworkMasterDTO> search(String query, Pageable pageable);
}
