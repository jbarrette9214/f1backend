package com.barrette.f1site.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.Qualifying;

public interface QualifyingRepo extends MongoRepository<Qualifying, String> {

}
