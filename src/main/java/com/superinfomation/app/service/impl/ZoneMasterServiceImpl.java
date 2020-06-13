package com.superinfomation.app.service.impl;

import com.superinfomation.app.service.ZoneMasterService;
import com.superinfomation.app.domain.ZoneMaster;
import com.superinfomation.app.repository.ZoneMasterRepository;
import com.superinfomation.app.service.dto.ZoneMasterDTO;
import com.superinfomation.app.service.mapper.ZoneMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ZoneMaster}.
 */
@Service
@Transactional
public class ZoneMasterServiceImpl implements ZoneMasterService {

    private final Logger log = LoggerFactory.getLogger(ZoneMasterServiceImpl.class);

    private final ZoneMasterRepository zoneMasterRepository;

    private final ZoneMasterMapper zoneMasterMapper;

    public ZoneMasterServiceImpl(ZoneMasterRepository zoneMasterRepository, ZoneMasterMapper zoneMasterMapper) {
        this.zoneMasterRepository = zoneMasterRepository;
        this.zoneMasterMapper = zoneMasterMapper;
    }

    /**
     * Save a zoneMaster.
     *
     * @param zoneMasterDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ZoneMasterDTO save(ZoneMasterDTO zoneMasterDTO) {
        log.debug("Request to save ZoneMaster : {}", zoneMasterDTO);
        ZoneMaster zoneMaster = zoneMasterMapper.toEntity(zoneMasterDTO);
        zoneMaster = zoneMasterRepository.save(zoneMaster);
        return zoneMasterMapper.toDto(zoneMaster);
    }

    /**
     * Get all the zoneMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ZoneMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ZoneMasters");
        return zoneMasterRepository.findAll(pageable)
            .map(zoneMasterMapper::toDto);
    }


    /**
     * Get one zoneMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ZoneMasterDTO> findOne(Long id) {
        log.debug("Request to get ZoneMaster : {}", id);
        return zoneMasterRepository.findById(id)
            .map(zoneMasterMapper::toDto);
    }

    /**
     * Delete the zoneMaster by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ZoneMaster : {}", id);

        zoneMasterRepository.deleteById(id);
    }
}
