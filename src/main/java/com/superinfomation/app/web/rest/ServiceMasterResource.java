package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.ServiceMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.ServiceMasterDTO;
import com.superinfomation.app.service.dto.ServiceMasterCriteria;
import com.superinfomation.app.service.ServiceMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.ServiceMaster}.
 */
@RestController
@RequestMapping("/api")
public class ServiceMasterResource {

    private final Logger log = LoggerFactory.getLogger(ServiceMasterResource.class);

    private static final String ENTITY_NAME = "serviceMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ServiceMasterService serviceMasterService;

    private final ServiceMasterQueryService serviceMasterQueryService;

    public ServiceMasterResource(ServiceMasterService serviceMasterService, ServiceMasterQueryService serviceMasterQueryService) {
        this.serviceMasterService = serviceMasterService;
        this.serviceMasterQueryService = serviceMasterQueryService;
    }

    /**
     * {@code POST  /service-masters} : Create a new serviceMaster.
     *
     * @param serviceMasterDTO the serviceMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new serviceMasterDTO, or with status {@code 400 (Bad Request)} if the serviceMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/service-masters")
    public ResponseEntity<ServiceMasterDTO> createServiceMaster(@Valid @RequestBody ServiceMasterDTO serviceMasterDTO) throws URISyntaxException {
        log.debug("REST request to save ServiceMaster : {}", serviceMasterDTO);
        if (serviceMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new serviceMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ServiceMasterDTO result = serviceMasterService.save(serviceMasterDTO);
        return ResponseEntity.created(new URI("/api/service-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /service-masters} : Updates an existing serviceMaster.
     *
     * @param serviceMasterDTO the serviceMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated serviceMasterDTO,
     * or with status {@code 400 (Bad Request)} if the serviceMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the serviceMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/service-masters")
    public ResponseEntity<ServiceMasterDTO> updateServiceMaster(@Valid @RequestBody ServiceMasterDTO serviceMasterDTO) throws URISyntaxException {
        log.debug("REST request to update ServiceMaster : {}", serviceMasterDTO);
        if (serviceMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ServiceMasterDTO result = serviceMasterService.save(serviceMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, serviceMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /service-masters} : get all the serviceMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of serviceMasters in body.
     */
    @GetMapping("/service-masters")
    public ResponseEntity<List<ServiceMasterDTO>> getAllServiceMasters(ServiceMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ServiceMasters by criteria: {}", criteria);
        Page<ServiceMasterDTO> page = serviceMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /service-masters/count} : count all the serviceMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/service-masters/count")
    public ResponseEntity<Long> countServiceMasters(ServiceMasterCriteria criteria) {
        log.debug("REST request to count ServiceMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(serviceMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /service-masters/:id} : get the "id" serviceMaster.
     *
     * @param id the id of the serviceMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the serviceMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/service-masters/{id}")
    public ResponseEntity<ServiceMasterDTO> getServiceMaster(@PathVariable Long id) {
        log.debug("REST request to get ServiceMaster : {}", id);
        Optional<ServiceMasterDTO> serviceMasterDTO = serviceMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(serviceMasterDTO);
    }

    /**
     * {@code DELETE  /service-masters/:id} : delete the "id" serviceMaster.
     *
     * @param id the id of the serviceMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/service-masters/{id}")
    public ResponseEntity<Void> deleteServiceMaster(@PathVariable Long id) {
        log.debug("REST request to delete ServiceMaster : {}", id);

        serviceMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/service-masters?query=:query} : search for the serviceMaster corresponding
     * to the query.
     *
     * @param query the query of the serviceMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/service-masters")
    public ResponseEntity<List<ServiceMasterDTO>> searchServiceMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of ServiceMasters for query {}", query);
        Page<ServiceMasterDTO> page = serviceMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
