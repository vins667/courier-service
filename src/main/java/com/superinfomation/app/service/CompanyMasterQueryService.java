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

import com.superinfomation.app.domain.CompanyMaster;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.CompanyMasterRepository;
import com.superinfomation.app.repository.search.CompanyMasterSearchRepository;
import com.superinfomation.app.service.dto.CompanyMasterCriteria;
import com.superinfomation.app.service.dto.CompanyMasterDTO;
import com.superinfomation.app.service.mapper.CompanyMasterMapper;

/**
 * Service for executing complex queries for {@link CompanyMaster} entities in the database.
 * The main input is a {@link CompanyMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CompanyMasterDTO} or a {@link Page} of {@link CompanyMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CompanyMasterQueryService extends QueryService<CompanyMaster> {

    private final Logger log = LoggerFactory.getLogger(CompanyMasterQueryService.class);

    private final CompanyMasterRepository companyMasterRepository;

    private final CompanyMasterMapper companyMasterMapper;

    private final CompanyMasterSearchRepository companyMasterSearchRepository;

    public CompanyMasterQueryService(CompanyMasterRepository companyMasterRepository, CompanyMasterMapper companyMasterMapper, CompanyMasterSearchRepository companyMasterSearchRepository) {
        this.companyMasterRepository = companyMasterRepository;
        this.companyMasterMapper = companyMasterMapper;
        this.companyMasterSearchRepository = companyMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link CompanyMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CompanyMasterDTO> findByCriteria(CompanyMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CompanyMaster> specification = createSpecification(criteria);
        return companyMasterMapper.toDto(companyMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CompanyMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CompanyMasterDTO> findByCriteria(CompanyMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CompanyMaster> specification = createSpecification(criteria);
        return companyMasterRepository.findAll(specification, page)
            .map(companyMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CompanyMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CompanyMaster> specification = createSpecification(criteria);
        return companyMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link CompanyMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<CompanyMaster> createSpecification(CompanyMasterCriteria criteria) {
        Specification<CompanyMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), CompanyMaster_.id));
            }
            if (criteria.getCompanyName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCompanyName(), CompanyMaster_.companyName));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddress(), CompanyMaster_.address));
            }
            if (criteria.getPinCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPinCode(), CompanyMaster_.pinCode));
            }
            if (criteria.getMdName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMdName(), CompanyMaster_.mdName));
            }
            if (criteria.getMdContactNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMdContactNo(), CompanyMaster_.mdContactNo));
            }
            if (criteria.getMdEmailId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMdEmailId(), CompanyMaster_.mdEmailId));
            }
            if (criteria.getPanNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPanNumber(), CompanyMaster_.panNumber));
            }
            if (criteria.getWebSiteUrl() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWebSiteUrl(), CompanyMaster_.webSiteUrl));
            }
            if (criteria.getTinNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTinNumber(), CompanyMaster_.tinNumber));
            }
            if (criteria.getGstNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGstNumber(), CompanyMaster_.gstNumber));
            }
            if (criteria.getStateMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getStateMasterId(),
                    root -> root.join(CompanyMaster_.stateMaster, JoinType.LEFT).get(StateMaster_.id)));
            }
            if (criteria.getCountryMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCountryMasterId(),
                    root -> root.join(CompanyMaster_.countryMaster, JoinType.LEFT).get(CountryMaster_.id)));
            }
            if (criteria.getCityMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCityMasterId(),
                    root -> root.join(CompanyMaster_.cityMaster, JoinType.LEFT).get(CityMaster_.id)));
            }
        }
        return specification;
    }
}
