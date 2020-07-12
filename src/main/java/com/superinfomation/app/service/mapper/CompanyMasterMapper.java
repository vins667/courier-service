package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.CompanyMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CompanyMaster} and its DTO {@link CompanyMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {StateMasterMapper.class, CountryMasterMapper.class, CityMasterMapper.class})
public interface CompanyMasterMapper extends EntityMapper<CompanyMasterDTO, CompanyMaster> {

    @Mapping(source = "stateMaster.id", target = "stateMasterId")
    @Mapping(source = "stateMaster.stateName", target = "stateMasterStateName")
    @Mapping(source = "countryMaster.id", target = "countryMasterId")
    @Mapping(source = "countryMaster.countryName", target = "countryMasterCountryName")
    @Mapping(source = "cityMaster.id", target = "cityMasterId")
    @Mapping(source = "cityMaster.cityName", target = "cityMasterCityName")
    CompanyMasterDTO toDto(CompanyMaster companyMaster);

    @Mapping(source = "stateMasterId", target = "stateMaster")
    @Mapping(source = "countryMasterId", target = "countryMaster")
    @Mapping(source = "cityMasterId", target = "cityMaster")
    CompanyMaster toEntity(CompanyMasterDTO companyMasterDTO);

    default CompanyMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompanyMaster companyMaster = new CompanyMaster();
        companyMaster.setId(id);
        return companyMaster;
    }
}
