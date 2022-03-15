package com.barrette.f1site.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.ConstructorStandings;
import com.barrette.f1site.dtos.ConstructorStandingsDTO;
import com.barrette.f1site.pojos.Standing;
import com.barrette.f1site.repositories.ConstructorStandingsRepo;
import com.barrette.f1site.services.interfaces.ConstructorStandingsService;
import com.barrette.f1site.utilities.GeneralException;

@Service
@Transactional
public class ConstructorStandingsServiceImpl implements ConstructorStandingsService {

	@Autowired
	ConstructorStandingsRepo conStandingRepo;
	
	private final String NOT_FOUND = "service.constructorStandings.notFound";
	
	@Override
	public ConstructorStandingsDTO addNewConstructorStandings(String year, String[] constructorNames) throws GeneralException {
		Optional<ConstructorStandings> consTest = conStandingRepo.findByYear(year);
		
		if(consTest.isPresent())
			throw new GeneralException("service.constructorStanding.alreadyPresent");
		
		List<Standing> standings = new ArrayList<>();
		for(String name : constructorNames) {
			Standing st = new Standing(null, name, 0.0f);
			standings.add(st);
		}
		
		ConstructorStandings conStandings = new ConstructorStandings();
		conStandings.setYear(Integer.valueOf(year));
		conStandings.setStandings(standings);
		
		conStandings = conStandingRepo.save(conStandings);
		
		return ConstructorStandingsDTO.convertToDTO(conStandings);
	}

	@Override
	public ConstructorStandingsDTO getStandingsByYear(String year) throws GeneralException {
		ConstructorStandings standings = conStandingRepo.findByYear(year).orElseThrow(()-> new GeneralException(NOT_FOUND));
		
		return ConstructorStandingsDTO.convertToDTO(standings);
	}

	@Override
	public String updateConstructorStandings(String year, String constructorName, Float points) throws GeneralException {
		ConstructorStandings conStandings = conStandingRepo.findByYear(year).orElseThrow(()-> new GeneralException(NOT_FOUND));
		
		List<Standing> st = conStandings.getStandings().stream().map(s -> {
															if(s.getConstructor().equals(constructorName)) {
																s.setPoints(s.getPoints() + points);
															}
															return s;
														}).collect(Collectors.toList());

		conStandings.setStandings(st);
		conStandingRepo.save(conStandings);
		
		return "Constructor points updated";
	}

}
