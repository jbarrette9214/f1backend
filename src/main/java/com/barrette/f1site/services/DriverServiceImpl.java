package com.barrette.f1site.services;

import java.util.Optional;

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
	
	final String NOT_FOUND = "service.driver.notFound";
	
	@Override
	public DriverDTO getDriverInfoByName(String name) throws GeneralException {
		Driver driver = driverRepo.findByNameIgnoreCase(name).orElseThrow(()-> new GeneralException("NOT_FOUND"));
		
		return DriverDTO.convertToDTO(driver);
	}

	@Override
	public DriverDTO addNewDriver(DriverDTO dto) throws GeneralException {
		Optional<Driver> driverTest = driverRepo.findByNameIgnoreCase(dto.getName());
		
		if(driverTest.isPresent())
			throw new GeneralException("service.driver.alreadyPresent");
		
		Driver driver = DriverDTO.convertToDoc(dto);
		
		return DriverDTO.convertToDTO(driverRepo.save(driver));
	}


	

}
