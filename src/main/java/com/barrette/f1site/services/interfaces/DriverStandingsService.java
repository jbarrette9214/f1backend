package com.barrette.f1site.services.interfaces;

import java.util.List;

import com.barrette.f1site.dtos.DriverStandingsDTO;
import com.barrette.f1site.pojos.Standing;
import com.barrette.f1site.utilities.GeneralException;

public interface DriverStandingsService {
	
	public DriverStandingsDTO addNewDriverStandings(String year, List<Standing> driverNames) throws GeneralException;
	public DriverStandingsDTO getDriverStandingsByYear(String year) throws GeneralException;
	public String updateDriverStandings(String year, String driverName, Float points) throws GeneralException;
	
}
