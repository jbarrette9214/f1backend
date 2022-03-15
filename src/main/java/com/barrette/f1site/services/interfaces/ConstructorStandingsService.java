package com.barrette.f1site.services.interfaces;

import com.barrette.f1site.dtos.ConstructorStandingsDTO;
import com.barrette.f1site.utilities.GeneralException;

public interface ConstructorStandingsService {

	public ConstructorStandingsDTO addNewConstructorStandings(String year, String[] constructorNames) throws GeneralException;
	public ConstructorStandingsDTO getStandingsByYear(String year) throws GeneralException;
	public String updateConstructorStandings(String year, String constructorName, Float points) throws GeneralException;
	
}
