package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.ServiceMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ServiceMaster} and its DTO {@link ServiceMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ServiceMasterMapper extends EntityMapper<ServiceMasterDTO, ServiceMaster> {



    default ServiceMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        ServiceMaster serviceMaster = new ServiceMaster();
        serviceMaster.setId(id);
        return serviceMaster;
    }
}
