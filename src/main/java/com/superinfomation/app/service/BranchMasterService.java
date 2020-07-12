package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.BranchMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.BranchMaster}.
 */
public interface BranchMasterService {

    /**
     * Save a branchMaster.
     *
     * @param branchMasterDTO the entity to save.
     * @return the persisted entity.
     */
    BranchMasterDTO save(BranchMasterDTO branchMasterDTO);

    /**
     * Get all the branchMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BranchMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" branchMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BranchMasterDTO> findOne(Long id);

    /**
     * Delete the "id" branchMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the branchMaster corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BranchMasterDTO> search(String query, Pageable pageable);
}
