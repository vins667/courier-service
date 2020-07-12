package com.superinfomation.app.web.rest;

import com.superinfomation.app.service.NetworkMasterService;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import com.superinfomation.app.service.dto.NetworkMasterDTO;
import com.superinfomation.app.service.dto.NetworkMasterCriteria;
import com.superinfomation.app.service.NetworkMasterQueryService;

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
 * REST controller for managing {@link com.superinfomation.app.domain.NetworkMaster}.
 */
@RestController
@RequestMapping("/api")
public class NetworkMasterResource {

    private final Logger log = LoggerFactory.getLogger(NetworkMasterResource.class);

    private static final String ENTITY_NAME = "networkMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NetworkMasterService networkMasterService;

    private final NetworkMasterQueryService networkMasterQueryService;

    public NetworkMasterResource(NetworkMasterService networkMasterService, NetworkMasterQueryService networkMasterQueryService) {
        this.networkMasterService = networkMasterService;
        this.networkMasterQueryService = networkMasterQueryService;
    }

    /**
     * {@code POST  /network-masters} : Create a new networkMaster.
     *
     * @param networkMasterDTO the networkMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new networkMasterDTO, or with status {@code 400 (Bad Request)} if the networkMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/network-masters")
    public ResponseEntity<NetworkMasterDTO> createNetworkMaster(@Valid @RequestBody NetworkMasterDTO networkMasterDTO) throws URISyntaxException {
        log.debug("REST request to save NetworkMaster : {}", networkMasterDTO);
        if (networkMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new networkMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NetworkMasterDTO result = networkMasterService.save(networkMasterDTO);
        return ResponseEntity.created(new URI("/api/network-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /network-masters} : Updates an existing networkMaster.
     *
     * @param networkMasterDTO the networkMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated networkMasterDTO,
     * or with status {@code 400 (Bad Request)} if the networkMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the networkMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/network-masters")
    public ResponseEntity<NetworkMasterDTO> updateNetworkMaster(@Valid @RequestBody NetworkMasterDTO networkMasterDTO) throws URISyntaxException {
        log.debug("REST request to update NetworkMaster : {}", networkMasterDTO);
        if (networkMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NetworkMasterDTO result = networkMasterService.save(networkMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, networkMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /network-masters} : get all the networkMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of networkMasters in body.
     */
    @GetMapping("/network-masters")
    public ResponseEntity<List<NetworkMasterDTO>> getAllNetworkMasters(NetworkMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get NetworkMasters by criteria: {}", criteria);
        Page<NetworkMasterDTO> page = networkMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /network-masters/count} : count all the networkMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/network-masters/count")
    public ResponseEntity<Long> countNetworkMasters(NetworkMasterCriteria criteria) {
        log.debug("REST request to count NetworkMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(networkMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /network-masters/:id} : get the "id" networkMaster.
     *
     * @param id the id of the networkMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the networkMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/network-masters/{id}")
    public ResponseEntity<NetworkMasterDTO> getNetworkMaster(@PathVariable Long id) {
        log.debug("REST request to get NetworkMaster : {}", id);
        Optional<NetworkMasterDTO> networkMasterDTO = networkMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(networkMasterDTO);
    }

    /**
     * {@code DELETE  /network-masters/:id} : delete the "id" networkMaster.
     *
     * @param id the id of the networkMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/network-masters/{id}")
    public ResponseEntity<Void> deleteNetworkMaster(@PathVariable Long id) {
        log.debug("REST request to delete NetworkMaster : {}", id);

        networkMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/network-masters?query=:query} : search for the networkMaster corresponding
     * to the query.
     *
     * @param query the query of the networkMaster search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/network-masters")
    public ResponseEntity<List<NetworkMasterDTO>> searchNetworkMasters(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of NetworkMasters for query {}", query);
        Page<NetworkMasterDTO> page = networkMasterService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
