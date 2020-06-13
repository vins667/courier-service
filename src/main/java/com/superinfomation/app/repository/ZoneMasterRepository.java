package com.superinfomation.app.repository;

import com.superinfomation.app.domain.ZoneMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ZoneMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZoneMasterRepository extends JpaRepository<ZoneMaster, Long>, JpaSpecificationExecutor<ZoneMaster> {
    @Query("select zoneMaster from ZoneMaster zoneMaster where zoneMaster.zoneCode like ?1 and zoneMaster.zoneName like ?2")
    Page<ZoneMaster> findAllByFilter(String zonecode, String zonename, Pageable pageable);
}
