package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.CountryMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.CountryMasterDTO;
import com.superinfomation.app.service.dto.CountryMasterCriteria;
import com.superinfomation.app.service.CountryMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.CountryMaster}.
 */
@RestController
@RequestMapping("/api")
public class CountryMasterResource {

    private final Logger log = LoggerFactory.getLogger(CountryMasterResource.class);

    private static final String ENTITY_NAME = "countryMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CountryMasterService countryMasterService;

    private final CountryMasterQueryService countryMasterQueryService;

    public CountryMasterResource(CountryMasterService countryMasterService, CountryMasterQueryService countryMasterQueryService) {
        this.countryMasterService = countryMasterService;
        this.countryMasterQueryService = countryMasterQueryService;
    }

    /**
     * {@code POST  /country-masters} : Create a new countryMaster.
     *
     * @param countryMasterDTO the countryMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new countryMasterDTO, or with status {@code 400 (Bad Request)} if the countryMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/country-masters")
    public ResponseEntity<CountryMasterDTO> createCountryMaster(@Valid @RequestBody CountryMasterDTO countryMasterDTO) throws URISyntaxException {
        log.debug("REST request to save CountryMaster : {}", countryMasterDTO);
        if (countryMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new countryMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CountryMasterDTO result = countryMasterService.save(countryMasterDTO);
        return ResponseEntity.created(new URI("/api/country-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /country-masters} : Updates an existing countryMaster.
     *
     * @param countryMasterDTO the countryMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated countryMasterDTO,
     * or with status {@code 400 (Bad Request)} if the countryMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the countryMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/country-masters")
    public ResponseEntity<CountryMasterDTO> updateCountryMaster(@Valid @RequestBody CountryMasterDTO countryMasterDTO) throws URISyntaxException {
        log.debug("REST request to update CountryMaster : {}", countryMasterDTO);
        if (countryMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CountryMasterDTO result = countryMasterService.save(countryMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, countryMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /country-masters} : get all the countryMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of countryMasters in body.
     */
    @GetMapping("/country-masters")
    public ResponseEntity<List<CountryMasterDTO>> getAllCountryMasters(CountryMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get CountryMasters by criteria: {}", criteria);
        Page<CountryMasterDTO> page = countryMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /country-masters/count} : count all the countryMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/country-masters/count")
    public ResponseEntity<Long> countCountryMasters(CountryMasterCriteria criteria) {
        log.debug("REST request to count CountryMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(countryMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /country-masters/:id} : get the "id" countryMaster.
     *
     * @param id the id of the countryMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the countryMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/country-masters/{id}")
    public ResponseEntity<CountryMasterDTO> getCountryMaster(@PathVariable Long id) {
        log.debug("REST request to get CountryMaster : {}", id);
        Optional<CountryMasterDTO> countryMasterDTO = countryMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(countryMasterDTO);
    }

    /**
     * {@code DELETE  /country-masters/:id} : delete the "id" countryMaster.
     *
     * @param id the id of the countryMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/country-masters/{id}")
    public ResponseEntity<Void> deleteCountryMaster(@PathVariable Long id) {
        log.debug("REST request to delete CountryMaster : {}", id);

        countryMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/country-masters?query=:query} : search for the countryMaster corresponding
     * to the query.
     *
     * @param query the query of the countryMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/country-masters")
    public ResponseEntity<List<CountryMasterDTO>> searchCountryMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of CountryMasters for query {}", query);
        Page<CountryMasterDTO> page = countryMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
