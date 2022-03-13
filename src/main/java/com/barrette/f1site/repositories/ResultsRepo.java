package com.barrette.f1site.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.barrette.f1site.documents.Result;

public interface ResultsRepo extends MongoRepository<Result, String> {

	@Query(value="{raceId:?0}", fields="{id:0, driverId:1}")
	List<Result> getDriverIdsForRaceId(String raceId);
	
	@Query(value= "{driverId:?0, finishPos: 1}")
	List<Result> getDriverWins(String driverId);
	
	List<Result> findByDriverId(String driverId);
}
