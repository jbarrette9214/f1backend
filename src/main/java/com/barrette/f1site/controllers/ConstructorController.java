package com.barrette.f1site.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barrette.f1site.dtos.ConstructorDTO;
import com.barrette.f1site.services.interfaces.ConstructorService;
import com.barrette.f1site.utilities.GeneralException;

@RestController
@RequestMapping("/constructor")
public class ConstructorController {

	@Autowired
	ConstructorService constructorService;
	
	@GetMapping("/info/{constructorName}")
	public ResponseEntity<ConstructorDTO> getConstructorInfo(@PathVariable String constructorName) throws GeneralException {
		return new ResponseEntity<>(constructorService.getConstructorInfo(constructorName), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ConstructorDTO> addConstructor(@Valid @RequestBody ConstructorDTO dto) throws GeneralException {
		return new ResponseEntity<>(constructorService.addNewConstructor(dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/incrementRaceCount/{id}")
	public ResponseEntity<String> incrementConstructorRaceCount(@PathVariable String id) throws GeneralException {
		return new ResponseEntity<>(constructorService.incrementConstructorRaceCount(id), HttpStatus.OK);
	}
	
	@PutMapping("/incrementWin/{id}")
	public ResponseEntity<String> incrementConstructorWinCount(@PathVariable String id) throws GeneralException {
		return new ResponseEntity<>(constructorService.incrementConstructorWin(id), HttpStatus.OK);
	}
	
	@PutMapping("/incrementPodium/{id}")
	public ResponseEntity<String> incrementConstructorPodium(@PathVariable String id) throws GeneralException {
		return new ResponseEntity<>(constructorService.incrementConstructorPodium(id), HttpStatus.OK);
	}
	
}
