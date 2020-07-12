package com.superinfomation.app.repository;

import com.superinfomation.app.domain.BranchMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BranchMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Long>, JpaSpecificationExecutor<BranchMaster> {
}
