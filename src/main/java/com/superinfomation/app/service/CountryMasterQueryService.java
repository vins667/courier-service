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

import com.superinfomation.app.domain.CountryMaster;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.CountryMasterRepository;
import com.superinfomation.app.repository.search.CountryMasterSearchRepository;
import com.superinfomation.app.service.dto.CountryMasterCriteria;
import com.superinfomation.app.service.dto.CountryMasterDTO;
import com.superinfomation.app.service.mapper.CountryMasterMapper;

/**
 * Service for executing complex queries for {@link CountryMaster} entities in the database.
 * The main input is a {@link CountryMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CountryMasterDTO} or a {@link Page} of {@link CountryMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CountryMasterQueryService extends QueryService<CountryMaster> {

    private final Logger log = LoggerFactory.getLogger(CountryMasterQueryService.class);

    private final CountryMasterRepository countryMasterRepository;

    private final CountryMasterMapper countryMasterMapper;

    private final CountryMasterSearchRepository countryMasterSearchRepository;

    public CountryMasterQueryService(CountryMasterRepository countryMasterRepository, CountryMasterMapper countryMasterMapper, CountryMasterSearchRepository countryMasterSearchRepository) {
        this.countryMasterRepository = countryMasterRepository;
        this.countryMasterMapper = countryMasterMapper;
        this.countryMasterSearchRepository = countryMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link CountryMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CountryMasterDTO> findByCriteria(CountryMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CountryMaster> specification = createSpecification(criteria);
        return countryMasterMapper.toDto(countryMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CountryMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CountryMasterDTO> findByCriteria(CountryMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CountryMaster> specification = createSpecification(criteria);
        return countryMasterRepository.findAll(specification, page)
            .map(countryMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CountryMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CountryMaster> specification = createSpecification(criteria);
        return countryMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link CountryMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CountryMaster> createSpecification(CountryMasterCriteria criteria) {
        Specification<CountryMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CountryMaster_.id));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), CountryMaster_.code));
            }
            if (criteria.getCountryName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCountryName(), CountryMaster_.countryName));
            }
        }
        return specification;
    }
}
