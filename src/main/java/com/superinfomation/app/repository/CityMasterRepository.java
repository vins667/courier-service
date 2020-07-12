package com.superinfomation.app.repository;

import com.superinfomation.app.domain.CityMaster;
import com.superinfomation.app.service.dto.CodeDTO;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CityMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster, Long>, JpaSpecificationExecutor<CityMaster> {
	
	@Query("select new com.superinfomation.app.service.dto.CodeDTO(city.id,city.cityName) from CityMaster city")
    List<CodeDTO>getAllCities();
}
