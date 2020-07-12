package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.StateMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.StateMaster}.
 */
public interface StateMasterService {

    /**
     * Save a stateMaster.
     *
     * @param stateMasterDTO the entity to save.
     * @return the persisted entity.
     */
    StateMasterDTO save(StateMasterDTO stateMasterDTO);

    /**
     * Get all the stateMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StateMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" stateMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StateMasterDTO> findOne(Long id);

    /**
     * Delete the "id" stateMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the stateMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StateMasterDTO> search(String query, Pageable pageable);
}
