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

import com.superinfomation.app.domain.CityMaster;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.CityMasterRepository;
import com.superinfomation.app.repository.search.CityMasterSearchRepository;
import com.superinfomation.app.service.dto.CityMasterCriteria;
import com.superinfomation.app.service.dto.CityMasterDTO;
import com.superinfomation.app.service.mapper.CityMasterMapper;

/**
 * Service for executing complex queries for {@link CityMaster} entities in the database.
 * The main input is a {@link CityMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CityMasterDTO} or a {@link Page} of {@link CityMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CityMasterQueryService extends QueryService<CityMaster> {

    private final Logger log = LoggerFactory.getLogger(CityMasterQueryService.class);

    private final CityMasterRepository cityMasterRepository;

    private final CityMasterMapper cityMasterMapper;

    private final CityMasterSearchRepository cityMasterSearchRepository;

    public CityMasterQueryService(CityMasterRepository cityMasterRepository, CityMasterMapper cityMasterMapper, CityMasterSearchRepository cityMasterSearchRepository) {
        this.cityMasterRepository = cityMasterRepository;
        this.cityMasterMapper = cityMasterMapper;
        this.cityMasterSearchRepository = cityMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link CityMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CityMasterDTO> findByCriteria(CityMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CityMaster> specification = createSpecification(criteria);
        return cityMasterMapper.toDto(cityMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CityMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CityMasterDTO> findByCriteria(CityMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CityMaster> specification = createSpecification(criteria);
        return cityMasterRepository.findAll(specification, page)
            .map(cityMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CityMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CityMaster> specification = createSpecification(criteria);
        return cityMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link CityMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CityMaster> createSpecification(CityMasterCriteria criteria) {
        Specification<CityMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CityMaster_.id));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCode(), CityMaster_.code));
            }
            if (criteria.getCityName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCityName(), CityMaster_.cityName));
            }
            if (criteria.getPinCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPinCode(), CityMaster_.pinCode));
            }
            if (criteria.getStateMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getStateMasterId(),
                    root -> root.join(CityMaster_.stateMaster, JoinType.LEFT).get(StateMaster_.id)));
            }
          
        }
        return specification;
    }
}
