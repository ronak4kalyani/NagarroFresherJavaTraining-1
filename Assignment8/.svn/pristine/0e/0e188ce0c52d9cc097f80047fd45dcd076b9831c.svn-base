package com.nagarro.javatraining.assignment3.controller;

import java.io.* ;
import java.util.* ;
import java.util.concurrent.*;

import org.apache.log4j.Logger;
import com.nagarro.javatraining.assignment3.input.*;
import com.nagarro.javatraining.assignment3.model.*;


public class Utility {

	private static final Logger log= Logger.getLogger("Mainlogger");
	private Utility() {
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		List<Flight> result = new ArrayList<Flight>();
		String choice   ;
		UserInput  userInputObj ;
		
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);

		do {
			userInputObj= InputAcceptor.enterInput() ;
			result.clear();
			result =  userInputObj.getListOfMatchingFlights();
			
			log.info("\nResult:");
			for (Flight f : result) {
				log.info(f);
			}
			log.info("\nWant to Exit (Enter Y/N)");
			while(!(("y").equalsIgnoreCase(choice = br.readLine())||("n").equalsIgnoreCase(choice)))
				log.warn("I could not Understand Enter Again:");
		} while (("n").equalsIgnoreCase(choice));
		service.shutdown();
	}

}
