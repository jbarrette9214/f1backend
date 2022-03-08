package com.barrette.f1site.services.interfaces;

import java.util.List;

import com.barrette.f1site.dtos.DriverDTO;
import com.barrette.f1site.utilities.GeneralException;

public interface DriverService {

	public DriverDTO getDriverInfoByName(String name) throws GeneralException;
	public DriverDTO addNewDriver(DriverDTO dto) throws GeneralException;
	public String[] getSetOfDriverByYear(Integer year) throws GeneralException;
	
}
