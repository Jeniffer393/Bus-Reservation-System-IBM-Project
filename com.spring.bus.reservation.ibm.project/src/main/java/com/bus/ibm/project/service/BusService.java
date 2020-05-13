package com.bus.ibm.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bus.ibm.project.exception.AddAgencyException;
import com.bus.ibm.project.exception.BusAlreadyExistsException;
import com.bus.ibm.project.model.Agency;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.model.Route;
import com.bus.ibm.project.repository.AgencyRepository;
import com.bus.ibm.project.repository.BusRepository;
import com.bus.ibm.project.repository.BusRouteRepository;
import com.bus.ibm.project.repository.RouteRepository;

@Service
public class BusService {
	@Autowired
	BusRepository     busRepo;
	/*@Autowired
	RouteRepository routeRepo;
	@Autowired
	AgencyRepository agencyRepo;*/
	@Autowired
	AgencyService     agencyService;
	@Autowired
	RouteService      routeService;
	@Autowired
	BusRouteService    busRouteService;
	@Autowired
	BusRouteRepository busRouteRepo;
	@Autowired
	BusSeatDetailsService busSeatDetailService;
	@Autowired
	EntityManager entitymanager;
	@Transactional
    public void  addBus(Bus bus) throws BusAlreadyExistsException, AddAgencyException {
		
		/*Agency agency =new Agency();
		Route route=new Route();
		agency.setAgencyId("R13");
		agency.setAgencyName(bus.getAgency().getAgencyName());
		agencyRepo.save(agency);
		route.setRouteId(bus.getRoute().getRouteId());
		route.setSource(bus.getRoute().getSource());
		route.setDestination(bus.getRoute().getDestination());
		route.setDistance(bus.getRoute().getDistance());
		routeRepo.save(route);
	    bus.setAgency(agencyService.addAgency(bus));
	    bus.setRoute(routeService.addRoute(bus));*/
    	Bus existingBus=busRepo.getBus(bus.getBusId());
    	if(existingBus!=null) {
    		throw new BusAlreadyExistsException("Bus with BusNumber "+bus.getBusId()+" is already added");
    	}else {
    		try {
	          busRepo.save(bus);
    		}catch(javax.persistence.EntityNotFoundException exception) {
    			entitymanager.getTransaction().rollback();
    			throw new AddAgencyException("Agency with name "+bus.getAgency().getAgencyName()+" is not added");
    		}
	    
	    }
    }
	
    public Optional<Bus> getBus(String id){
        	return  busRepo.findById(id);
    }
	
    public  Iterable<Bus> getAllBuses(){
	    return busRepo.findAll();
    }
    
    public void  deleteBus(String busId) {
    	 
    	 List<BusRouteDetails> busRouteDetails=busRouteRepo.findByBusBusId(busId);
    	 if(busRouteDetails.isEmpty()) {
    		 busRepo.deleteById(busId);
    	 }else {
    		 List<Integer>busRouteId=new ArrayList<>();
    		 for(BusRouteDetails existingBusRouteDetails:busRouteDetails) {
    			 busRouteId.add(existingBusRouteDetails.getBusRouteId());
    		 }
    	 busSeatDetailService.DeleteBusSeatDetails(busRouteId);
    	 busRouteService.deleteBusRouteDetails(busId);
    	 busRepo.deleteById(busId);
         }
     }
	 public void updateBus(Bus bus) {
		   busRepo.save(bus);
	 }


}
