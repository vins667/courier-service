package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.BranchMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.BranchMasterDTO;
import com.superinfomation.app.service.dto.BranchMasterCriteria;
import com.superinfomation.app.service.BranchMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.BranchMaster}.
 */
@RestController
@RequestMapping("/api")
public class BranchMasterResource {

    private final Logger log = LoggerFactory.getLogger(BranchMasterResource.class);

    private static final String ENTITY_NAME = "branchMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BranchMasterService branchMasterService;

    private final BranchMasterQueryService branchMasterQueryService;

    public BranchMasterResource(BranchMasterService branchMasterService, BranchMasterQueryService branchMasterQueryService) {
        this.branchMasterService = branchMasterService;
        this.branchMasterQueryService = branchMasterQueryService;
    }

    /**
     * {@code POST  /branch-masters} : Create a new branchMaster.
     *
     * @param branchMasterDTO the branchMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new branchMasterDTO, or with status {@code 400 (Bad Request)} if the branchMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/branch-masters")
    public ResponseEntity<BranchMasterDTO> createBranchMaster(@Valid @RequestBody BranchMasterDTO branchMasterDTO) throws URISyntaxException {
        log.debug("REST request to save BranchMaster : {}", branchMasterDTO);
        if (branchMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new branchMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BranchMasterDTO result = branchMasterService.save(branchMasterDTO);
        return ResponseEntity.created(new URI("/api/branch-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /branch-masters} : Updates an existing branchMaster.
     *
     * @param branchMasterDTO the branchMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated branchMasterDTO,
     * or with status {@code 400 (Bad Request)} if the branchMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the branchMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/branch-masters")
    public ResponseEntity<BranchMasterDTO> updateBranchMaster(@Valid @RequestBody BranchMasterDTO branchMasterDTO) throws URISyntaxException {
        log.debug("REST request to update BranchMaster : {}", branchMasterDTO);
        if (branchMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BranchMasterDTO result = branchMasterService.save(branchMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, branchMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /branch-masters} : get all the branchMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of branchMasters in body.
     */
    @GetMapping("/branch-masters")
    public ResponseEntity<List<BranchMasterDTO>> getAllBranchMasters(BranchMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BranchMasters by criteria: {}", criteria);
        Page<BranchMasterDTO> page = branchMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /branch-masters/count} : count all the branchMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/branch-masters/count")
    public ResponseEntity<Long> countBranchMasters(BranchMasterCriteria criteria) {
        log.debug("REST request to count BranchMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(branchMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /branch-masters/:id} : get the "id" branchMaster.
     *
     * @param id the id of the branchMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the branchMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/branch-masters/{id}")
    public ResponseEntity<BranchMasterDTO> getBranchMaster(@PathVariable Long id) {
        log.debug("REST request to get BranchMaster : {}", id);
        Optional<BranchMasterDTO> branchMasterDTO = branchMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(branchMasterDTO);
    }

    /**
     * {@code DELETE  /branch-masters/:id} : delete the "id" branchMaster.
     *
     * @param id the id of the branchMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/branch-masters/{id}")
    public ResponseEntity<Void> deleteBranchMaster(@PathVariable Long id) {
        log.debug("REST request to delete BranchMaster : {}", id);

        branchMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/branch-masters?query=:query} : search for the branchMaster corresponding
     * to the query.
     *
     * @param query the query of the branchMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/branch-masters")
    public ResponseEntity<List<BranchMasterDTO>> searchBranchMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of BranchMasters for query {}", query);
        Page<BranchMasterDTO> page = branchMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
