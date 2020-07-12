package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.NetworkMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NetworkMaster} and its DTO {@link NetworkMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {CityMasterMapper.class})
public interface NetworkMasterMapper extends EntityMapper<NetworkMasterDTO, NetworkMaster> {

    @Mapping(source = "cityMaster.id", target = "cityMasterId")
    @Mapping(source = "cityMaster.cityName", target = "cityMasterCityName")
    NetworkMasterDTO toDto(NetworkMaster networkMaster);

    @Mapping(source = "cityMasterId", target = "cityMaster")
    NetworkMaster toEntity(NetworkMasterDTO networkMasterDTO);

    default NetworkMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        NetworkMaster networkMaster = new NetworkMaster();
        networkMaster.setId(id);
        return networkMaster;
    }
}
