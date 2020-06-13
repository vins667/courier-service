package com.superinfomation.app.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import com.superinfomation.app.domain.ZoneMaster;
import com.superinfomation.app.domain.ZoneMaster_;
import com.superinfomation.app.model.ZoneMasterSearch;
import com.superinfomation.app.repository.ZoneMasterRepository;
import com.superinfomation.app.service.dto.ZoneMasterCriteria;
import com.superinfomation.app.service.dto.ZoneMasterDTO;
import com.superinfomation.app.service.mapper.ZoneMasterMapper;

import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ZoneMaster} entities in the database.
 * The main input is a {@link ZoneMasterCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ZoneMasterDTO} or a {@link Page} of {@link ZoneMasterDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ZoneMasterQueryService extends QueryService<ZoneMaster> {

    private final Logger log = LoggerFactory.getLogger(ZoneMasterQueryService.class);

    private final ZoneMasterRepository zoneMasterRepository;

    private final ZoneMasterMapper zoneMasterMapper;

    public ZoneMasterQueryService(ZoneMasterRepository zoneMasterRepository, ZoneMasterMapper zoneMasterMapper) {
        this.zoneMasterRepository = zoneMasterRepository;
        this.zoneMasterMapper = zoneMasterMapper;
    }

    /**
     * Return a {@link List} of {@link ZoneMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ZoneMasterDTO> findByCriteria(ZoneMasterCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ZoneMaster> specification = createSpecification(criteria);
        return zoneMasterMapper.toDto(zoneMasterRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ZoneMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ZoneMasterDTO> findByCriteria(ZoneMasterCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ZoneMaster> specification = createSpecification(criteria);
        return zoneMasterRepository.findAll(specification, page)
            .map(zoneMasterMapper::toDto);
    }
    
    
    /**
     * Return a {@link Page} of {@link ZoneMasterDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ZoneMasterDTO> findAllByFilter(ZoneMasterSearch zoneMasterSearch) {
        log.debug("find by criteria : {}, page: {}", zoneMasterSearch);
        String zonecode = "%";
        if(zoneMasterSearch.getZoneCode() != null && !zoneMasterSearch.getZoneCode().equalsIgnoreCase("undefined")) {
        	zonecode = "%"+zoneMasterSearch.getZoneCode().toUpperCase()+"%";
        }
        String zonename = "%";
        if(zoneMasterSearch.getZoneName() != null && !zoneMasterSearch.getZoneName().equalsIgnoreCase("undefined")) {
        	zonename = "%"+zoneMasterSearch.getZoneName().toUpperCase()+"%";
        }
        zoneMasterSearch.setPage(PageRequest.of(zoneMasterSearch.getPageNo(), zoneMasterSearch.getSize(),Sort.by("createdDate").descending()));
        Page<ZoneMaster> page = zoneMasterRepository.findAllByFilter(zonecode, zonename, zoneMasterSearch.getPage());
        return page.map(zoneMasterMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ZoneMasterCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ZoneMaster> specification = createSpecification(criteria);
        return zoneMasterRepository.count(specification);
    }

    /**
     * Function to convert {@link ZoneMasterCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ZoneMaster> createSpecification(ZoneMasterCriteria criteria) {
        Specification<ZoneMaster> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ZoneMaster_.id));
            }
            if (criteria.getZoneCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getZoneCode(), ZoneMaster_.zoneCode));
            }
            if (criteria.getZoneName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getZoneName(), ZoneMaster_.zoneName));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), ZoneMaster_.createdBy));
            }
            if (criteria.getCreatedDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedDate(), ZoneMaster_.createdDate));
            }
            if (criteria.getLastUpdatedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastUpdatedBy(), ZoneMaster_.lastUpdatedBy));
            }
            if (criteria.getLastUpdatedDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLastUpdatedDate(), ZoneMaster_.lastUpdatedDate));
            }
        }
        return specification;
    }
}
