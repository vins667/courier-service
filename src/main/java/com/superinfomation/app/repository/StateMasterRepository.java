package com.superinfomation.app.repository;

import com.superinfomation.app.domain.StateMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the StateMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StateMasterRepository extends JpaRepository<StateMaster, Long>, JpaSpecificationExecutor<StateMaster> {
}
