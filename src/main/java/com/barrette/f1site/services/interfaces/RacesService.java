package com.barrette.f1site.services.interfaces;

import java.util.List;

import com.barrette.f1site.dtos.RaceDTO;
import com.barrette.f1site.dtos.RaceNameDateDTO;
import com.barrette.f1site.utilities.GeneralException;

public interface RacesService {
	
	public RaceDTO addRace(RaceDTO dto) throws GeneralException;
	public RaceDTO getRaceInfo(String racename, Integer year) throws GeneralException;
	public List<RaceNameDateDTO> getRacesForSeason(Integer year) throws GeneralException;
	public RaceDTO getRaceInfoByYearAndRound(Integer year, Integer round) throws GeneralException;

}
