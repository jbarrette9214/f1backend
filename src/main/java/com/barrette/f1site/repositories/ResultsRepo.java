package com.barrette.f1site.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.Result;

public interface ResultsRepo extends MongoRepository<Result, String> {

}
