package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.StandardTariffDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StandardTariff} and its DTO {@link StandardTariffDTO}.
 */
@Mapper(componentModel = "spring", uses = {NetworkMasterMapper.class, ServiceMasterMapper.class, CityMasterMapper.class})
public interface StandardTariffMapper extends EntityMapper<StandardTariffDTO, StandardTariff> {

    @Mapping(source = "networkMaster.id", target = "networkMasterId")
    @Mapping(source = "networkMaster.networkName", target = "networkMasterNetworkName")
    @Mapping(source = "serviceMaster.id", target = "serviceMasterId")
    @Mapping(source = "serviceMaster.serviceName", target = "serviceMasterServiceName")
    @Mapping(source = "cityMaster.id", target = "cityMasterId")
    @Mapping(source = "cityMaster.cityName", target = "cityMasterCityName")
    StandardTariffDTO toDto(StandardTariff standardTariff);

    @Mapping(source = "networkMasterId", target = "networkMaster")
    @Mapping(source = "serviceMasterId", target = "serviceMaster")
    @Mapping(source = "cityMasterId", target = "cityMaster")
    StandardTariff toEntity(StandardTariffDTO standardTariffDTO);

    default StandardTariff fromId(Long id) {
        if (id == null) {
            return null;
        }
        StandardTariff standardTariff = new StandardTariff();
        standardTariff.setId(id);
        return standardTariff;
    }
}
