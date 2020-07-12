package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.BranchMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BranchMaster} and its DTO {@link BranchMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompanyMasterMapper.class, CountryMasterMapper.class})
public interface BranchMasterMapper extends EntityMapper<BranchMasterDTO, BranchMaster> {

    @Mapping(source = "companyMaster.id", target = "companyMasterId")
    @Mapping(source = "companyMaster.companyName", target = "companyMasterCompanyName")
    @Mapping(source = "countryMaster.id", target = "countryMasterId")
    @Mapping(source = "countryMaster.countryName", target = "countryMasterCountryName")
    BranchMasterDTO toDto(BranchMaster branchMaster);

    @Mapping(source = "companyMasterId", target = "companyMaster")
    @Mapping(source = "countryMasterId", target = "countryMaster")
    BranchMaster toEntity(BranchMasterDTO branchMasterDTO);

    default BranchMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        BranchMaster branchMaster = new BranchMaster();
        branchMaster.setId(id);
        return branchMaster;
    }
}
