package com.barrette.f1site.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.ConstructorsDoc;

public interface ConstructorsRepository extends MongoRepository<ConstructorsDoc, String> {

	Optional<ConstructorsDoc> findByName(String name);
}
