package com.barrette.f1site.services.interfaces;

import java.util.List;

import com.barrette.f1site.dtos.FastestLapDTO;
import com.barrette.f1site.utilities.GeneralException;

public interface FastestLapService {
	
	public FastestLapDTO addFastestLap(FastestLapDTO dto) throws GeneralException;
	public FastestLapDTO getFastestLapByYearAndRaceName(Integer year, String raceName) throws GeneralException;
	public List<FastestLapDTO> getDriversCareerFastestLaps(String driverName) throws GeneralException;
	public List<FastestLapDTO> getFastestLapsForYear(Integer year) throws GeneralException;

}
