package com.nagarro.javatraining.assignment3.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.log4j.Logger;

import com.nagarro.javatraining.assignment3.model.*;

public class InputAcceptor {
	private static final Logger log= Logger.getLogger("Mainlogger");
	private InputAcceptor(){
		
	}
	
	public static UserInput enterInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String source;
		String destination;
		String flightClass;
		int outputPreference;
		Date flightDate;

		log.info("DEP LOC: ");

		while ((source = UserInputValidator.validateSource(br.readLine())) == null) {
			continue;
		}

		log.info("ARR LOC: ");
		while ((destination = UserInputValidator.validateDestination(br.readLine())) == null) {
			continue;
		}

		log.info("Flight Class: ");
		while ((flightClass = UserInputValidator.validateFlightClass(br.readLine())) == null) {
			continue;
		}

		log.info("Date Of Travel(DD-MM-YYYY): ");
		while ((flightDate = UserInputValidator.validateDate(br.readLine())) == null) {
			continue;
		}

		log.info("Output preference(Sort by Fare/Duration)):\n(Enter 1/2): ");
		outputPreference = 0 ;
		while (outputPreference == 0) {
			try {
				outputPreference = UserInputValidator.validateOutputPreference(Integer.parseInt(br.readLine()));
			} catch (NumberFormatException e) {
				outputPreference = 0 ;
				log.warn("Output preference entered Inappropriately, Enter Again : ");
			}
		}

		return new UserInput(source, destination, flightDate,
				flightClass, outputPreference);
	}
}
