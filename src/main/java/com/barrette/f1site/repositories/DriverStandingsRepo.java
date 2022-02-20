package com.barrette.f1site.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.DriverStandings;

public interface DriverStandingsRepo extends MongoRepository<DriverStandings, String> {

}
