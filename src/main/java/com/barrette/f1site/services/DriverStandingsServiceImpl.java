package com.barrette.f1site.services;

import java.util.List;

import com.barrette.f1site.dtos.DriverStandingsDTO;
import com.barrette.f1site.pojos.Standing;
import com.barrette.f1site.services.interfaces.DriverStandingsService;
import com.barrette.f1site.utilities.GeneralException;

public class DriverStandingsServiceImpl implements DriverStandingsService {

	@Override
	public DriverStandingsDTO addNewDriverStandings(String year, List<Standing> driverNames) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverStandingsDTO getDriverStandingsByYear(String year) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDriverStandings(String year, String driverName, Float points) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

}
