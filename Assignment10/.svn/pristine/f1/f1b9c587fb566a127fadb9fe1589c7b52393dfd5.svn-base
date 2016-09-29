package com.nagarro.javatraining.assignment10.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.nagarro.javatraining.assignment10.Dao.FlightNAirlineDao;
import com.nagarro.javatraining.assignment10.Util.AppContextUtil;
import com.nagarro.javatraining.assignment10.Util.FlightDurationComparator;
import com.nagarro.javatraining.assignment10.Util.FlightPriceComparator;

public class FlightDetailsEntered {
	
	@Size(min=3,max=3,message="should be a 3 letter code")
	private String depLoc ;
	
	@Size(min=3,max=3,message="should be a 3 letter code")
	private String arrLoc ;
	
	private Date flightDate ;
	@NotEmpty
	private String flightClass ;
	
	@Max(value=2,message="Choose valid entry")
	@Min(value=1,message="is required")
	private int outputPreference ;
	
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
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public int getOutputPreference() {
		return outputPreference;
	}
	public void setOutputPreference(int outputPreference) {
		this.outputPreference = outputPreference;
	}
	
	public List<Flight> getListOfMatchingFlights(){
		FlightNAirlineDao flightDao = (FlightNAirlineDao) AppContextUtil.context.getBean("flightDao");
		List<Flight> allFlights =  flightDao.getFlights();
		ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
		
		
		for (Flight flight : allFlights) {
			if (flight.getDepLoc().equalsIgnoreCase(getDepLoc())
					&& flight.getArrLoc().equalsIgnoreCase(getArrLoc())
					&& flight.getFlightClass().equalsIgnoreCase(getFlightClass())
					&& (getFlightDate().compareTo(flight.getValidTill()) <= 0)
					&& flight.isSeatAvailability())
				matchingFlights.add(flight);
		}
			
		if (getOutputPreference()==1)
			Collections.sort(matchingFlights, new FlightPriceComparator());
		else
			Collections.sort(matchingFlights, new FlightDurationComparator());
		
		return matchingFlights;
	}
}
