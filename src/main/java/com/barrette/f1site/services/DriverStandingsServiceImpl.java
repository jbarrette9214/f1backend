package com.barrette.f1site.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.DriverStandings;
import com.barrette.f1site.documents.Race;
import com.barrette.f1site.documents.Result;
import com.barrette.f1site.dtos.DriverStandingsDTO;
import com.barrette.f1site.pojos.Standing;
import com.barrette.f1site.repositories.DriverRepo;
import com.barrette.f1site.repositories.DriverStandingsRepo;
import com.barrette.f1site.repositories.RacesRepo;
import com.barrette.f1site.repositories.ResultsRepo;
import com.barrette.f1site.services.interfaces.DriverStandingsService;
import com.barrette.f1site.utilities.GeneralException;

@Service
@Transactional
public class DriverStandingsServiceImpl implements DriverStandingsService {
	
	@Autowired
	DriverStandingsRepo driverStandingsRepo;
	@Autowired
	ResultsRepo resultRepo;
	@Autowired
	DriverRepo driverRepo;
	@Autowired
	RacesRepo racesRepo;

	@Override
	public DriverStandingsDTO addNewDriverStandings(String year, List<Standing> driverNames) throws GeneralException {
		DriverStandings dStandings = new DriverStandings();
		dStandings.setYear(Integer.valueOf(year));
		dStandings.setStandings(driverNames);
		
		return DriverStandingsDTO.convertToDTO(dStandings);
	}

	@Override
	public DriverStandingsDTO getDriverStandingsByYear(String year) throws GeneralException {
		DriverStandings standings = driverStandingsRepo.findByYear(Integer.valueOf(year))
													.orElseThrow(()->new GeneralException("service.driverStandings.notFound"));
		
		List<Standing> sortedStandings = standings.getStandings().stream().sorted((d1, d2)-> {
			if(d1.getPoints() > d2.getPoints()) 
				return -1;
			else if (d1.getPoints() < d2.getPoints())
				return 1;
			else {
				String d1Id = driverRepo.findByNameIgnoreCase(d1.getDriverName()).get().getId();
				String d2Id = driverRepo.findByNameIgnoreCase(d2.getDriverName()).get().getId();
				
				List<Race> races = racesRepo.findByYear(Integer.valueOf(year));
				
				List<Integer> d1Finishes = new ArrayList<>();
				List<Integer> d2Finishes = new ArrayList<>();
				
				for(Race r : races) {
					Result r1 = resultRepo.findByDriverIdAndRaceId(d1Id, r.getRaceId()).orElse(new Result());
					if(null == r1.getFinishPos())
						d1Finishes.add(50);
					else
						d1Finishes.add(r1.getFinishPos());
					
					Result r2 = resultRepo.findByDriverIdAndRaceId(d2Id, r.getRaceId()).orElse(new Result());
					if(null == r2.getFinishPos())
						d2Finishes.add(50);
					else
						d2Finishes.add(r2.getFinishPos());
					
				}
				
				Collections.sort(d1Finishes);
				
				Collections.sort(d2Finishes);
				
				Integer returnValue = 0;
//sorting issues slow
				for(int i = 0; i < d1Finishes.size(); ++i) {
					
					if(null == d1Finishes.get(i) || null == d2Finishes.get(i))
						break;
					
					if(d1Finishes.get(i) < d2Finishes.get(i)) {
						returnValue = -1;
						break;
					} else if(d1Finishes.get(i) > d2Finishes.get(i)) {
						returnValue = 1;
						break;
					}
				}
				return returnValue;
			}
		}).collect(Collectors.toList());
		
		standings.setStandings(sortedStandings);
		
		return DriverStandingsDTO.convertToDTO(standings);
	}

	@Override
	public String updateDriverStandings(String year, String driverName, Float points) throws GeneralException {
		DriverStandings dStandings = driverStandingsRepo.findByYear(Integer.valueOf(year))
													.orElseThrow(()->new GeneralException("service.driverStandings.notFound")); 
		
		boolean contains = dStandings.getStandings().stream().filter(e-> e.getDriverName().equals(driverName)).findFirst().isPresent();
		
		List<Standing> newStandings;
		if(contains) {
			newStandings = dStandings.getStandings().stream().map(s -> {
				if(s.getDriverName().equals(driverName)) {
					s.setPoints(s.getPoints() + points);
				}
				return s;
			}).collect(Collectors.toList());
		} else {
			newStandings = dStandings.getStandings();
			newStandings.add(new Standing(driverName, null, points));
		}
		
		dStandings.setStandings(newStandings);
		
		driverStandingsRepo.save(dStandings);
		
		return "Driver standing for " + driverName + " updated";
	}

}
