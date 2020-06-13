package com.superinfomation.app.service.mapper;


import com.superinfomation.app.domain.*;
import com.superinfomation.app.service.dto.ZoneMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ZoneMaster} and its DTO {@link ZoneMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ZoneMasterMapper extends EntityMapper<ZoneMasterDTO, ZoneMaster> {



    default ZoneMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        ZoneMaster zoneMaster = new ZoneMaster();
        zoneMaster.setId(id);
        return zoneMaster;
    }
}
