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

// for static metamodels
import com.superinfomation.app.domain.CityMaster_;
import com.superinfomation.app.domain.NetworkMaster;
import com.superinfomation.app.domain.NetworkMaster_;
import com.superinfomation.app.repository.NetworkMasterRepository;
import com.superinfomation.app.repository.search.NetworkMasterSearchRepository;
import com.superinfomation.app.service.dto.NetworkMasterCriteria;
import com.superinfomation.app.service.dto.NetworkMasterDTO;
import com.superinfomation.app.service.mapper.NetworkMasterMapper;

import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link NetworkMaster} entities in the database.
 * The main input is a {@link NetworkMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link NetworkMasterDTO} or a {@link Page} of {@link NetworkMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class NetworkMasterQueryService extends QueryService<NetworkMaster> {

    private final Logger log = LoggerFactory.getLogger(NetworkMasterQueryService.class);

    private final NetworkMasterRepository networkMasterRepository;

    private final NetworkMasterMapper networkMasterMapper;

    private final NetworkMasterSearchRepository networkMasterSearchRepository;

    public NetworkMasterQueryService(NetworkMasterRepository networkMasterRepository, NetworkMasterMapper networkMasterMapper, NetworkMasterSearchRepository networkMasterSearchRepository) {
        this.networkMasterRepository = networkMasterRepository;
        this.networkMasterMapper = networkMasterMapper;
        this.networkMasterSearchRepository = networkMasterSearchRepository;
    }

    /**
     * Return a {@link List} of {@link NetworkMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<NetworkMasterDTO> findByCriteria(NetworkMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<NetworkMaster> specification = createSpecification(criteria);
        return networkMasterMapper.toDto(networkMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link NetworkMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<NetworkMasterDTO> findByCriteria(NetworkMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<NetworkMaster> specification = createSpecification(criteria);
        return networkMasterRepository.findAll(specification, page)
            .map(networkMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(NetworkMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<NetworkMaster> specification = createSpecification(criteria);
        return networkMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link NetworkMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<NetworkMaster> createSpecification(NetworkMasterCriteria criteria) {
        Specification<NetworkMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), NetworkMaster_.id));
            }
            if (criteria.getNetworkCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNetworkCode(), NetworkMaster_.networkCode));
            }
            if (criteria.getNetworkName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNetworkName(), NetworkMaster_.networkName));
            }
            if (criteria.getContactPerson() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContactPerson(), NetworkMaster_.contactPerson));
            }
            if (criteria.getContactNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContactNumber(), NetworkMaster_.contactNumber));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddress(), NetworkMaster_.address));
            }
            if (criteria.getWebsite() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWebsite(), NetworkMaster_.website));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), NetworkMaster_.email));
            }
            if (criteria.getCityMasterId() != null) {
                specification = specification.and(buildSpecification(criteria.getCityMasterId(),
                    root -> root.join(NetworkMaster_.cityMaster, JoinType.LEFT).get(CityMaster_.id)));
            }
        }
        return specification;
    }
}
