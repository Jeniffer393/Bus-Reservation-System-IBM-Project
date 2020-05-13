package com.bus.ibm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.ibm.project.exception.AgencyAlreadyExistsException;
import com.bus.ibm.project.model.Agency;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.Route;
import com.bus.ibm.project.repository.AgencyRepository;

@Service
public class AgencyService {
    @Autowired
    AgencyRepository agencyRepo;
	/*
	public Agency addAgency(Bus bus) {
		//firstmethod
		/*Agency agency=new Agency();
		String agencyId=bus.getAgency().getAgencyId();
		agency.setAgencyId("R14");
		agency.setAgencyName(bus.getAgency().getAgencyName());
	    agencyRepo.save(agency);
	    return agency;
	}*/
    public String addAgency(Agency agency) throws AgencyAlreadyExistsException {
    	   Agency existingAgency=agencyRepo.findByAgencyName(agency.getAgencyName());
           List<Agency> agencies= agencyRepo.findAll();
           if(agencies.isEmpty()) {
        	 agency.setAgencyId("RBA1");
        	 agencyRepo.save(agency);
        	 return "AgencyId is RBA1";
           } else {
        	     if(existingAgency!=null)
        	     {
        		   throw new AgencyAlreadyExistsException("Agency with name "+agency.getAgencyName()+" is already added");
        	     }else {
                    int maxId=0;
	               for(Agency newAgency:agencies) {
	    	       int newId=Integer.parseInt(newAgency.getAgencyId().substring(3));
	    	       if(newId>maxId) {
	    		    maxId=newId; 
	    	          }  
	               }
	              String newAgencyId="RBA"+""+(maxId+1)+"";
	              agency.setAgencyId(newAgencyId);
	              agencyRepo.save(agency);
	              return "AgencyId is"+newAgencyId+"";
	            }		
             }
    
    }
    public List<Agency> getAllAgencies(){
    	return agencyRepo.findAll();
    }
	

	
}
