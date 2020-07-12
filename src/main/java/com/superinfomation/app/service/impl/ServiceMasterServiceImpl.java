package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.ServiceMasterService;
import com.superinfomation.app.domain.ServiceMaster;
import com.superinfomation.app.repository.ServiceMasterRepository;
import com.superinfomation.app.repository.search.ServiceMasterSearchRepository;
import com.superinfomation.app.service.dto.ServiceMasterDTO;
import com.superinfomation.app.service.mapper.ServiceMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link ServiceMaster}.
 */
@Service
@Transactional
public class ServiceMasterServiceImpl implements ServiceMasterService {

    private final Logger log = LoggerFactory.getLogger(ServiceMasterServiceImpl.class);

    private final ServiceMasterRepository serviceMasterRepository;

    private final ServiceMasterMapper serviceMasterMapper;

    private final ServiceMasterSearchRepository serviceMasterSearchRepository;

    public ServiceMasterServiceImpl(ServiceMasterRepository serviceMasterRepository, ServiceMasterMapper serviceMasterMapper, ServiceMasterSearchRepository serviceMasterSearchRepository) {
        this.serviceMasterRepository = serviceMasterRepository;
        this.serviceMasterMapper = serviceMasterMapper;
        this.serviceMasterSearchRepository = serviceMasterSearchRepository;
    }

    /**
     * Save a serviceMaster.
     *
     * @param serviceMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ServiceMasterDTO save(ServiceMasterDTO serviceMasterDTO) {
        log.debug("Request to save ServiceMaster : {}", serviceMasterDTO);
        ServiceMaster serviceMaster = serviceMasterMapper.toEntity(serviceMasterDTO);
        serviceMaster = serviceMasterRepository.save(serviceMaster);
        ServiceMasterDTO result = serviceMasterMapper.toDto(serviceMaster);
        serviceMasterSearchRepository.save(serviceMaster);
        return result;
    }

    /**
     * Get all the serviceMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ServiceMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ServiceMasters");
        return serviceMasterRepository.findAll(pageable)
            .map(serviceMasterMapper::toDto);
    }


    /**
     * Get one serviceMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ServiceMasterDTO> findOne(Long id) {
        log.debug("Request to get ServiceMaster : {}", id);
        return serviceMasterRepository.findById(id)
            .map(serviceMasterMapper::toDto);
    }

    /**
     * Delete the serviceMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ServiceMaster : {}", id);

        serviceMasterRepository.deleteById(id);
        serviceMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the serviceMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ServiceMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of ServiceMasters for query {}", query);
        return serviceMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(serviceMasterMapper::toDto);
    }
}
