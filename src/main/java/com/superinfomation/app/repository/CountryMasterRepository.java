package com.superinfomation.app.repository;

import com.superinfomation.app.domain.CountryMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CountryMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster, Long>, JpaSpecificationExecutor<CountryMaster> {
}
