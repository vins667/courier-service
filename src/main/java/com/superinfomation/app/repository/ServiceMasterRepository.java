package com.superinfomation.app.repository;

import com.superinfomation.app.domain.ServiceMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ServiceMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ServiceMasterRepository extends JpaRepository<ServiceMaster, Long>, JpaSpecificationExecutor<ServiceMaster> {
}
