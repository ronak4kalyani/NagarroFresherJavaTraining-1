package com.nagarro.javatraining.assignment10.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nagarro.javatraining.assignment10.model.User;

public class LogOutCheckerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session  =  request.getSession() ;
		User user = (User) session.getAttribute("loginedUser");
		if(user!=null)
		{	
			response.sendRedirect("flightSearch");
			return false ;
		}
		return true;
	}
}
