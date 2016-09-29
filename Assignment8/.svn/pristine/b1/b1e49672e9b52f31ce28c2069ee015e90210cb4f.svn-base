package com.nagarro.javatraining.assignment3.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Flight {
	@Id @GeneratedValue
	int id ;
	String flightNo ;
	String depLoc ;
	String arrLoc;
	Date validTill ;
	String flightTime ;
	Double flightDuration ;
	int fare ;
	boolean seatAvailability;
	String flightClass ;
	@ManyToOne
	Airline airline ;
	
	public Flight(){
		// it is defined just to make it visible .
	}
	
	public Flight(Map<String, Object> flight) {
		
		this.flightNo = (String) flight.get("flightNo");
		this.depLoc = (String) flight.get("depLoc");
		this.arrLoc = (String) flight.get("arrLoc");
		this.validTill = (Date) flight.get("validTill");
		this.flightTime = (String) flight.get("flightTime");
		this.flightDuration = (Double) flight.get("flightDuration");
		this.seatAvailability = (Boolean) flight.get("seatAvailability");
		this.flightClass = (String) flight.get("flightClass");
		this.airline = (Airline) flight.get("airline");
		int fareField =  (Integer) flight.get("fare");
		if (("EB").equalsIgnoreCase(flightClass))
			this.fare = 140 * fareField / 100;
		else
		this.fare = fareField;
	}
	
	public int getId() {
		return id;
	}

	public Airline getAirline() {
		return airline;
	}

	public String getFlightNo() {
		return flightNo;
	}
	public String getDepLoc() {
		return depLoc;
	}
	public String getArrLoc() {
		return arrLoc;
	}
	public int getFare() {
		return fare;
	}
	public Date getValidTill() {
		return validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public Double getFlightDuration() {
		return flightDuration;
	}
	public boolean isSeatAvailability() {
		return seatAvailability;
	}
	public String getFlightClass() {
		return flightClass;
	}

	@Override
	public String toString() {
		return "flightNo=" + flightNo + ", depLoc=" + depLoc
				+ ", arrLoc=" + arrLoc + ", validTill=" + Constants.dateformat.format(validTill)
				+ ", flightTime=" + flightTime + ", flightDuration="
				+ String.format("%.2f", flightDuration) + ", fare=" + fare + ", seatAvailability="
				+ seatAvailability + ", flightClass=" + flightClass ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrLoc == null) ? 0 : arrLoc.hashCode());
		result = prime * result + ((depLoc == null) ? 0 : depLoc.hashCode());
		result = prime * result
				+ ((flightNo == null) ? 0 : flightNo.hashCode());
		result = prime * result
				+ ((flightTime == null) ? 0 : flightTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrLoc == null) {
			if (other.arrLoc != null)
				return false;
		} else if (!arrLoc.equals(other.arrLoc))
			return false;
		if (depLoc == null) {
			if (other.depLoc != null)
				return false;
		} else if (!depLoc.equals(other.depLoc))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (flightTime == null) {
			if (other.flightTime != null)
				return false;
		} else if (!flightTime.equals(other.flightTime))
			return false;
		return true;
	}
	
}
