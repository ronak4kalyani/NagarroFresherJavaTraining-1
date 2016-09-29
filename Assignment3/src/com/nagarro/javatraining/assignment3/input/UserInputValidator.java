package com.nagarro.javatraining.assignment3.input;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.nagarro.javatraining.assignment3.hibernateUtil.HibernateSF;

import com.nagarro.javatraining.assignment3.model.*;

public class UserInputValidator extends Constants {
	public static Date validateDate(String str)
	{
		dateformat.setLenient(false);
		Date validTill = null;
		try {
			validTill =  dateformat.parse(str);
		} catch (ParseException e) {
			System.err.print("Date not in appropriate(dd-MM-yyyy) format, Enter Again: ");
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
			System.out.println(f);
			if (f.equalsIgnoreCase(src))
				return f ;
		}
		System.err.print("Flights from no such stations found, Kindly Enter Again: ");
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
			System.out.println(f);
			if (f.equalsIgnoreCase(destination))
				return f ;
		}
		System.err.print("Flights to no such stations found, Kindly Enter Again: ");
		return null;
	}

	public static String validateFlightClass(String str) {
		if (str.equalsIgnoreCase("E")||str.equalsIgnoreCase("EB"))
			return str.toUpperCase() ;
		else
		{
			System.err.print("Flight Class entered Inappropriately, Enter Again :");
			return null;
		}
	}

	public static int validateOutputPreference(int i) {
		if((i==1)||(i==2))
			return i ;
		else
		{
			System.err.print("Output preference entered Inappropriately, Enter Again : ");
			return 0;
		}
	}

}