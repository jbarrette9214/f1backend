package com.barrette.f1site.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barrette.f1site.dtos.DriverDTO;
import com.barrette.f1site.repositories.RacesRepo;
import com.barrette.f1site.repositories.ResultsRepo;
import com.barrette.f1site.services.interfaces.DriverService;
import com.barrette.f1site.utilities.GeneralException;

@RestController
@RequestMapping("/driver")
@Validated
public class DriverController {

	@Autowired
	DriverService driverService;
	
	
	@GetMapping("/info")
	public ResponseEntity<DriverDTO> getDriverInfo(@RequestParam String name) throws GeneralException {
		return new ResponseEntity<>(driverService.getDriverInfoByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<DriverDTO> addNewDriver(@RequestBody DriverDTO dto) throws GeneralException {
		return new ResponseEntity<>(driverService.addNewDriver(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/listByYear/{year}")
	public ResponseEntity<String[]> getDriverListByYear(@Min(value=1950, message="driver.controller.yearMin")
		@Max(value=2025, message="driver.controller.yearMax") @PathVariable Integer year) throws GeneralException {
		return new ResponseEntity<>(driverService.getSetOfDriverByYear(year), HttpStatus.OK);
	}
}
