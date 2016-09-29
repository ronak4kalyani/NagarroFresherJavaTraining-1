package com.nagarro.javatraining.assignment4.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.javatraining.assignment4.HB.HibernateUtil;
import com.nagarro.javatraining.assignment4.model.User;

/**
 * Servlet implementation class forgotPass
 */
@WebServlet(description = "gets called when 'forgot password' is clicked and returns password!!", urlPatterns = { "/forgotPass" })
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("Username");
		String email = request.getParameter("email");
		
		Session session = HibernateUtil.sf.openSession();
		Query query = session.createQuery("from User where username=:username");
		query.setParameter("username", username);
		User user = (User)query.uniqueResult();
		
		if (user==null)
			response.getWriter().print("No such User Exists");
		else if(user.getEmail().equalsIgnoreCase(email))
			response.getWriter().print("Your Password is : "+ user.getPass());
		else
			response.getWriter().print("Sorry, Email and username doesn't match");
		
		session.close();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies==null)
		{
			resp.sendRedirect("Welcome");
			return  ;
		}
		for (Cookie c : cookies) {
			if(c.getName().equals("username"))
				resp.sendRedirect("ImageUtility");
		}
	}
	


}
