package com.barrette.f1site.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barrette.f1site.dtos.FastestLapDTO;
import com.barrette.f1site.services.interfaces.FastestLapService;
import com.barrette.f1site.utilities.GeneralException;

@RestController
@RequestMapping("/fastestlap/")
@Validated
public class FastestLapController {

	@Autowired
	FastestLapService fastestLapService;
	
	@PostMapping("/add")
	public ResponseEntity<FastestLapDTO> addFastestLap(@Valid @RequestBody FastestLapDTO dto) throws GeneralException {
		//convert the lap time to milliseconds here
		Integer milli = 0;
		String[] splits = dto.getLapTime().split(":");
		milli = Integer.valueOf(splits[0]) * 1000 * 60;
		milli = milli + (int) (Double.valueOf(splits[1]) * 1000);
		dto.setMilliseconds(milli);
		
		return new ResponseEntity<>(fastestLapService.addFastestLap(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{year}/{raceName}")
	public ResponseEntity<FastestLapDTO> getFastestLapForRace(@PathVariable Integer year, 
									@PathVariable String raceName) throws GeneralException {
		return new ResponseEntity<>(fastestLapService.getFastestLapByYearAndRaceName(year, raceName), HttpStatus.OK);
	}
	
	@GetMapping("/byDriver/{driverName}")
	public ResponseEntity<List<FastestLapDTO>> getListForDriver(@PathVariable String driverName) throws GeneralException {
		return new ResponseEntity<>(fastestLapService.getDriversCareerFastestLaps(driverName), HttpStatus.OK);
	}
	
	@GetMapping("/bySeason/{year}")
	public ResponseEntity<List<FastestLapDTO>> getListForSeason(@PathVariable Integer year) throws GeneralException {
		return new ResponseEntity<>(fastestLapService.getFastestLapsForYear(year), HttpStatus.OK);
	}
	
}
