package com.barrette.f1site.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.Driver;
import com.barrette.f1site.documents.Race;
import com.barrette.f1site.documents.Result;
import com.barrette.f1site.dtos.DriverDTO;
import com.barrette.f1site.dtos.RaceDTO;
import com.barrette.f1site.dtos.RaceNameDateDTO;
import com.barrette.f1site.dtos.RaceNameDateFinishPosDTO;
import com.barrette.f1site.dtos.ResultDTO;
import com.barrette.f1site.dtos.ResultShort;
import com.barrette.f1site.repositories.DriverRepo;
import com.barrette.f1site.repositories.RacesRepo;
import com.barrette.f1site.repositories.ResultsRepo;
import com.barrette.f1site.services.interfaces.DriverService;
import com.barrette.f1site.services.interfaces.RacesService;
import com.barrette.f1site.services.interfaces.ResultService;
import com.barrette.f1site.utilities.GeneralException;

@Service(value="raceService")
@Transactional
public class ResultServiceImpl implements ResultService{
	
	@Autowired
	ResultsRepo resultsRepo;
	@Autowired 
	RacesService raceService;
	@Autowired
	DriverRepo driverRepo;
	@Autowired
	RacesRepo racesRepo;
	
//	@Override
//	public List<String> getDriverIdsForRace(Integer year, String raceName) throws GeneralException {
//		RaceDTO raceDTO = raceService.getRaceInfo(raceName, year);
//		
//		List<Result> results = resultsRepo.getDriverIdsForRaceId(raceDTO.getRaceId());
//		
//		if(results.isEmpty())
//			throw new GeneralException("service.result.notFound");
//		
//		List<String> driverIds = new ArrayList<>();
//		
//		driverIds = results.stream().map(t-> t.getDriverId()).collect(Collectors.toList());
//		
//		return driverIds;
//	}
//
//	@Override
//	public List<RaceNameDateDTO> getDriverWins(String driverName) throws GeneralException {
//		Driver driver = driverRepo.findByNameIgnoreCase(driverName).orElseThrow(()->new GeneralException("service.result.notFoundDriver"));
//		
//		List<Result> results = resultsRepo.getDriverWins(driver.getId());
//		
//		if(results.isEmpty())
//			throw new GeneralException("service.result.noWins");
//		
//		List<RaceNameDateDTO> raceNames = results.stream().map(r-> {
//						Race race;
//						race = racesRepo.findById(r.getRaceId()).get();
//						
//						return new RaceNameDateDTO(race.getName(), race.getDate());
//					}).collect(Collectors.toList());
//		
//		raceNames.sort((r1, r2)-> r1.getDate().compareTo(r2.getDate()));
//		
//		return raceNames;
//	}
//
//	@Override
//	public List<RaceNameDateFinishPosDTO> getAllResultsByDriver(String driverName) throws GeneralException {
//		Driver driver = driverRepo.findByNameIgnoreCase(driverName).orElseThrow(()->new GeneralException("service.result.notFoundDriver"));
//		
//		List<Result> results = resultsRepo.findByDriverId(driver.getId());
//		
//		if(results.isEmpty())
//			throw new GeneralException("service.result.notFoundResultsForDriver");
//		
//		List<RaceNameDateFinishPosDTO> dtos = results.stream().map(r->{
//													Race race = racesRepo.findById(r.getRaceId()).get();
//													
//													return new RaceNameDateFinishPosDTO(race.getName(), race.getDate(), r.getFinishPos());
//												}).collect(Collectors.toList());
//		dtos.sort((r1,r2)-> r1.getDate().compareTo(r2.getDate()));
//		
//		return dtos;
//	}
//
//	@Override
//	public ResultDTO getDriversRaceResult(String driverName, Integer year, String raceName) throws GeneralException {
//		Driver driver = driverRepo.findByNameIgnoreCase(driverName)
//								.orElseThrow(()->new GeneralException("service.result.notFoundDriver"));
//		Race race = racesRepo.findByNameIgnoreCaseAndYear(raceName, year)
//								.orElseThrow(()->new GeneralException("service.result.raceNotFound"));
//		
//		Result result = resultsRepo.findByDriverIdAndRaceId(driver.getId(), race.getRaceId())
//								.orElseThrow(()->new GeneralException("service.result.notFoundDriverAndRace"));
//		
//		return ResultDTO.convertToDTO(result);
//	}

	
	@Override
	public ResultDTO addResult(ResultDTO dto) throws GeneralException {
		//get all results for a race, add this result to db,  sort all of them by laptime then set the fastest lap position
		List<Result> results = resultsRepo.findByRaceId(dto.getRaceId());
		if(results.isEmpty())
			throw new GeneralException("service.result.notFoundRace");
		
		Result added = resultsRepo.save(ResultDTO.convertToDoc(dto));
		results.add(added);
		
		results.sort((a,b)-> a.toString().compareTo(b.toString()));
		
		for(int i=0; i < results.size(); ++i) {
			results.get(i).setFastLapRank(i+1);
			resultsRepo.save(results.get(i));
		}
		
		return ResultDTO.convertToDTO(added);
	}

	@Override
	public List<ResultShort> getRaceResultsShort(String raceName, Integer year) throws GeneralException {
		//only gets the driver name and positions
		Race race = racesRepo.findByNameIgnoreCaseAndYear(raceName, year)
								.orElseThrow(()->new GeneralException("service.result.notFoundRace"));

		List<Result> results = resultsRepo.findByRaceId(race.getRaceId());
		
		if(results.isEmpty())
				throw new GeneralException("service.result.notFoundRaceResults");
		
		List<ResultShort> shortList = results.stream().map(r-> {
																	Driver driver = driverRepo.findById(r.getDriverId()).get();
																	return new ResultShort(driver.getName(), r.getFinishPos(), r.getStartPos(), r.getPitstops().size());
														}).collect(Collectors.toList());
											
		shortList.sort((r1,r2)->r1.getPosition().compareTo(r2.getPosition()));
		
		return shortList;
	}

	@Override
	public ResultDTO getDriversDetailedResult(String raceName, Integer year, String driverName)
			throws GeneralException {
		Race race = racesRepo.findByNameIgnoreCaseAndYear(raceName, year)
				.orElseThrow(()->new GeneralException("service.result.notFoundRace"));

		Driver driver = driverRepo.findByNameIgnoreCase(driverName)
				.orElseThrow(()->new GeneralException("service.result.notFoundDriver"));
		
		Result result = resultsRepo.findByDriverIdAndRaceId(driver.getId(), race.getRaceId())
				.orElseThrow(()->new GeneralException("service.result.notFoundDriverAndRace"));
		
		return ResultDTO.convertToDTO(result);
	}

}
