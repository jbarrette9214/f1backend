package com.barrette.f1site.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.ConstructorsDoc;

public interface ConstructorsRepository extends MongoRepository<ConstructorsDoc, String> {

	ConstructorsDoc findByName(String name);
}
