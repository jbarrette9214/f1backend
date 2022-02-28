package com.barrette.f1site.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.Driver;

public interface DriverRepo extends MongoRepository<Driver, String> {

	Optional<Driver> findByNameIgnoreCase(String name);
	
}
