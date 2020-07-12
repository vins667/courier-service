package com.superinfomation.app.repository;

import com.superinfomation.app.domain.StandardTariff;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the StandardTariff entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StandardTariffRepository extends JpaRepository<StandardTariff, Long>, JpaSpecificationExecutor<StandardTariff> {
}
