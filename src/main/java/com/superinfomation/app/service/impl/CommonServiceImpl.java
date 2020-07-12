package com.superinfomation.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superinfomation.app.config.Constants;
import com.superinfomation.app.repository.CityMasterRepository;
import com.superinfomation.app.repository.ZoneMasterRepository;
import com.superinfomation.app.service.CityMasterQueryService;
import com.superinfomation.app.service.CommonService;
import com.superinfomation.app.service.dto.CodeDTO;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

	  private final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);
	  
	@Autowired
	private ZoneMasterRepository zoneMasterRepository;
	
	@Autowired
	private CityMasterRepository cityMasterRepository;
	
	@Override
    @Transactional(readOnly = true)
	public List<CodeDTO> getLocationWiseList(String location) {
		// TODO Auto-generated method stub
		if(Constants.ZONE_WISE.equals(location)) {
			return zoneMasterRepository.findAllZones();
		}if(Constants.CITY_WISE.equals(location)) {
			return cityMasterRepository.getAllCities();
		}
		return null;
	}

}
