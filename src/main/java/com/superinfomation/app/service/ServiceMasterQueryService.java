package com.superinfomation.app.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.superinfomation.app.domain.ServiceMaster;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.ServiceMasterRepository;
import com.superinfomation.app.repository.search.ServiceMasterSearchRepository;
import com.superinfomation.app.service.dto.ServiceMasterCriteria;
import com.superinfomation.app.service.dto.ServiceMasterDTO;
import com.superinfomation.app.service.mapper.ServiceMasterMapper;

/**
 * Service for executing complex queries for {@link ServiceMaster} entities in the database.
 * The main input is a {@link ServiceMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ServiceMasterDTO} or a {@link Page} of {@link ServiceMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ServiceMasterQueryService extends QueryService<ServiceMaster> {

    private final Logger log = LoggerFactory.getLogger(ServiceMasterQueryService.class);

    private final ServiceMasterRepository serviceMasterRepository;

    private final ServiceMasterMapper serviceMasterMapper;

    private final ServiceMasterSearchRepository serviceMasterSearchRepository;

    public ServiceMasterQueryService(ServiceMasterRepository serviceMasterRepository, ServiceMasterMapper serviceMasterMapper, ServiceMasterSearchRepository serviceMasterSearchRepository) {
        this.serviceMasterRepository = serviceMasterRepository;
        this.serviceMasterMapper = serviceMasterMapper;
        this.serviceMasterSearchRepository = serviceMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link ServiceMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ServiceMasterDTO> findByCriteria(ServiceMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ServiceMaster> specification = createSpecification(criteria);
        return serviceMasterMapper.toDto(serviceMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ServiceMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ServiceMasterDTO> findByCriteria(ServiceMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ServiceMaster> specification = createSpecification(criteria);
        return serviceMasterRepository.findAll(specification, page)
            .map(serviceMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ServiceMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ServiceMaster> specification = createSpecification(criteria);
        return serviceMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link ServiceMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ServiceMaster> createSpecification(ServiceMasterCriteria criteria) {
        Specification<ServiceMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ServiceMaster_.id));
            }
            if (criteria.getServiceCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getServiceCode(), ServiceMaster_.serviceCode));
            }
            if (criteria.getServiceName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getServiceName(), ServiceMaster_.serviceName));
            }
            if (criteria.getDimensioncharge() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDimensioncharge(), ServiceMaster_.dimensioncharge));
            }
        }
        return specification;
    }
}
