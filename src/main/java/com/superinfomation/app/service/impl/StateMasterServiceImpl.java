package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.StateMasterService;
import com.superinfomation.app.domain.StateMaster;
import com.superinfomation.app.repository.StateMasterRepository;
import com.superinfomation.app.repository.search.StateMasterSearchRepository;
import com.superinfomation.app.service.dto.StateMasterDTO;
import com.superinfomation.app.service.mapper.StateMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link StateMaster}.
 */
@Service
@Transactional
public class StateMasterServiceImpl implements StateMasterService {

    private final Logger log = LoggerFactory.getLogger(StateMasterServiceImpl.class);

    private final StateMasterRepository stateMasterRepository;

    private final StateMasterMapper stateMasterMapper;

    private final StateMasterSearchRepository stateMasterSearchRepository;

    public StateMasterServiceImpl(StateMasterRepository stateMasterRepository, StateMasterMapper stateMasterMapper, StateMasterSearchRepository stateMasterSearchRepository) {
        this.stateMasterRepository = stateMasterRepository;
        this.stateMasterMapper = stateMasterMapper;
        this.stateMasterSearchRepository = stateMasterSearchRepository;
    }

    /**
     * Save a stateMaster.
     *
     * @param stateMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StateMasterDTO save(StateMasterDTO stateMasterDTO) {
        log.debug("Request to save StateMaster : {}", stateMasterDTO);
        StateMaster stateMaster = stateMasterMapper.toEntity(stateMasterDTO);
        stateMaster = stateMasterRepository.save(stateMaster);
        StateMasterDTO result = stateMasterMapper.toDto(stateMaster);
        stateMasterSearchRepository.save(stateMaster);
        return result;
    }

    /**
     * Get all the stateMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StateMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StateMasters");
        return stateMasterRepository.findAll(pageable)
            .map(stateMasterMapper::toDto);
    }


    /**
     * Get one stateMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StateMasterDTO> findOne(Long id) {
        log.debug("Request to get StateMaster : {}", id);
        return stateMasterRepository.findById(id)
            .map(stateMasterMapper::toDto);
    }

    /**
     * Delete the stateMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StateMaster : {}", id);

        stateMasterRepository.deleteById(id);
        stateMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the stateMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StateMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of StateMasters for query {}", query);
        return stateMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(stateMasterMapper::toDto);
    }
}
