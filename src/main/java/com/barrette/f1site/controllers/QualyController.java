package com.barrette.f1site.controllers;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barrette.f1site.dtos.QualifyingDTO;
import com.barrette.f1site.services.interfaces.QualifyingService;
import com.barrette.f1site.utilities.GeneralException;

@RestController
@RequestMapping("/qualifying")
@Validated
public class QualyController {

	@Autowired
	QualifyingService qualyService;
	
	@PostMapping("/add")
	public ResponseEntity<QualifyingDTO> addQualy(QualifyingDTO dto) throws GeneralException {
		return new ResponseEntity<>(qualyService.addQualifying(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/pole/{year}/{raceName}")
	public ResponseEntity<QualifyingDTO> getPoleForRace(@Min(value=1950, message="{qualifying.year.min}") @Max(value=2050, message="{qualifying.year.max}") 
						@PathVariable Integer year, @NotEmpty(message="{qualifying.raceName.required}") @PathVariable String raceName) throws GeneralException {
		return new ResponseEntity<>(qualyService.getPoleForRace(year, raceName), HttpStatus.OK);
	}
	
	@GetMapping("/byRace/{year}/{raceName}")
	public ResponseEntity<List<QualifyingDTO>> getQualifyingForRace(@Min(value=1950, message="{qualifying.year.min}") @Max(value=2050, message="{qualifying.year.max}") 
						@PathVariable Integer year, @NotEmpty(message="{qualifying.raceName.required}") @PathVariable String raceName) throws GeneralException {
		return new ResponseEntity<>(qualyService.getQualifyingForRace(year, raceName), HttpStatus.OK);
	}
	
	@GetMapping("/seasonPoles/{year}")
	public ResponseEntity<List<QualifyingDTO>> getPolesForSeason(@Min(value=1950, message="{qualifying.year.min}") @Max(value=2050, message="{qualifying.year.max}") 
						@PathVariable Integer year) throws GeneralException {
		return new ResponseEntity<>(qualyService.getPolesForSeason(year), HttpStatus.OK);
				
	}
}
