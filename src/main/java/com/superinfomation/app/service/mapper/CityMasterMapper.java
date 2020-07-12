package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.CityMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CityMaster} and its DTO {@link CityMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {StateMasterMapper.class})
public interface CityMasterMapper extends EntityMapper<CityMasterDTO, CityMaster> {

    @Mapping(source = "stateMaster.id", target = "stateMasterId")
    @Mapping(source = "stateMaster.stateName", target = "stateMasterStateName")
    CityMasterDTO toDto(CityMaster cityMaster);

    @Mapping(source = "stateMasterId", target = "stateMaster")
    CityMaster toEntity(CityMasterDTO cityMasterDTO);

    default CityMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        CityMaster cityMaster = new CityMaster();
        cityMaster.setId(id);
        return cityMaster;
    }
}
