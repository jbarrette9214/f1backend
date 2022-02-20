package com.barrette.f1site.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.FastestLap;

public interface FastestLapRepo extends MongoRepository<FastestLap, String> {

}
