package com.nagarro.javatraining.assignment10.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitThreadSchdulors implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("server destroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);
	}

}
