package com.bus.ibm.project.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.Route;
import com.bus.ibm.project.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
    RouteRepository routeRepo;

	//directed from adminController
   public   String addRoute(Route route) {
	       //first mistake
   
    	  /*Route route=new Route();
    	  route.setRouteId(bus.getRoute().getRouteId());
    	  route.setSource(bus.getRoute().getSource());
    	  route.setDestination(bus.getRoute().getDestination());
    	  route.setDistance(bus.getRoute().getDistance());
    	  routeRepo.save(route);
    	  return route;
    }*/
	     List<Route> routes=routeRepo.findAll();
	     if(routes.isEmpty()) {
	    	route.setRouteId("RC1");
	    	routeRepo.save(route);
	    	return "RouteId is RC1";
	     }else {
	      int maxId=0;
	      for(Route newRoute:routes) {
	    	  int newId=Integer.parseInt(newRoute.getRouteId().substring(2));
	    	  if(newId>maxId) {
	    		 maxId=newId; 
	    	  }  
	      }
	      String newRouteId="RC"+""+(maxId+1)+"";
	      route.setRouteId(newRouteId);
	      routeRepo.save(route);
	      return "RouteId is "+newRouteId+"";
	     }		
	  	   
   }
   
   public  List<Route>  getAllRoutes(){
    return  routeRepo.findAll();
   }
}
