package com.barrette.f1site.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barrette.f1site.documents.FastestLap;
import com.barrette.f1site.dtos.FastestLapDTO;
import com.barrette.f1site.repositories.FastestLapRepo;
import com.barrette.f1site.services.interfaces.FastestLapService;
import com.barrette.f1site.utilities.GeneralException;

@Service(value="fastestLapService")
public class FastestLapServiceImpl implements FastestLapService {

	@Autowired
	FastestLapRepo fastestLapRepo;
	
	@Override
	@Transactional
	public FastestLapDTO addFastestLap(FastestLapDTO dto) throws GeneralException {
		Optional<FastestLap> lap = fastestLapRepo.findByYearAndRaceName(dto.getYear(), dto.getRaceName());
		
		if(lap.isPresent())
			throw new GeneralException("service.fastestLap.present");
		
		FastestLap fLap = fastestLapRepo.save(FastestLapDTO.convertToDoc(dto));
		
		return FastestLapDTO.convertToDTO(fLap);
	}

	@Override
	public FastestLapDTO getFastestLapByYearAndRaceName(Integer year, String raceName) throws GeneralException {
		FastestLap fLap = fastestLapRepo.findByYearAndRaceName(year, raceName)
								.orElseThrow(()-> new GeneralException("service.fastestLap.notFound"));
		
		return FastestLapDTO.convertToDTO(fLap);
	}

	@Override
	public List<FastestLapDTO> getDriversCareerFastestLaps(String driverName) throws GeneralException {
		List<FastestLap> laps = fastestLapRepo.findByDriverName(driverName);
		
		if(laps.isEmpty())
			throw new GeneralException("service.fastestLap.notFoundCareer");
		
		return laps.stream().map(FastestLapDTO::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<FastestLapDTO> getFastestLapsForYear(Integer year) throws GeneralException {
		List<FastestLap> laps = fastestLapRepo.findByYear(year);
		
		if(laps.isEmpty())
			throw new GeneralException("service.fastestLap.notFoundYear");
		
		return laps.stream().map(FastestLapDTO::convertToDTO).collect(Collectors.toList());
	}

}
