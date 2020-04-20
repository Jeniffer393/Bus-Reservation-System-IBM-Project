package com.bus.ibm.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="agency")
public class Agency {
	
	@Id
	private String agencyId;
	
	@NotNull
	@NotEmpty
	private String agencyName;
	
	@OneToMany(mappedBy = "agency")
	private Set<Bus> buses=new HashSet<>();
	
	
    
	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Agency(String agencyId, @NotEmpty String agencyName) {
		this.agencyId = agencyId;
		this.agencyName = agencyName;
	}
	
	public Agency() {
		
	}
    @JsonIgnore
	public Set<Bus> getBuses() {
		return buses;
	}

	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}
	
	
	

	
}
