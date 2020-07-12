package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.StateMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StateMaster} and its DTO {@link StateMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {CountryMasterMapper.class})
public interface StateMasterMapper extends EntityMapper<StateMasterDTO, StateMaster> {

    @Mapping(source = "countryMaster.id", target = "countryMasterId")
    StateMasterDTO toDto(StateMaster stateMaster);

    @Mapping(source = "countryMasterId", target = "countryMaster")
    StateMaster toEntity(StateMasterDTO stateMasterDTO);

    default StateMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        StateMaster stateMaster = new StateMaster();
        stateMaster.setId(id);
        return stateMaster;
    }
}
