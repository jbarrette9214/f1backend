package com.barrette.f1site.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.barrette.f1site.documents.Race;

public interface RacesRepo extends MongoRepository<Race, String> {

	Optional<Race> findByNameIgnoreCaseAndYear(String name, Integer year);
	Optional<Race> findByYearAndRound(Integer year, Integer round);
	List<Race> findByYear(Integer year);
	
	@Query(value="{year: ?0}", fields="{raceId:1}")
	List<String> getListOfRaceIdsByYear(Integer year);
	
}
