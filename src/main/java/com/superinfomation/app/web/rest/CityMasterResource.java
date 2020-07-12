package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.CityMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.CityMasterDTO;
import com.superinfomation.app.service.dto.CityMasterCriteria;
import com.superinfomation.app.service.CityMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.CityMaster}.
 */
@RestController
@RequestMapping("/api")
public class CityMasterResource {

    private final Logger log = LoggerFactory.getLogger(CityMasterResource.class);

    private static final String ENTITY_NAME = "cityMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CityMasterService cityMasterService;

    private final CityMasterQueryService cityMasterQueryService;

    public CityMasterResource(CityMasterService cityMasterService, CityMasterQueryService cityMasterQueryService) {
        this.cityMasterService = cityMasterService;
        this.cityMasterQueryService = cityMasterQueryService;
    }

    /**
     * {@code POST  /city-masters} : Create a new cityMaster.
     *
     * @param cityMasterDTO the cityMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cityMasterDTO, or with status {@code 400 (Bad Request)} if the cityMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/city-masters")
    public ResponseEntity<CityMasterDTO> createCityMaster(@Valid @RequestBody CityMasterDTO cityMasterDTO) throws URISyntaxException {
        log.debug("REST request to save CityMaster : {}", cityMasterDTO);
        if (cityMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new cityMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CityMasterDTO result = cityMasterService.save(cityMasterDTO);
        return ResponseEntity.created(new URI("/api/city-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /city-masters} : Updates an existing cityMaster.
     *
     * @param cityMasterDTO the cityMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cityMasterDTO,
     * or with status {@code 400 (Bad Request)} if the cityMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cityMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/city-masters")
    public ResponseEntity<CityMasterDTO> updateCityMaster(@Valid @RequestBody CityMasterDTO cityMasterDTO) throws URISyntaxException {
        log.debug("REST request to update CityMaster : {}", cityMasterDTO);
        if (cityMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CityMasterDTO result = cityMasterService.save(cityMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cityMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /city-masters} : get all the cityMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cityMasters in body.
     */
    @GetMapping("/city-masters")
    public ResponseEntity<List<CityMasterDTO>> getAllCityMasters(CityMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get CityMasters by criteria: {}", criteria);
        Page<CityMasterDTO> page = cityMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /city-masters/count} : count all the cityMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/city-masters/count")
    public ResponseEntity<Long> countCityMasters(CityMasterCriteria criteria) {
        log.debug("REST request to count CityMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(cityMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /city-masters/:id} : get the "id" cityMaster.
     *
     * @param id the id of the cityMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cityMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/city-masters/{id}")
    public ResponseEntity<CityMasterDTO> getCityMaster(@PathVariable Long id) {
        log.debug("REST request to get CityMaster : {}", id);
        Optional<CityMasterDTO> cityMasterDTO = cityMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cityMasterDTO);
    }

    /**
     * {@code DELETE  /city-masters/:id} : delete the "id" cityMaster.
     *
     * @param id the id of the cityMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/city-masters/{id}")
    public ResponseEntity<Void> deleteCityMaster(@PathVariable Long id) {
        log.debug("REST request to delete CityMaster : {}", id);

        cityMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/city-masters?query=:query} : search for the cityMaster corresponding
     * to the query.
     *
     * @param query the query of the cityMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/city-masters")
    public ResponseEntity<List<CityMasterDTO>> searchCityMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of CityMasters for query {}", query);
        Page<CityMasterDTO> page = cityMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
