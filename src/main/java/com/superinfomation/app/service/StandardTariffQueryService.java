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

import com.superinfomation.app.domain.StandardTariff;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.StandardTariffRepository;
import com.superinfomation.app.repository.search.StandardTariffSearchRepository;
import com.superinfomation.app.service.dto.StandardTariffCriteria;
import com.superinfomation.app.service.dto.StandardTariffDTO;
import com.superinfomation.app.service.mapper.StandardTariffMapper;

/**
 * Service for executing complex queries for {@link StandardTariff} entities in the database.
 * The main input is a {@link StandardTariffCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StandardTariffDTO} or a {@link Page} of {@link StandardTariffDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StandardTariffQueryService extends QueryService<StandardTariff> {

    private final Logger log = LoggerFactory.getLogger(StandardTariffQueryService.class);

    private final StandardTariffRepository standardTariffRepository;

    private final StandardTariffMapper standardTariffMapper;

    private final StandardTariffSearchRepository standardTariffSearchRepository;

    public StandardTariffQueryService(StandardTariffRepository standardTariffRepository, StandardTariffMapper standardTariffMapper, StandardTariffSearchRepository standardTariffSearchRepository) {
        this.standardTariffRepository = standardTariffRepository;
        this.standardTariffMapper = standardTariffMapper;
        this.standardTariffSearchRepository = standardTariffSearchRepository;
    }

    /**
     * Return a {@link List} of {@link StandardTariffDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StandardTariffDTO> findByCriteria(StandardTariffCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<StandardTariff> specification = createSpecification(criteria);
        return standardTariffMapper.toDto(standardTariffRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StandardTariffDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StandardTariffDTO> findByCriteria(StandardTariffCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<StandardTariff> specification = createSpecification(criteria);
        return standardTariffRepository.findAll(specification, page)
            .map(standardTariffMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StandardTariffCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<StandardTariff> specification = createSpecification(criteria);
        return standardTariffRepository.count(specification);
    }

    /**
     * Function to convert {@link StandardTariffCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<StandardTariff> createSpecification(StandardTariffCriteria criteria) {
        Specification<StandardTariff> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), StandardTariff_.id));
            }
            if (criteria.getFromWeight() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFromWeight(), StandardTariff_.fromWeight));
            }
            if (criteria.getToWeight() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getToWeight(), StandardTariff_.toWeight));
            }
            if (criteria.getDox() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDox(), StandardTariff_.dox));
            }
            if (criteria.getnDox() != null) {
                specification = specification.and(buildStringSpecification(criteria.getnDox(), StandardTariff_.nDox));
            }
            if (criteria.getNetworkMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getNetworkMasterId(),
                    root -> root.join(StandardTariff_.networkMaster, JoinType.LEFT).get(NetworkMaster_.id)));
            }
            if (criteria.getServiceMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getServiceMasterId(),
                    root -> root.join(StandardTariff_.serviceMaster, JoinType.LEFT).get(ServiceMaster_.id)));
            }
            if (criteria.getCityMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCityMasterId(),
                    root -> root.join(StandardTariff_.cityMaster, JoinType.LEFT).get(CityMaster_.id)));
            }
            
        }
        return specification;
    }
}
