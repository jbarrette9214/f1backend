package com.barrette.f1site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.Driver;
import com.barrette.f1site.dtos.DriverDTO;
import com.barrette.f1site.repositories.DriverRepo;
import com.barrette.f1site.services.interfaces.DriverService;
import com.barrette.f1site.utilities.GeneralException;

@Service(value="driverService")
@Transactional
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepo driverRepo;
	
	@Override
	public DriverDTO getDriverInfoByName(String name) throws GeneralException {
		Driver driver = driverRepo.findByNameIgnoreCase(name).orElseThrow(()-> new GeneralException("service.driver.notFound"));
		
		return DriverDTO.convertToDTO(driver);
	}
	
	

}
