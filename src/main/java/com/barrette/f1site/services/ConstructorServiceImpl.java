package com.barrette.f1site.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.ConstructorsDoc;
import com.barrette.f1site.dtos.ConstructorDTO;
import com.barrette.f1site.repositories.ConstructorsRepository;
import com.barrette.f1site.services.interfaces.ConstructorService;
import com.barrette.f1site.utilities.GeneralException;

@Service
@Transactional
public class ConstructorServiceImpl implements ConstructorService {
	
	@Autowired
	ConstructorsRepository constructorRepo;
	
	final String NOT_FOUND = "service.constructor.notFound";

	@Override
	public ConstructorDTO getConstructorInfo(String constructorName) throws GeneralException{
		ConstructorsDoc cons = constructorRepo.findByName(constructorName)
										.orElseThrow(()->new GeneralException(NOT_FOUND));
		
		return ConstructorDTO.convertToDTO(cons);
	}

	@Override
	public ConstructorDTO addNewConstructor(ConstructorDTO dto) throws GeneralException {
		Optional<ConstructorsDoc> cons = constructorRepo.findByName(dto.getName());
		
		if(cons.isPresent())
			throw new GeneralException("service.constructor.alreadyPresent");
		
		ConstructorsDoc constructor = ConstructorDTO.convertToDoc(dto);
		constructor.setWins(0);
		constructor.setRaceCount(0);
		constructor.setPodiums(0);
		
		constructor = constructorRepo.save(constructor);
		
		return ConstructorDTO.convertToDTO(constructor);
	}

	@Override
	public String incrementConstructorRaceCount(String id) throws GeneralException {
		ConstructorsDoc cons = constructorRepo.findById(id).orElseThrow(()-> new GeneralException(NOT_FOUND));
		
		cons.setRaceCount(cons.getRaceCount() + 1);
		
		constructorRepo.save(cons);
		
		return "Race count updated";
	}

	@Override
	public String incrementConstructorWin(String id) throws GeneralException {
		ConstructorsDoc cons = constructorRepo.findById(id).orElseThrow(()-> new GeneralException(NOT_FOUND));
		
		cons.setWins(cons.getWins() + 1);
		constructorRepo.save(cons);
		
		return "Win count updated";
	}

	@Override
	public String incrementConstructorPodium(String id) throws GeneralException {
		ConstructorsDoc cons = constructorRepo.findById(id).orElseThrow(()-> new GeneralException(NOT_FOUND));
		
		cons.setPodiums(cons.getPodiums() + 1);
		constructorRepo.save(cons);
		
		return "Podium count updated";
	}

	
}
