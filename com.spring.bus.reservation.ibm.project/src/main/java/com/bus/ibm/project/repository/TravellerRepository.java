package com.bus.ibm.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.bus.ibm.project.model.TravellerDetails;

public interface TravellerRepository extends CrudRepository<TravellerDetails,Integer> {

	
}
