package com.nagarro.javatraining.assignment3.input;

import java.io.* ;
import java.text.ParseException;
import java.util.* ;

import org.apache.log4j.Logger;
import com.nagarro.javatraining.assignment3.model.*;

public class DirectoryReader {
	private static final Logger log= Logger.getLogger("Mainlogger");
	private DirectoryReader(){
		
	}
	
	public static Airline readFile(File file) {
		BufferedReader reader = null;
		FileReader freader = null ;
		Airline aObj = new Airline();
		aObj.setName(file.getName());
		HashSet<Flight> flightSet = new HashSet<Flight>();
		try {
			freader = new FileReader(file) ;
			reader = new BufferedReader(freader);
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				Flight f = manipulateLine(line,aObj);
				line = reader.readLine();
				flightSet.add(f);
			}
		} catch (Exception e) {
			log.error(e);
			log.error("Could Not Read the File");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					log.error(e);
					log.error("Could Not Close the File");
				}
			}
			if (freader != null) {
				try {
					freader.close();
				} catch (Exception e) {
					log.error(e);
					log.error("Could Not Close the File");
				}
			}
		}
		aObj.setFlights(flightSet); 
		return aObj;
	}

	private static Flight manipulateLine(String line, Airline aObj) {

		StringTokenizer st = new StringTokenizer(line, "|");

		String flightNo = st.nextToken();
		String depLoc = st.nextToken();
		String arrLoc = st.nextToken();

		String validTillDate = st.nextToken();
		Date validTill = new Date();
		try {
			validTill = Constants.dateformat.parse(validTillDate);
		} catch (ParseException e) {
			log.warn("Date not in appropriate(dd-MM-yyyy) format");
		}

		String flightTime = st.nextToken();
		Double flightDuration = Double.parseDouble(st.nextToken());
		int fare = Integer.parseInt(st.nextToken());

		String avail = st.nextToken();
		Boolean seatAvailability;
		if (avail.charAt(0) == 'Y')
			seatAvailability = true;
		else
			seatAvailability = false;

		String flightClass = st.nextToken();
		
		
		Map<String, Object> flight = new HashMap<String, Object>() ;
		flight.put("flightNo", flightNo);
		flight.put("depLoc", depLoc);
		flight.put("arrLoc", arrLoc);
		flight.put("fare", fare);
		flight.put("validTill", validTill);
		flight.put("flightTime", flightTime);
		flight.put("flightDuration", flightDuration);
		flight.put("seatAvailability", seatAvailability);
		flight.put("flightClass", flightClass);
		flight.put("airline", aObj);
		return new Flight(flight);
		}
}
