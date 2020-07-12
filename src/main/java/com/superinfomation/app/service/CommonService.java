package com.superinfomation.app.service;

import java.util.List;

import com.superinfomation.app.service.dto.CodeDTO;

public interface CommonService {

	
	List<CodeDTO>getLocationWiseList(String location);
}
