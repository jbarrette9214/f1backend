package com.barrette.f1site.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barrette.f1site.documents.FastestLap;

public interface FastestLapRepo extends MongoRepository<FastestLap, String> {

	public Optional<FastestLap> findByYearAndRaceName(Integer year, String raceName);
	public List<FastestLap> findByDriverName(String driverName);
	public List<FastestLap> findByYear(Integer year);
	
}
