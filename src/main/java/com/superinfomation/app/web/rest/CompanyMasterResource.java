package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.CompanyMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.CompanyMasterDTO;
import com.superinfomation.app.service.dto.CompanyMasterCriteria;
import com.superinfomation.app.service.CompanyMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.CompanyMaster}.
 */
@RestController
@RequestMapping("/api")
public class CompanyMasterResource {

    private final Logger log = LoggerFactory.getLogger(CompanyMasterResource.class);

    private static final String ENTITY_NAME = "companyMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CompanyMasterService companyMasterService;

    private final CompanyMasterQueryService companyMasterQueryService;

    public CompanyMasterResource(CompanyMasterService companyMasterService, CompanyMasterQueryService companyMasterQueryService) {
        this.companyMasterService = companyMasterService;
        this.companyMasterQueryService = companyMasterQueryService;
    }

    /**
     * {@code POST  /company-masters} : Create a new companyMaster.
     *
     * @param companyMasterDTO the companyMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new companyMasterDTO, or with status {@code 400 (Bad Request)} if the companyMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/company-masters")
    public ResponseEntity<CompanyMasterDTO> createCompanyMaster(@Valid @RequestBody CompanyMasterDTO companyMasterDTO) throws URISyntaxException {
        log.debug("REST request to save CompanyMaster : {}", companyMasterDTO);
        if (companyMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new companyMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompanyMasterDTO result = companyMasterService.save(companyMasterDTO);
        return ResponseEntity.created(new URI("/api/company-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /company-masters} : Updates an existing companyMaster.
     *
     * @param companyMasterDTO the companyMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated companyMasterDTO,
     * or with status {@code 400 (Bad Request)} if the companyMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the companyMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/company-masters")
    public ResponseEntity<CompanyMasterDTO> updateCompanyMaster(@Valid @RequestBody CompanyMasterDTO companyMasterDTO) throws URISyntaxException {
        log.debug("REST request to update CompanyMaster : {}", companyMasterDTO);
        if (companyMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompanyMasterDTO result = companyMasterService.save(companyMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, companyMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /company-masters} : get all the companyMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of companyMasters in body.
     */
    @GetMapping("/company-masters")
    public ResponseEntity<List<CompanyMasterDTO>> getAllCompanyMasters(CompanyMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get CompanyMasters by criteria: {}", criteria);
        Page<CompanyMasterDTO> page = companyMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /company-masters/count} : count all the companyMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/company-masters/count")
    public ResponseEntity<Long> countCompanyMasters(CompanyMasterCriteria criteria) {
        log.debug("REST request to count CompanyMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(companyMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /company-masters/:id} : get the "id" companyMaster.
     *
     * @param id the id of the companyMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the companyMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/company-masters/{id}")
    public ResponseEntity<CompanyMasterDTO> getCompanyMaster(@PathVariable Long id) {
        log.debug("REST request to get CompanyMaster : {}", id);
        Optional<CompanyMasterDTO> companyMasterDTO = companyMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(companyMasterDTO);
    }

    /**
     * {@code DELETE  /company-masters/:id} : delete the "id" companyMaster.
     *
     * @param id the id of the companyMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/company-masters/{id}")
    public ResponseEntity<Void> deleteCompanyMaster(@PathVariable Long id) {
        log.debug("REST request to delete CompanyMaster : {}", id);

        companyMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/company-masters?query=:query} : search for the companyMaster corresponding
     * to the query.
     *
     * @param query the query of the companyMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/company-masters")
    public ResponseEntity<List<CompanyMasterDTO>> searchCompanyMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of CompanyMasters for query {}", query);
        Page<CompanyMasterDTO> page = companyMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
