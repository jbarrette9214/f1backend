package com.barrette.f1site.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barrette.f1site.documents.Race;
import com.barrette.f1site.dtos.RaceDTO;
import com.barrette.f1site.dtos.RaceNameDateDTO;
import com.barrette.f1site.repositories.RacesRepo;
import com.barrette.f1site.services.interfaces.RacesService;
import com.barrette.f1site.utilities.GeneralException;

@Service(value="racesService")
public class RaceServiceImpl implements RacesService {

	@Autowired
	RacesRepo raceRepo;
	
	final String NOT_FOUND = "service.race.notFound";
	
	@Override
	public RaceDTO addRace(RaceDTO dto) throws GeneralException {
		Optional<Race> raceTest = raceRepo.findByNameIgnoreCaseAndYear(dto.getName(), dto.getYear());
		
		if(raceTest.isPresent())
			throw new GeneralException("service.race.alreadyPresent");
		
		Race race = RaceDTO.convertToDoc(dto);
		race = raceRepo.save(race);
		
		return RaceDTO.convertToDTO(race);
	}

	@Override
	public RaceDTO getRaceInfo(String racename, Integer year) throws GeneralException {
		Race race = raceRepo.findByNameIgnoreCaseAndYear(racename, year).orElseThrow(()->new GeneralException(NOT_FOUND));
		
		return RaceDTO.convertToDTO(race);
	}

	@Override
	public List<RaceNameDateDTO> getRacesForSeason(Integer year) throws GeneralException {
		List<Race> races = raceRepo.findByYear(year);
		
		if(races.isEmpty())
			throw new GeneralException("service.race.notFoundByYear");
		
		return races.stream().map(r-> new RaceNameDateDTO(r.getName(), r.getDate())).collect(Collectors.toList());
	}

	@Override
	public RaceDTO getRaceInfoByYearAndRound(Integer year, Integer round) throws GeneralException {
		Race race = raceRepo.findByYearAndRound(year, round).orElseThrow(()->new GeneralException(NOT_FOUND));
		
		return RaceDTO.convertToDTO(race);
	}

}
