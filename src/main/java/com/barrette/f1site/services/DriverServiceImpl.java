package com.barrette.f1site.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.Driver;
import com.barrette.f1site.documents.Race;
import com.barrette.f1site.documents.Result;
import com.barrette.f1site.dtos.DriverDTO;
import com.barrette.f1site.dtos.RaceNameDateDTO;
import com.barrette.f1site.dtos.RaceNameDateFinishPosDTO;
import com.barrette.f1site.repositories.DriverRepo;
import com.barrette.f1site.repositories.RacesRepo;
import com.barrette.f1site.repositories.ResultsRepo;
import com.barrette.f1site.services.interfaces.DriverService;
import com.barrette.f1site.utilities.GeneralException;

@Service(value="driverService")
@Transactional
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepo driverRepo;
	@Autowired
	RacesRepo raceRepo;
	@Autowired
	ResultsRepo resultsRepo;
	
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

	@Override
	public String[] getSetOfDriverByYear(Integer year) throws GeneralException {
		
		List<Race> races = raceRepo.findByYear(year);
		
		if(races.size() == 0) 
			throw new GeneralException("service.races.notFoundByYear");
		
		List<String> raceIds = races.stream().map(r -> r.getRaceId()).collect(Collectors.toList());
		
		Set<String> drivers = new HashSet<>();
		
		raceIds.stream().forEach(r -> {
			resultsRepo.getDriverIdsForRaceId(r).stream().forEach(d -> {
					Optional<Driver> driver = driverRepo.findById(d.getDriverId());
					if(driver.isPresent()) {
						drivers.add(driver.get().getName());
					} 
				});
		});
		
		return drivers.toArray(String[]::new);
	}

	@Override
	public List<RaceNameDateDTO> getListOfDriverWins(String driverName) throws GeneralException {
		Driver driver = driverRepo.findByNameIgnoreCase(driverName).orElseThrow(()->new GeneralException(NOT_FOUND));
		
		List<Result> resultList = resultsRepo.getDriverWins(driver.getId());
		
		if(resultList.isEmpty())
			throw new GeneralException("service.driver.noWins");
		
		List<RaceNameDateDTO> winList = resultList.stream().map(r-> {
			
			Race race = null;
			try {
				race = raceRepo.findById(r.getRaceId()).orElseThrow(()->new GeneralException("service.driver.notFoundRace"));
				
			} catch (GeneralException e) {
				e.printStackTrace();
			}
			if(null != race)
				return new RaceNameDateDTO(race.getName(), race.getDate());
			else
				return null;
		}).filter(res-> null!=res).collect(Collectors.toList());
		
		return winList;
	}

	@Override
	public List<RaceNameDateFinishPosDTO> getAllResultsForDriver(String driverName) throws GeneralException {
		Driver driver = driverRepo.findByNameIgnoreCase(driverName).orElseThrow(()->new GeneralException(NOT_FOUND));
		
		List<Result> resultList = resultsRepo.findByDriverId(driver.getId());
		
		if(resultList.isEmpty())
			throw new GeneralException("service.driver.notFoundResults");
		
		List<RaceNameDateFinishPosDTO> dtos = resultList.stream().map(r -> {
			Race race = null;
			try {
				race = raceRepo.findById(r.getRaceId()).orElseThrow(()->new GeneralException("service.driver.notFoundRace"));
				
			} catch (GeneralException e) {
				e.printStackTrace();
			}
			if(null != race)
				return new RaceNameDateFinishPosDTO(race.getName(), race.getDate(), r.getFinishPos());
			else
				return null;
		}).filter(res-> null!= res).collect(Collectors.toList());
		
		return dtos;
	}


	

}
