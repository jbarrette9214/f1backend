package com.barrette.f1site.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.Qualifying;
import com.barrette.f1site.dtos.QualifyingDTO;
import com.barrette.f1site.repositories.QualifyingRepo;
import com.barrette.f1site.services.interfaces.QualifyingService;
import com.barrette.f1site.utilities.GeneralException;

@Service(value="qualifyingService")
public class QualifyingServiceImpl implements QualifyingService {
	
	@Autowired
	QualifyingRepo qualyRepo;

	@Override
	@Transactional
	public QualifyingDTO addQualifying(QualifyingDTO dto) throws GeneralException {
		Optional<Qualifying> qual = qualyRepo.findTopByYearAndRaceNameAndPosition(dto.getYear(),
								dto.getRaceName(), dto.getPosition());
		if(qual.isPresent())
			throw new GeneralException("service.qualifying.present");
		
		Qualifying qualy = qualyRepo.save(QualifyingDTO.convertToDoc(dto));
		
		return QualifyingDTO.convertToDTO(qualy);
	}

	@Override
	public QualifyingDTO getPoleForRace(Integer year, String raceName) throws GeneralException {
		Qualifying qual = qualyRepo.findByYearAndRaceNameAndPosition(year, raceName, 1)
											.orElseThrow(()->new GeneralException("service.qualifying.notFoundPole"));
		
		return QualifyingDTO.convertToDTO(qual);
	}

	@Override
	public List<QualifyingDTO> getQualifyingForRace(Integer year, String raceName) throws GeneralException {
		List<Qualifying> qualy = qualyRepo.findByYearAndRaceName(year, raceName);
		
		if(qualy.isEmpty())
			throw new GeneralException("service.qualifying.notFoundRound");
		
		return qualy.stream().map(QualifyingDTO::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<QualifyingDTO> getPolesForSeason(Integer year) throws GeneralException {
		List<Qualifying> qualy = qualyRepo.findByYearAndPosition(year, 1);
		
		if(qualy.isEmpty())
			throw new GeneralException("service.qualifying.notFoundSeasonPoles");
		
		return qualy.stream().map(QualifyingDTO::convertToDTO).collect(Collectors.toList());
	}

}
