package com.nagarro.javatraining.assignment10.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.javatraining.assignment10.Dao.FlightNAirlineDao;
import com.nagarro.javatraining.assignment10.Util.AppContextUtil;
import com.nagarro.javatraining.assignment10.model.Airline;


public class ModificationWatcher implements Runnable   {

	static HashMap<String,Long> lastModifiedAt = new HashMap<String,Long>();
	File dir = new File("C:\\Users\\ronakkalyani\\workspace\\Assignment10\\CSV");

//	File dir = new File("\\CSV");
	static FlightNAirlineDao flightDao = (FlightNAirlineDao) AppContextUtil.context.getBean("flightDao");
    
	
	public void run()
	{
		File files[] = dir.listFiles();
		ArrayList<String> listofFileNames = new ArrayList<String>();
		for (File file : files) {
			if((!(lastModifiedAt.containsKey(file.getName())))||(file.lastModified()>lastModifiedAt.get(file.getName())))
			{
				
				Airline airline = ReadAirlineFromFile.readFile(file) ;

				if (!(lastModifiedAt.containsKey(file.getName()))) {
					
					flightDao.saveAirline(airline);
				}
				else {

					flightDao.deleteAirline(file.getName());
					flightDao.saveAirline(airline);
					
				}

				lastModifiedAt.put(file.getName(), file.lastModified());

			}
			listofFileNames.add(file.getName());
		}


		Set <String> fileNamesofPast = new HashSet<String>() ;
		fileNamesofPast.addAll(lastModifiedAt.keySet());
		
		if(fileNamesofPast.size()==listofFileNames.size())
			return ;
		for (String string : fileNamesofPast) {
			if (!(listofFileNames.contains(string)))
			{
				
				flightDao.deleteAirline(string);
				lastModifiedAt.remove(string);

			}
		}
	}
}
