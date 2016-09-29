package com.nagarro.javatraining.assignment2.controller;

import java.io.* ;
import java.util.* ;
import java.util.concurrent.*;

import com.nagarro.javatraining.assignment2.input.* ;
import com.nagarro.javatraining.assignment2.model.*;


public class Utility {

	public static HashMap<String,HashSet<Flight>> flightsInfo = new HashMap<String,HashSet<Flight>>();

	public static void main(String[] args) throws IOException {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Flight> result = new ArrayList<Flight>();
		String choice = null  ;
		UserInput  uiObj ;

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);

		do {
			uiObj= InputAcceptor.enterInput() ;
			result.clear();
			synchronized(Utility.flightsInfo) 
			{
				for (HashSet<Flight> set : flightsInfo.values()) {
					for (Flight f : set) {
						if (f.getDepLoc().equalsIgnoreCase(uiObj.getDepLoc())
								&& f.getArrLoc().equalsIgnoreCase(uiObj.getArrLoc())
								&& f.getFlightClass().equalsIgnoreCase(uiObj.getFlightClass())
								&& (uiObj.getFlightDate().compareTo(f.getValidTill()) <= 0)
								&& f.isSeatAvailability())
							result.add(f);
					}
				}
			}
			if (uiObj.getOutputPreference()==1)
				Collections.sort(result, new FlightPriceComparator());
			else
				Collections.sort(result, new FlightDurationComparator());
			System.out.println("\nResult:");
			for (Flight f : result) {
				System.out.println(f);
			}
			System.out.print("\nWant to Exit (Enter Y/N)");
			while(!((choice = br.readLine()).equalsIgnoreCase("y")||choice.equalsIgnoreCase("n")))
				System.out.print("I could not Understand Enter Again:");
		} while (choice.equalsIgnoreCase("n"));
		service.shutdown();
	}

}
