package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.NetworkMasterService;
import com.superinfomation.app.domain.NetworkMaster;
import com.superinfomation.app.repository.NetworkMasterRepository;
import com.superinfomation.app.repository.search.NetworkMasterSearchRepository;
import com.superinfomation.app.service.dto.NetworkMasterDTO;
import com.superinfomation.app.service.mapper.NetworkMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link NetworkMaster}.
 */
@Service
@Transactional
public class NetworkMasterServiceImpl implements NetworkMasterService {

    private final Logger log = LoggerFactory.getLogger(NetworkMasterServiceImpl.class);

    private final NetworkMasterRepository networkMasterRepository;

    private final NetworkMasterMapper networkMasterMapper;

    private final NetworkMasterSearchRepository networkMasterSearchRepository;

    public NetworkMasterServiceImpl(NetworkMasterRepository networkMasterRepository, NetworkMasterMapper networkMasterMapper, NetworkMasterSearchRepository networkMasterSearchRepository) {
        this.networkMasterRepository = networkMasterRepository;
        this.networkMasterMapper = networkMasterMapper;
        this.networkMasterSearchRepository = networkMasterSearchRepository;
    }

    /**
     * Save a networkMaster.
     *
     * @param networkMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public NetworkMasterDTO save(NetworkMasterDTO networkMasterDTO) {
        log.debug("Request to save NetworkMaster : {}", networkMasterDTO);
        NetworkMaster networkMaster = networkMasterMapper.toEntity(networkMasterDTO);
        networkMaster = networkMasterRepository.save(networkMaster);
        NetworkMasterDTO result = networkMasterMapper.toDto(networkMaster);
        networkMasterSearchRepository.save(networkMaster);
        return result;
    }

    /**
     * Get all the networkMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<NetworkMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NetworkMasters");
        return networkMasterRepository.findAll(pageable)
            .map(networkMasterMapper::toDto);
    }


    /**
     * Get one networkMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<NetworkMasterDTO> findOne(Long id) {
        log.debug("Request to get NetworkMaster : {}", id);
        return networkMasterRepository.findById(id)
            .map(networkMasterMapper::toDto);
    }

    /**
     * Delete the networkMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete NetworkMaster : {}", id);

        networkMasterRepository.deleteById(id);
        networkMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the networkMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<NetworkMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of NetworkMasters for query {}", query);
        return networkMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(networkMasterMapper::toDto);
    }
}
