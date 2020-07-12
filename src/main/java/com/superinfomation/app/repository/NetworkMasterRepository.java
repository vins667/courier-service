package com.superinfomation.app.repository;

import com.superinfomation.app.domain.NetworkMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NetworkMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NetworkMasterRepository extends JpaRepository<NetworkMaster, Long>, JpaSpecificationExecutor<NetworkMaster> {
}
