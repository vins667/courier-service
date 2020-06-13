package com.superinfomation.app.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.superinfomation.app.model.ZoneMasterSearch;
import com.superinfomation.app.security.SecurityUtils;
import com.superinfomation.app.service.ZoneMasterQueryService;
import com.superinfomation.app.service.ZoneMasterService;
import com.superinfomation.app.service.dto.ZoneMasterCriteria;
import com.superinfomation.app.service.dto.ZoneMasterDTO;
import com.superinfomation.app.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.superinfomation.app.domain.ZoneMaster}.
 */
@RestController
@RequestMapping("/api")
public class ZoneMasterResource {

    private final Logger log = LoggerFactory.getLogger(ZoneMasterResource.class);

    private static final String ENTITY_NAME = "zoneMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ZoneMasterService zoneMasterService;

    private final ZoneMasterQueryService zoneMasterQueryService;

    public ZoneMasterResource(ZoneMasterService zoneMasterService, ZoneMasterQueryService zoneMasterQueryService) {
        this.zoneMasterService = zoneMasterService;
        this.zoneMasterQueryService = zoneMasterQueryService;
    }

    /**
     * {@code POST  /zone-masters} : Create a new zoneMaster.
     *
     * @param zoneMasterDTO the zoneMasterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new zoneMasterDTO, or with status {@code 400 (Bad Request)} if the zoneMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/zone-masters")
    public ResponseEntity<ZoneMasterDTO> createZoneMaster(@Valid @RequestBody ZoneMasterDTO zoneMasterDTO) throws URISyntaxException {
        log.debug("REST request to save ZoneMaster : {}", zoneMasterDTO);
        if (zoneMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new zoneMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        zoneMasterDTO.setCreatedBy(SecurityUtils.getCurrentUserLogin().orElse(null));
        zoneMasterDTO.setCreatedDate(ZonedDateTime.now().toLocalDate());
        ZoneMasterDTO result = zoneMasterService.save(zoneMasterDTO);
        return ResponseEntity.created(new URI("/api/zone-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /zone-masters} : Updates an existing zoneMaster.
     *
     * @param zoneMasterDTO the zoneMasterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated zoneMasterDTO,
     * or with status {@code 400 (Bad Request)} if the zoneMasterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the zoneMasterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/zone-masters")
    public ResponseEntity<ZoneMasterDTO> updateZoneMaster(@Valid @RequestBody ZoneMasterDTO zoneMasterDTO) throws URISyntaxException {
        log.debug("REST request to update ZoneMaster : {}", zoneMasterDTO);
        if (zoneMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        zoneMasterDTO.setLastUpdatedBy(SecurityUtils.getCurrentUserLogin().orElse(null));
        zoneMasterDTO.setLastUpdatedDate(ZonedDateTime.now().toLocalDate());
        ZoneMasterDTO result = zoneMasterService.save(zoneMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, zoneMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /zone-masters} : get all the zoneMasters.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of zoneMasters in body.
     */
    @GetMapping("/zone-masters")
    public ResponseEntity<List<ZoneMasterDTO>> getAllZoneMasters(ZoneMasterCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ZoneMasters by criteria: {}", criteria);
        Page<ZoneMasterDTO> page = zoneMasterQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * {@code POST  /zone-masters-filter} : get all the zoneMasters by filter.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of zoneMasters in body.
     */
    @PostMapping("/zone-masters-filter")
    public ResponseEntity<List<ZoneMasterDTO>> getAllZoneMastersByFilter(@RequestBody ZoneMasterSearch zoneMasterSearch) {
        log.debug("REST request to get ZoneMasters by criteria: {}", zoneMasterSearch);
        Page<ZoneMasterDTO> page = zoneMasterQueryService.findAllByFilter(zoneMasterSearch);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /zone-masters/count} : count all the zoneMasters.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/zone-masters/count")
    public ResponseEntity<Long> countZoneMasters(ZoneMasterCriteria criteria) {
        log.debug("REST request to count ZoneMasters by criteria: {}", criteria);
        return ResponseEntity.ok().body(zoneMasterQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /zone-masters/:id} : get the "id" zoneMaster.
     *
     * @param id the id of the zoneMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the zoneMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/zone-masters/{id}")
    public ResponseEntity<ZoneMasterDTO> getZoneMaster(@PathVariable Long id) {
        log.debug("REST request to get ZoneMaster : {}", id);
        Optional<ZoneMasterDTO> zoneMasterDTO = zoneMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(zoneMasterDTO);
    }

    /**
     * {@code DELETE  /zone-masters/:id} : delete the "id" zoneMaster.
     *
     * @param id the id of the zoneMasterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/zone-masters/{id}")
    public ResponseEntity<Void> deleteZoneMaster(@PathVariable Long id) {
        log.debug("REST request to delete ZoneMaster : {}", id);

        zoneMasterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
