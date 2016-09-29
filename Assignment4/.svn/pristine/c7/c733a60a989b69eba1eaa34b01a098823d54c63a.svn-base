package com.nagarro.javatraining.assignment4.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies!=null)
		{
			for (Cookie c : cookies) {
				if(c.getName().equals("username"))
				{
					resp.sendRedirect("ImageUtility");
					return ;
				}
			}
		}
		resp.sendRedirect("loginPage.html");
	}

}
