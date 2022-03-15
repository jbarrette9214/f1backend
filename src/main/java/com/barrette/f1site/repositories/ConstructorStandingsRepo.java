package com.barrette.f1site.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.ConstructorStandings;

public interface ConstructorStandingsRepo extends MongoRepository<ConstructorStandings, String> {

	Optional<ConstructorStandings> findByYear(String year);
	
}
