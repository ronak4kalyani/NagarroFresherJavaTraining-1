package com.nagarro.javatraining.assignment2.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.javatraining.assignment2.input.DirectoryReader;
import com.nagarro.javatraining.assignment2.model.Constants;


public class ModificationWatcher implements Runnable ,Constants  {

	HashMap<String,Long> lastModifiedAt = new HashMap<String,Long>();

	public void run()
	{
		File files[] = file.listFiles();
		ArrayList<String> l = new ArrayList<String>();
		for (File f : files) {
			if((!(lastModifiedAt.containsKey(f.getName())))||(f.lastModified()>lastModifiedAt.get(f.getName())))
			{
				lastModifiedAt.put(f.getName(), f.lastModified());
				synchronized(Utility.flightsInfo) 
				{
					Utility.flightsInfo.put(f.getName(), DirectoryReader.readFile(f));
				}
//					System.out.println("Adding file : " + f.getName());
			}
			l.add(f.getName());
		}


		Set <String> fc = lastModifiedAt.keySet();
		Set <String> fname = new HashSet<String>() ;
		fname.addAll(fc);
		
		if(fc.size()==l.size())
			return ;
		for (String string : fname) {
			if (!(l.contains(string)))
			{
				lastModifiedAt.remove(string);
				synchronized(Utility.flightsInfo) 
				{
					Utility.flightsInfo.remove(string);
				}
//				System.out.println("Removing file : " + string);
			}
		}
	}
}
