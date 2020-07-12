package com.superinfomation.app.service;

import com.superinfomation.app.service.dto.StandardTariffDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.superinfomation.app.domain.StandardTariff}.
 */
public interface StandardTariffService {

    /**
     * Save a standardTariff.
     *
     * @param standardTariffDTO the entity to save.
     * @return the persisted entity.
     */
    StandardTariffDTO save(StandardTariffDTO standardTariffDTO);

    /**
     * Get all the standardTariffs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StandardTariffDTO> findAll(Pageable pageable);


    /**
     * Get the "id" standardTariff.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StandardTariffDTO> findOne(Long id);

    /**
     * Delete the "id" standardTariff.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the standardTariff corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StandardTariffDTO> search(String query, Pageable pageable);
}
