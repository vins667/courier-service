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

import com.superinfomation.app.domain.StateMaster;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.StateMasterRepository;
import com.superinfomation.app.repository.search.StateMasterSearchRepository;
import com.superinfomation.app.service.dto.StateMasterCriteria;
import com.superinfomation.app.service.dto.StateMasterDTO;
import com.superinfomation.app.service.mapper.StateMasterMapper;

/**
 * Service for executing complex queries for {@link StateMaster} entities in the database.
 * The main input is a {@link StateMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StateMasterDTO} or a {@link Page} of {@link StateMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StateMasterQueryService extends QueryService<StateMaster> {

    private final Logger log = LoggerFactory.getLogger(StateMasterQueryService.class);

    private final StateMasterRepository stateMasterRepository;

    private final StateMasterMapper stateMasterMapper;

    private final StateMasterSearchRepository stateMasterSearchRepository;

    public StateMasterQueryService(StateMasterRepository stateMasterRepository, StateMasterMapper stateMasterMapper, StateMasterSearchRepository stateMasterSearchRepository) {
        this.stateMasterRepository = stateMasterRepository;
        this.stateMasterMapper = stateMasterMapper;
        this.stateMasterSearchRepository = stateMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link StateMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StateMasterDTO> findByCriteria(StateMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<StateMaster> specification = createSpecification(criteria);
        return stateMasterMapper.toDto(stateMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StateMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StateMasterDTO> findByCriteria(StateMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<StateMaster> specification = createSpecification(criteria);
        return stateMasterRepository.findAll(specification, page)
            .map(stateMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StateMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<StateMaster> specification = createSpecification(criteria);
        return stateMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link StateMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<StateMaster> createSpecification(StateMasterCriteria criteria) {
        Specification<StateMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), StateMaster_.id));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), StateMaster_.code));
            }
            if (criteria.getStateName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStateName(), StateMaster_.stateName));
            }
            if (criteria.getCountryMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCountryMasterId(),
                    root -> root.join(StateMaster_.countryMaster, JoinType.LEFT).get(CountryMaster_.id)));
            }
        }
        return specification;
    }
}
