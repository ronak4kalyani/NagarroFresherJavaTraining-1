package com.nagarro.javatraining.assignment10.Util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextUtil {
	 public static AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
}
