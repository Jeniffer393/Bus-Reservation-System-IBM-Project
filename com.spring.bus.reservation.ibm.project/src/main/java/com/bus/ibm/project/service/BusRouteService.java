package com.bus.ibm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.ibm.project.exception.BusRouteException;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.repository.BusRouteRepository;

@Service
public class BusRouteService {

	
	@Autowired
	BusRouteRepository  busRouteRepo;;

	
	public void addBusToRoute(BusRouteDetails busRouteDetails) throws BusRouteException{
		
		BusRouteDetails existingBusRouteDetails=busRouteRepo.searchBusRoute(busRouteDetails.getBus().getBusId(), busRouteDetails.getRoute().getRouteId());
		if(existingBusRouteDetails!=null) {
			throw new BusRouteException("Bus Id with "+busRouteDetails.getBus().getBusId()+ " is already assigned  a route with routeId"+busRouteDetails.getRoute().getRouteId());
		}else {
		busRouteRepo.save(busRouteDetails);

		}
	}	
	
	public  Iterable<BusRouteDetails> getAllActiveBuses(){
	return busRouteRepo.findAll();
		
	}
	
	public List<BusRouteDetails> getAllActiveBusesByBusId(String busId){
		return busRouteRepo.findByBusBusId(busId);
	}
    
	public void deleteBusRouteDetails(String busId) {
		   busRouteRepo.deleteByBusBusId(busId);
	}

	public void updateRouteOfBus(Iterable<BusRouteDetails> busRouteDetails) {
		  for(BusRouteDetails newBusRouteDetail:busRouteDetails) {
			  busRouteRepo.save(newBusRouteDetail);
		  }
		
		
	}
	
	
}
