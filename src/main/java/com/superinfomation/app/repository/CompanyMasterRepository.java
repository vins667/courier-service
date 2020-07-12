package com.superinfomation.app.repository;

import com.superinfomation.app.domain.CompanyMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CompanyMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Long>, JpaSpecificationExecutor<CompanyMaster> {
}
