package com.nagarro.javatraining.assignment3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.javatraining.assignment3.hibernateutil.HibernateSF;

public class UserInput {
	String depLoc ;
	String arrLoc ;
	Date flightDate ;
	String flightClass ;
	int outputPreference ;
	
	public UserInput(String depLoc, String arrLoc, Date flightDate,
			String flightClass, int outputPreference) {
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.flightDate = flightDate;
		this.flightClass = flightClass;
		this.outputPreference = outputPreference;
	}
	
	public String getDepLoc() {
		return depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public int getOutputPreference() {
		return outputPreference;
	}

	@Override
	public String toString() {
		return "depLoc=" + depLoc + ", arrLoc=" + arrLoc
				+ ", flightDate=" + Constants.dateformat.format(flightDate) + ", flightClass=" + flightClass
				+ ", outputPreference=" + outputPreference ;
	}
	
	
	public List<Flight> getListOfMatchingFlights(){
		ArrayList<Flight> result = new ArrayList<Flight>();
		
		Session session =  HibernateSF.sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Flight");
		@SuppressWarnings("unchecked")
		List<Flight> flightSet = query.list();
		session.getTransaction().commit();
		session.close();
		
		
		for (Flight flight : flightSet) {
			if (!(flight.getDepLoc().equalsIgnoreCase(getDepLoc()) && flight.getArrLoc().equalsIgnoreCase(getArrLoc())))
				continue;
			
		     if(flight.getFlightClass().equalsIgnoreCase(getFlightClass())
					&& (getFlightDate().compareTo(flight.getValidTill()) <= 0)
					&& flight.isSeatAvailability())
				result.add(flight);
		}
			
		if (getOutputPreference()==1)
			Collections.sort(result, new FlightPriceComparator());
		else
			Collections.sort(result, new FlightDurationComparator());
		
		return result;
	}
	
	
}
