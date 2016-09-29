package com.nagarro.javatraining.assignment3.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Flight extends Constants {
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
				+ ", arrLoc=" + arrLoc + ", validTill=" + dateformat.format(validTill)
				+ ", flightTime=" + flightTime + ", flightDuration="
				+ String.format("%.2f", flightDuration) + ", fare=" + fare + ", seatAvailability="
				+ seatAvailability + ", flightClass=" + flightClass ;
	}

	
	
//	public boolean equals(Flight f) {
//		if(this.flightNo.equalsIgnoreCase(f.getFlightNo())&&
//				(this.validTill.compareTo(f.getValidTill())==0) &&
//				this.flightTime.equalsIgnoreCase(f.getFlightTime())&&
//				this.flightClass.equalsIgnoreCase(f.getFlightClass())&&
//				this.depLoc.equalsIgnoreCase(f.getDepLoc())&&
//				this.arrLoc.equalsIgnoreCase(f.getArrLoc())
//				)
//			return true;
//		else
//			return false;
//	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flightNo == null) ? 0 : flightNo.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
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
		if (seatAvailability != other.seatAvailability)
			return false;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}


	
	
}
