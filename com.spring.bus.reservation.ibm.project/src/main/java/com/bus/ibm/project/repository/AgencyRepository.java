package com.bus.ibm.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bus.ibm.project.model.Agency;

public interface AgencyRepository  extends CrudRepository<Agency,String>{
    List<Agency> findAll();
    
}
