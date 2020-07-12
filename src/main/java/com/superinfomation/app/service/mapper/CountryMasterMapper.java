package com.superinfomation.app.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.superinfomation.app.domain.CountryMaster;
import com.superinfomation.app.service.dto.CountryMasterDTO;

/**
 * Mapper for the entity {@link CountryMaster} and its DTO {@link CountryMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {StateMasterMapper.class})
public interface CountryMasterMapper extends EntityMapper<CountryMasterDTO, CountryMaster> {

    default CountryMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        CountryMaster countryMaster = new CountryMaster();
        countryMaster.setId(id);
        return countryMaster;
    }
}
