package com.barrette.f1site.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.Qualifying;

public interface QualifyingRepo extends MongoRepository<Qualifying, String> {

	List<Qualifying> findByYearAndRaceName(Integer year, String raceName);
	Optional<Qualifying> findTopByYearAndRaceNameAndPosition(Integer year, String raceName, Integer position);
	List<Qualifying> findByYearAndPosition(Integer year, Integer position);
	Optional<Qualifying> findByYearAndRaceNameAndPosition(Integer year, String raceName, Integer position);
	
}
