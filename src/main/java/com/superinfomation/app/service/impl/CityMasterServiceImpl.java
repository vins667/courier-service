package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.CityMasterService;
import com.superinfomation.app.domain.CityMaster;
import com.superinfomation.app.repository.CityMasterRepository;
import com.superinfomation.app.repository.search.CityMasterSearchRepository;
import com.superinfomation.app.service.dto.CityMasterDTO;
import com.superinfomation.app.service.mapper.CityMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link CityMaster}.
 */
@Service
@Transactional
public class CityMasterServiceImpl implements CityMasterService {

    private final Logger log = LoggerFactory.getLogger(CityMasterServiceImpl.class);

    private final CityMasterRepository cityMasterRepository;

    private final CityMasterMapper cityMasterMapper;

    private final CityMasterSearchRepository cityMasterSearchRepository;

    public CityMasterServiceImpl(CityMasterRepository cityMasterRepository, CityMasterMapper cityMasterMapper, CityMasterSearchRepository cityMasterSearchRepository) {
        this.cityMasterRepository = cityMasterRepository;
        this.cityMasterMapper = cityMasterMapper;
        this.cityMasterSearchRepository = cityMasterSearchRepository;
    }

    /**
     * Save a cityMaster.
     *
     * @param cityMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CityMasterDTO save(CityMasterDTO cityMasterDTO) {
        log.debug("Request to save CityMaster : {}", cityMasterDTO);
        CityMaster cityMaster = cityMasterMapper.toEntity(cityMasterDTO);
        cityMaster = cityMasterRepository.save(cityMaster);
        CityMasterDTO result = cityMasterMapper.toDto(cityMaster);
        cityMasterSearchRepository.save(cityMaster);
        return result;
    }

    /**
     * Get all the cityMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CityMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CityMasters");
        return cityMasterRepository.findAll(pageable)
            .map(cityMasterMapper::toDto);
    }


    /**
     * Get one cityMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CityMasterDTO> findOne(Long id) {
        log.debug("Request to get CityMaster : {}", id);
        return cityMasterRepository.findById(id)
            .map(cityMasterMapper::toDto);
    }

    /**
     * Delete the cityMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CityMaster : {}", id);

        cityMasterRepository.deleteById(id);
        cityMasterSearchRepository.deleteById(id);
    }

    /**
     * Search for the cityMaster corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CityMasterDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of CityMasters for query {}", query);
        return cityMasterSearchRepository.search(queryStringQuery(query), pageable)
            .map(cityMasterMapper::toDto);
    }
}
