package com.barrette.f1site.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.Race;

public interface RacesRepo extends MongoRepository<Race, String> {

	Race findByNameAndYear(String name, Integer year);
	
}
