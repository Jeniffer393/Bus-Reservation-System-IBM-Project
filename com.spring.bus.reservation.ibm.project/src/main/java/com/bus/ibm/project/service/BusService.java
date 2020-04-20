package com.bus.ibm.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	BusRepository busRepo;
	/*@Autowired
	RouteRepository routeRepo;
	@Autowired
	AgencyRepository agencyRepo;*/
	@Autowired
	AgencyService agencyService;
	@Autowired
	RouteService routeService;
	@Autowired
	BusRouteService busRouteService;
	@Autowired
	BusRouteRepository busRouteRepo;
	
    public void  addBus(Bus bus) {
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
	    busRepo.save(bus);
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
    	 busRouteService.deleteBusRouteDetails(busId);
    	 busRepo.deleteById(busId);
         }
     }
	 public void updateBus(Bus bus) {
		   busRepo.save(bus);
	 }


}
