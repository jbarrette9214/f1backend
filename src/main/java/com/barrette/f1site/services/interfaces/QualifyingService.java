package com.barrette.f1site.services.interfaces;

import java.util.List;

import com.barrette.f1site.dtos.QualifyingDTO;
import com.barrette.f1site.utilities.GeneralException;

public interface QualifyingService {
	
	public QualifyingDTO addQualifying(QualifyingDTO dto) throws GeneralException;
	public QualifyingDTO getPoleForRace(Integer year, String raceName) throws GeneralException;
	public List<QualifyingDTO> getQualifyingForRace(Integer year, String raceName) throws GeneralException;
	public List<QualifyingDTO> getPolesForSeason(Integer year) throws GeneralException;

}
