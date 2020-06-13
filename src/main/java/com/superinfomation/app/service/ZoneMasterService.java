package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.ZoneMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.ZoneMaster}.
 */
public interface ZoneMasterService {

    /**
     * Save a zoneMaster.
     *
     * @param zoneMasterDTO the entity to save.
     * @return the persisted entity.
     */
    ZoneMasterDTO save(ZoneMasterDTO zoneMasterDTO);

    /**
     * Get all the zoneMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ZoneMasterDTO> findAll(Pageable pageable);


    /**
     * Get the "id" zoneMaster.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ZoneMasterDTO> findOne(Long id);

    /**
     * Delete the "id" zoneMaster.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
