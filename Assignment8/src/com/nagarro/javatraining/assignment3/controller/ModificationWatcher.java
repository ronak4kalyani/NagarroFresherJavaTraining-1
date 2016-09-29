package com.nagarro.javatraining.assignment3.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.javatraining.assignment3.hibernateutil.HibernateSF;
import com.nagarro.javatraining.assignment3.input.DirectoryReader;
import com.nagarro.javatraining.assignment3.model.Airline;
import com.nagarro.javatraining.assignment3.model.Constants;


public class ModificationWatcher implements Runnable   {

	static HashMap<String,Long> lastModifiedAt = new HashMap<String,Long>();

	public void run()
	{
		File[] files = Constants.file.listFiles();
		Session session ;
		ArrayList<String> l = new ArrayList<String>();
		for (File f : files) {
			if((!(lastModifiedAt.containsKey(f.getName())))||(f.lastModified()>lastModifiedAt.get(f.getName())))
			{
				
				Airline aObj = DirectoryReader.readFile(f) ;
				session = HibernateSF.sf.openSession();
				session.beginTransaction();
				if (!(lastModifiedAt.containsKey(f.getName()))) {
					session.persist(aObj);
				}
				else {
					Query query = session.createQuery("from Airline where name = :string");
					query.setParameter("string", f.getName());
					Airline a= (Airline)query.uniqueResult();
					a = session.load(Airline.class, a.getId());
					session.delete(a);
					session.persist(aObj);
				}
				session.getTransaction().commit();
				session.close();
				lastModifiedAt.put(f.getName(), f.lastModified());
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
				session = HibernateSF.sf.openSession();
				session.beginTransaction() ;
				Query query = session.createQuery("from Airline where name = :string");
				query.setParameter("string", string);
				Airline a= (Airline)query.uniqueResult();
				a = session.load(Airline.class, a.getId());
				session.delete(a);
				session.getTransaction().commit();
				lastModifiedAt.remove(string);
				session.close();
			}
		}
	}
}
