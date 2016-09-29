package com.nagarro.javatraining.assignment10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javatraining.assignment10.model.User;

@Controller
public class LogOut {
	
	
	@RequestMapping(value ="/logout" , method=RequestMethod.GET)
	public ModelAndView getlogin(HttpSession session){
		 User user = (User)session.getAttribute("loginedUser") ;
		System.out.println("logging out the "+ user.getUserId());
		
		session.removeAttribute("loginedUser");
		ModelAndView modelAndView = new ModelAndView("redirect:login") ;
		return modelAndView ;
	}
	
}
