package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.BranchMasterService;
import com.superinfomation.app.domain.BranchMaster;
import com.superinfomation.app.repository.BranchMasterRepository;
import com.superinfomation.app.repository.search.BranchMasterSearchRepository;
import com.superinfomation.app.service.dto.BranchMasterDTO;
import com.superinfomation.app.service.mapper.BranchMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link BranchMaster}.
 */
@Service
@Transactional
public class BranchMasterServiceImpl implements BranchMasterService {

    private final Logger log = LoggerFactory.getLogger(BranchMasterServiceImpl.class);

    private final BranchMasterRepository branchMasterRepository;

    private final BranchMasterMapper branchMasterMapper;

    private final BranchMasterSearchRepository branchMasterSearchRepository;

    public BranchMasterServiceImpl(BranchMasterRepository branchMasterRepository, BranchMasterMapper branchMasterMapper, BranchMasterSearchRepository branchMasterSearchRepository) {
        this.branchMasterRepository = branchMasterRepository;
        this.branchMasterMapper = branchMasterMapper;
        this.branchMasterSearchRepository = branchMasterSearchRepository;
    }

    /**
     * Save a branchMaster.
     *
     * @param branchMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BranchMasterDTO save(BranchMasterDTO branchMasterDTO) {
        log.debug("Request to save BranchMaster : {}", branchMasterDTO);
        BranchMaster branchMaster = branchMasterMapper.toEntity(branchMasterDTO);
        branchMaster = branchMasterRepository.save(branchMaster);
        BranchMasterDTO result = branchMasterMapper.toDto(branchMaster);
        branchMasterSearchRepository.save(branchMaster);
        return result;
    }

    /**
     * Get all the branchMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BranchMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BranchMasters");
        return branchMasterRepository.findAll(pageable)
            .map(branchMasterMapper::toDto);
    }


    /**
     * Get one branchMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BranchMasterDTO> findOne(Long id) {
        log.debug("Request to get BranchMaster : {}", id);
        return branchMasterRepository.findById(id)
            .map(branchMasterMapper::toDto);
    }

    /**
     * Delete the branchMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BranchMaster : {}", id);

        branchMasterRepository.deleteById(id);
        branchMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the branchMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BranchMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of BranchMasters for query {}", query);
        return branchMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(branchMasterMapper::toDto);
    }
}
