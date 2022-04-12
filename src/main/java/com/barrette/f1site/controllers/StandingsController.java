package com.barrette.f1site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barrette.f1site.dtos.ConstructorStandingsDTO;
import com.barrette.f1site.dtos.DriverStandingsDTO;
import com.barrette.f1site.pojos.Standing;
import com.barrette.f1site.services.interfaces.ConstructorStandingsService;
import com.barrette.f1site.services.interfaces.DriverStandingsService;
import com.barrette.f1site.utilities.GeneralException;

@RestController
@RequestMapping("/standings")
public class StandingsController {
	
	//add all the driver and constructor standing endpoints here
	@Autowired
	ConstructorStandingsService constructorService;
	@Autowired
	DriverStandingsService driverService;
	
	@PostMapping("/constructor/add")
	public ResponseEntity<ConstructorStandingsDTO> addNewCosntructorStandings(@RequestParam String year, 
											@RequestBody String[] teamNames) throws GeneralException {
		return new ResponseEntity<>(constructorService.addNewConstructorStandings(year, teamNames), HttpStatus.CREATED);
	}
	
	@GetMapping("/constructor/{year}")
	public ResponseEntity<ConstructorStandingsDTO> getConstructorStandingsByYear(@PathVariable String year) throws GeneralException {
		return new ResponseEntity<>(constructorService.getStandingsByYear(year), HttpStatus.OK);
	}

	@PutMapping("/constructor/update")
	public ResponseEntity<String> updateConstructorStandings(@RequestParam String year, @RequestParam String constructorName,
										@RequestParam Float points) throws GeneralException {
		return new ResponseEntity<>(constructorService.updateConstructorStandings(year, constructorName, points), HttpStatus.OK);
	}
	
	@PostMapping("/driver/add")
	public ResponseEntity<DriverStandingsDTO> addNewDriverStandings(@RequestParam String year, @RequestBody List<Standing> drivers) 
																	throws GeneralException {
		return new ResponseEntity<>(driverService.addNewDriverStandings(year, drivers), HttpStatus.CREATED);
	}
	
	@GetMapping("/driver/{year}")
	public ResponseEntity<DriverStandingsDTO> getDriverStandingsByYear(@PathVariable String year) throws GeneralException {
		return new ResponseEntity<>(driverService.getDriverStandingsByYear(year), HttpStatus.OK);
	}
	
	@PutMapping("/driver/update")
	public ResponseEntity<String> updateDriverStandings(@RequestParam String year, @RequestParam String driverName, 
												@RequestParam Float points) throws GeneralException {
		return new ResponseEntity<>(driverService.updateDriverStandings(year, driverName, points), HttpStatus.OK);
	}
}
