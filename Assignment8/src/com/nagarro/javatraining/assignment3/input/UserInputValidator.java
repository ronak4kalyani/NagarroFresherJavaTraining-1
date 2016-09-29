package com.nagarro.javatraining.assignment3.input;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.javatraining.assignment3.hibernateutil.HibernateSF;
import com.nagarro.javatraining.assignment3.model.*;

public class UserInputValidator {
	private static final Logger log= Logger.getLogger("Mainlogger");
	private UserInputValidator(){
		
	}
	
	public static Date validateDate(String str)
	{
		Constants.dateformat.setLenient(false);
		Date validTill = null;
		try {
			validTill =  Constants.dateformat.parse(str);
		} catch (ParseException e) {
			log.warn("Date not in appropriate(dd-MM-yyyy) format, Enter Again: ");
		}
		return validTill ;
	}


	public static String validateSource(String src) {
		Session session =  HibernateSF.sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select distinct depLoc from Flight");
		@SuppressWarnings("unchecked")
		List<String> flightSet = query.list();
		session.getTransaction().commit();
		session.close();
		
		for (String f : flightSet )
		{
			log.info(f);
			if (f.equalsIgnoreCase(src))
				return f ;
		}
		log.warn("Flights from no such stations found, Kindly Enter Again: ");
		return null;
	}

	public static String validateDestination(String destination) {
		Session session =  HibernateSF.sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select distinct arrLoc from Flight");
		@SuppressWarnings("unchecked")
		List<String> flightSet = query.list();
		session.getTransaction().commit();
		session.close();
		for (String f : flightSet )
		{
			log.info(f);
			if (f.equalsIgnoreCase(destination))
				return f ;
		}
		log.warn("Flights to no such stations found, Kindly Enter Again: ");
		return null;
	}

	public static String validateFlightClass(String str) {
		if (("E").equalsIgnoreCase(str)||("EB").equalsIgnoreCase(str))
			return str.toUpperCase() ;
		else
		{
			log.warn("Flight Class entered Inappropriately, Enter Again :");
			return null;
		}
	}

	public static int validateOutputPreference(int i) {
		if((i==1)||(i==2))
			return i ;
		else
		{
			log.warn("Output preference entered Inappropriately, Enter Again : ");
			return 0;
		}
	}

}