package com.superinfomation.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.superinfomation.app.domain.ZoneMaster;
import com.superinfomation.app.service.dto.CodeDTO;

/**
 * Spring Data  repository for the ZoneMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZoneMasterRepository extends JpaRepository<ZoneMaster, Long>, JpaSpecificationExecutor<ZoneMaster> {
    @Query("select zoneMaster from ZoneMaster zoneMaster where zoneMaster.zoneCode like ?1 and zoneMaster.zoneName like ?2")
    Page<ZoneMaster> findAllByFilter(String zonecode, String zonename, Pageable pageable);
    
    @Query("select new com.superinfomation.app.service.dto.CodeDTO(zone.id,zone.zoneName) from ZoneMaster zone")
    List<CodeDTO>findAllZones();
}
