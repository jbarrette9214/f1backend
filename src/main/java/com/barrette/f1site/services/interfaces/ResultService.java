package com.barrette.f1site.services.interfaces;

import java.util.List;

import com.barrette.f1site.dtos.RaceNameDateDTO;
import com.barrette.f1site.dtos.RaceNameDateFinishPosDTO;
import com.barrette.f1site.dtos.ResultDTO;
import com.barrette.f1site.dtos.ResultShort;
import com.barrette.f1site.utilities.GeneralException;

public interface ResultService {

//	public List<String> getDriverIdsForRace(Integer year, String raceName) throws GeneralException;
//	public List<RaceNameDateDTO> getDriverWins(String driverName) throws GeneralException;
//	public List<RaceNameDateFinishPosDTO> getAllResultsByDriver(String driverName) throws GeneralException;
//	public ResultDTO getDriversRaceResult(String driverName, Integer year, String raceName) throws GeneralException;
	public List<ResultShort> getRaceResultsShort(String raceName, Integer year) throws GeneralException;
	public ResultDTO getDriversDetailedResult(String raceName, Integer year, String driverName) throws GeneralException;
	public ResultDTO addResult(ResultDTO dto) throws GeneralException;
	
}
