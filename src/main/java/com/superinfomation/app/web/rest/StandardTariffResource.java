package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.StandardTariffService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.StandardTariffDTO;
import com.superinfomation.app.service.dto.StandardTariffCriteria;
import com.superinfomation.app.service.StandardTariffQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link com.superinfomation.app.domain.StandardTariff}.
 */
@RestController
@RequestMapping("/api")
public class StandardTariffResource {

    private final Logger log = LoggerFactory.getLogger(StandardTariffResource.class);

    private static final String ENTITY_NAME = "standardTariff";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StandardTariffService standardTariffService;

    private final StandardTariffQueryService standardTariffQueryService;

    public StandardTariffResource(StandardTariffService standardTariffService, StandardTariffQueryService standardTariffQueryService) {
        this.standardTariffService = standardTariffService;
        this.standardTariffQueryService = standardTariffQueryService;
    }

    /**
     * {@code POST  /standard-tariffs} : Create a new standardTariff.
     *
     * @param standardTariffDTO the standardTariffDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new standardTariffDTO, or with status {@code 400 (Bad Request)} if the standardTariff has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/standard-tariffs")
    public ResponseEntity<StandardTariffDTO> createStandardTariff(@Valid @RequestBody StandardTariffDTO standardTariffDTO) throws URISyntaxException {
        log.debug("REST request to save StandardTariff : {}", standardTariffDTO);
        if (standardTariffDTO.getId() != null) {
            throw new BadRequestAlertException("A new standardTariff cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StandardTariffDTO result = standardTariffService.save(standardTariffDTO);
        return ResponseEntity.created(new URI("/api/standard-tariffs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /standard-tariffs} : Updates an existing standardTariff.
     *
     * @param standardTariffDTO the standardTariffDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated standardTariffDTO,
     * or with status {@code 400 (Bad Request)} if the standardTariffDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the standardTariffDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/standard-tariffs")
    public ResponseEntity<StandardTariffDTO> updateStandardTariff(@Valid @RequestBody StandardTariffDTO standardTariffDTO) throws URISyntaxException {
        log.debug("REST request to update StandardTariff : {}", standardTariffDTO);
        if (standardTariffDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StandardTariffDTO result = standardTariffService.save(standardTariffDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, standardTariffDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /standard-tariffs} : get all the standardTariffs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of standardTariffs in body.
     */
    @GetMapping("/standard-tariffs")
    public ResponseEntity<List<StandardTariffDTO>> getAllStandardTariffs(StandardTariffCriteria criteria, Pageable pageable) {
        log.debug("REST request to get StandardTariffs by criteria: {}", criteria);
        Page<StandardTariffDTO> page = standardTariffQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /standard-tariffs/count} : count all the standardTariffs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/standard-tariffs/count")
    public ResponseEntity<Long> countStandardTariffs(StandardTariffCriteria criteria) {
        log.debug("REST request to count StandardTariffs by criteria: {}", criteria);
        return ResponseEntity.ok().body(standardTariffQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /standard-tariffs/:id} : get the "id" standardTariff.
     *
     * @param id the id of the standardTariffDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the standardTariffDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/standard-tariffs/{id}")
    public ResponseEntity<StandardTariffDTO> getStandardTariff(@PathVariable Long id) {
        log.debug("REST request to get StandardTariff : {}", id);
        Optional<StandardTariffDTO> standardTariffDTO = standardTariffService.findOne(id);
        return ResponseUtil.wrapOrNotFound(standardTariffDTO);
    }

    /**
     * {@code DELETE  /standard-tariffs/:id} : delete the "id" standardTariff.
     *
     * @param id the id of the standardTariffDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/standard-tariffs/{id}")
    public ResponseEntity<Void> deleteStandardTariff(@PathVariable Long id) {
        log.debug("REST request to delete StandardTariff : {}", id);

        standardTariffService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/standard-tariffs?query=:query} : search for the standardTariff corresponding
     * to the query.
     *
     * @param query the query of the standardTariff search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/standard-tariffs")
    public ResponseEntity<List<StandardTariffDTO>> searchStandardTariffs(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of StandardTariffs for query {}", query);
        Page<StandardTariffDTO> page = standardTariffService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
