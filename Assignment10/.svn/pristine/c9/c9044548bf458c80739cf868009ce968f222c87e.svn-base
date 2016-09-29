package com.nagarro.javatraining.assignment10.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Flight  {
	@Id @GeneratedValue
	private int id ;
	private String flightNo ;
	private String depLoc ;
	private String arrLoc;
	private Date validTill ;
	private String flightTime ;
	private Double flightDuration ;
	private int fare ;
	private boolean seatAvailability;
	private String flightClass ;
	@ManyToOne
	private Airline airline ;
	
	public Flight(){
		
	}
	
	public Flight(String flightNo, String depLoc, String arrLoc, int fare,
			Date validTill, String flightTime, Double flightDuration,
			boolean seatAvailability, String flightClass,Airline airline ) {
		super();
		this.flightNo = flightNo;
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.seatAvailability = seatAvailability;
		this.flightClass = flightClass;
		if (flightClass.equalsIgnoreCase("EB"))
			fare = 140 * fare / 100;
		this.fare = fare;
		this.airline =airline ;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepLoc() {
		return depLoc;
	}
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}
	public String getArrLoc() {
		return arrLoc;
	}
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public Double getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public boolean isSeatAvailability() {
		return seatAvailability;
	}
	public void setSeatAvailability(boolean seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}