package com.nagarro.javatraining.assignment3.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Airline {
	@Id @GeneratedValue
	int id ;
	String name ;
	
	@OneToMany(mappedBy = "airline" , cascade =  CascadeType.ALL )
	Set<Flight> flights ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	
}
