package org.nagarro.javatraining.assignment3.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSF {

	public static SessionFactory sf = new Configuration().configure().buildSessionFactory();  
}
