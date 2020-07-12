package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.StateMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.StateMasterDTO;
import com.superinfomation.app.service.dto.StateMasterCriteria;
import com.superinfomation.app.service.StateMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.StateMaster}.
 */
@RestController
@RequestMapping("/api")
public class StateMasterResource {

    private final Logger log = LoggerFactory.getLogger(StateMasterResource.class);

    private static final String ENTITY_NAME = "stateMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StateMasterService stateMasterService;

    private final StateMasterQueryService stateMasterQueryService;

    public StateMasterResource(StateMasterService stateMasterService, StateMasterQueryService stateMasterQueryService) {
        this.stateMasterService = stateMasterService;
        this.stateMasterQueryService = stateMasterQueryService;
    }

    /**
     * {@code POST  /state-masters} : Create a new stateMaster.
     *
     * @param stateMasterDTO the stateMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stateMasterDTO, or with status {@code 400 (Bad Request)} if the stateMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/state-masters")
    public ResponseEntity<StateMasterDTO> createStateMaster(@Valid @RequestBody StateMasterDTO stateMasterDTO) throws URISyntaxException {
        log.debug("REST request to save StateMaster : {}", stateMasterDTO);
        if (stateMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new stateMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StateMasterDTO result = stateMasterService.save(stateMasterDTO);
        return ResponseEntity.created(new URI("/api/state-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /state-masters} : Updates an existing stateMaster.
     *
     * @param stateMasterDTO the stateMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stateMasterDTO,
     * or with status {@code 400 (Bad Request)} if the stateMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stateMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/state-masters")
    public ResponseEntity<StateMasterDTO> updateStateMaster(@Valid @RequestBody StateMasterDTO stateMasterDTO) throws URISyntaxException {
        log.debug("REST request to update StateMaster : {}", stateMasterDTO);
        if (stateMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StateMasterDTO result = stateMasterService.save(stateMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, stateMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /state-masters} : get all the stateMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stateMasters in body.
     */
    @GetMapping("/state-masters")
    public ResponseEntity<List<StateMasterDTO>> getAllStateMasters(StateMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get StateMasters by criteria: {}", criteria);
        Page<StateMasterDTO> page = stateMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /state-masters/count} : count all the stateMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/state-masters/count")
    public ResponseEntity<Long> countStateMasters(StateMasterCriteria criteria) {
        log.debug("REST request to count StateMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(stateMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /state-masters/:id} : get the "id" stateMaster.
     *
     * @param id the id of the stateMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stateMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/state-masters/{id}")
    public ResponseEntity<StateMasterDTO> getStateMaster(@PathVariable Long id) {
        log.debug("REST request to get StateMaster : {}", id);
        Optional<StateMasterDTO> stateMasterDTO = stateMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stateMasterDTO);
    }

    /**
     * {@code DELETE  /state-masters/:id} : delete the "id" stateMaster.
     *
     * @param id the id of the stateMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/state-masters/{id}")
    public ResponseEntity<Void> deleteStateMaster(@PathVariable Long id) {
        log.debug("REST request to delete StateMaster : {}", id);

        stateMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/state-masters?query=:query} : search for the stateMaster corresponding
     * to the query.
     *
     * @param query the query of the stateMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/state-masters")
    public ResponseEntity<List<StateMasterDTO>> searchStateMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of StateMasters for query {}", query);
        Page<StateMasterDTO> page = stateMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
