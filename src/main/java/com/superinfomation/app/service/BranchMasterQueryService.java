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

import com.superinfomation.app.domain.BranchMaster;
import com.superinfomation.app.domain.*; // for static metamodels
import com.superinfomation.app.repository.BranchMasterRepository;
import com.superinfomation.app.repository.search.BranchMasterSearchRepository;
import com.superinfomation.app.service.dto.BranchMasterCriteria;
import com.superinfomation.app.service.dto.BranchMasterDTO;
import com.superinfomation.app.service.mapper.BranchMasterMapper;

/**
 * Service for executing complex queries for {@link BranchMaster} entities in the database.
 * The main input is a {@link BranchMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BranchMasterDTO} or a {@link Page} of {@link BranchMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BranchMasterQueryService extends QueryService<BranchMaster> {

    private final Logger log = LoggerFactory.getLogger(BranchMasterQueryService.class);

    private final BranchMasterRepository branchMasterRepository;

    private final BranchMasterMapper branchMasterMapper;

   // private final BranchMasterSearchRepository branchMasterSearchRepository;

    public BranchMasterQueryService(BranchMasterRepository branchMasterRepository, BranchMasterMapper branchMasterMapper) {
        this.branchMasterRepository = branchMasterRepository;
        this.branchMasterMapper = branchMasterMapper;
//        this.branchMasterSearchRepository = branchMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link BranchMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BranchMasterDTO> findByCriteria(BranchMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<BranchMaster> specification = createSpecification(criteria);
        return branchMasterMapper.toDto(branchMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BranchMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BranchMasterDTO> findByCriteria(BranchMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BranchMaster> specification = createSpecification(criteria);
        return branchMasterRepository.findAll(specification, page)
            .map(branchMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BranchMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<BranchMaster> specification = createSpecification(criteria);
        return branchMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link BranchMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<BranchMaster> createSpecification(BranchMasterCriteria criteria) {
        Specification<BranchMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), BranchMaster_.id));
            }
            if (criteria.getBranchName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBranchName(), BranchMaster_.branchName));
            }
            if (criteria.getManagerName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getManagerName(), BranchMaster_.managerName));
            }
            if (criteria.getPinCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPinCode(), BranchMaster_.pinCode));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddress(), BranchMaster_.address));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), BranchMaster_.email));
            }
            if (criteria.getMobile() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobile(), BranchMaster_.mobile));
            }
            if (criteria.getCompanyMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCompanyMasterId(),
                    root -> root.join(BranchMaster_.companyMaster, JoinType.LEFT).get(CompanyMaster_.id)));
            }
            if (criteria.getCountryMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCountryMasterId(),
                    root -> root.join(BranchMaster_.countryMaster, JoinType.LEFT).get(CountryMaster_.id)));
            }
        }
        return specification;
    }
}
