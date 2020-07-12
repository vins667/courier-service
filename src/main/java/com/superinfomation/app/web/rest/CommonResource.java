package com.superinfomation.app.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.superinfomation.app.service.CommonService;
import com.superinfomation.app.service.dto.CodeDTO;
import com.superinfomation.app.service.dto.ZoneMasterDTO;

import io.github.jhipster.web.util.PaginationUtil;

/**
 * REST controller for managing {@link com.superinfomation.app.domain.ZoneMaster}.
 */
@RestController
@RequestMapping("/api")
public class CommonResource {

    private final Logger log = LoggerFactory.getLogger(CommonResource.class);

    private static final String ENTITY_NAME = "common";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private  CommonService commonService;

    /**
     * {@code GET  /zone-masters/:id} : get the "id" zoneMaster.
     *
     * @param id the id of the zoneMasterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the zoneMasterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/locations/{code}")
    public ResponseEntity<List<CodeDTO>> getLocations(@PathVariable String code) {
        log.debug("REST request to get ZoneMasters by criteria: {}", code);
        List<CodeDTO> codes = commonService.getLocationWiseList(code);
         return ResponseEntity.ok().body(codes);
   }

  
}
