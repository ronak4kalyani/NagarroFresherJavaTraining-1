package com.nagarro.javatraining.assignment10.controller;

import java.io.* ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.* ;

import com.nagarro.javatraining.assignment10.model.Airline;
import com.nagarro.javatraining.assignment10.model.Flight;

public class ReadAirlineFromFile {

	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	
	public static Airline readFile(File file) {
		BufferedReader reader = null;
		Airline aObj = new Airline();
		aObj.setName(file.getName());
		HashSet<Flight> flight_Set = new HashSet<Flight>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				Flight f = manipulateLine(line,aObj);
				line = reader.readLine();
				flight_Set.add(f);
			}
		} catch (Exception e) {
			System.err.println("Could Not Read the File");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					System.err.println("Could Not Close the File");
				}
			}
		}
		aObj.setFlights(flight_Set); 
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
			validTill = dateformat.parse(validTillDate);
		} catch (ParseException e) {
			System.err.print("Date not in appropriate(dd-MM-yyyy) format");
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

		return new Flight(flightNo, depLoc, arrLoc, fare, validTill,
				flightTime, flightDuration, seatAvailability, flightClass,aObj);
		}
}
