package com.barrette.f1site.services.interfaces;

import com.barrette.f1site.dtos.ConstructorDTO;
import com.barrette.f1site.utilities.GeneralException;

public interface ConstructorService {

	public ConstructorDTO getConstructorInfo(String constructorName) throws GeneralException;
	public ConstructorDTO addNewConstructor(ConstructorDTO dto) throws GeneralException;
	public String incrementConstructorRaceCount(String id) throws GeneralException;
	public String incrementConstructorWin(String id) throws GeneralException;
	public String incrementConstructorPodium(String id) throws GeneralException;
	
}
