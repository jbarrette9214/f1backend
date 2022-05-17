package com.barrette.f1site.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barrette.f1site.dtos.RaceDTO;
import com.barrette.f1site.dtos.RaceNameDateDTO;
import com.barrette.f1site.dtos.ResultDTO;
import com.barrette.f1site.dtos.ResultShort;
import com.barrette.f1site.services.interfaces.RacesService;
import com.barrette.f1site.services.interfaces.ResultService;
import com.barrette.f1site.utilities.GeneralException;

@RestController
@RequestMapping("/race")
public class RaceController {

	@Autowired
	RacesService racesService;
	@Autowired
	ResultService resultService;

	@PostMapping("/add")
	public ResponseEntity<RaceDTO> addNewRace(@Valid @RequestBody RaceDTO dto) throws GeneralException {
		return new ResponseEntity<>(racesService.addRace(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/info")
	public ResponseEntity<RaceDTO> getRaceInfo(@RequestParam(required=false) String racename, 
									@RequestParam Integer year, @RequestParam(required=false) Integer round) throws GeneralException {
		RaceDTO dto;
		if(null != racename) {
			dto = racesService.getRaceInfo(racename, year);
		} else if (null != round) {
			dto = racesService.getRaceInfoByYearAndRound(year, round);
		} else {
			throw new GeneralException("race.controller.notEnoughInfo");
		}
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<RaceNameDateDTO>> getRacesForSeason(@RequestParam Integer year) throws GeneralException {
		return new ResponseEntity<>(racesService.getRacesForSeason(year), HttpStatus.OK);
	}
	
	@GetMapping("/result/{year}/{raceName}")
	public ResponseEntity<List<ResultShort>> getRaceResult(@Min(value=1950, message="{result.year.min}") @Max(value=2050, message="{qualifying.year.max}") 
					@PathVariable Integer year, @NotEmpty(message="{result.raceName.required}") @PathVariable String raceName) throws GeneralException {
		return new ResponseEntity<>(resultService.getRaceResultsShort(raceName, year), HttpStatus.OK);
	}
	
	@GetMapping("/result/{year}/{raceName}/{driverName}")
	public ResponseEntity<ResultDTO> getDriversRaceResult(@Min(value=1950, message="{result.year.min}") @Max(value=2050, message="{qualifying.year.max}") 
					@PathVariable Integer year, @NotEmpty(message="{result.raceName.required}") @PathVariable String raceName,
					@NotEmpty(message="{result.driverName.required}") @PathVariable String driverName) throws GeneralException {
		return new ResponseEntity<>(resultService.getDriversDetailedResult(raceName, year, driverName), HttpStatus.OK);
	}
	
	@PostMapping("/result/add")
	public ResponseEntity<ResultDTO> addRaceResult(@Valid @RequestBody ResultDTO dto) throws GeneralException {
		return new ResponseEntity<>(resultService.addResult(dto), HttpStatus.CREATED);
	}
	
}
