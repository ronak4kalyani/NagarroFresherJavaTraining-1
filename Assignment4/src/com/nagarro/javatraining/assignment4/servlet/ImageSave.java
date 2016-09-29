package com.nagarro.javatraining.assignment4.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.javatraining.assignment4.HB.HibernateUtil;
import com.nagarro.javatraining.assignment4.model.Image;
import com.nagarro.javatraining.assignment4.model.User;


/**
 * Servlet implementation class ImageSave
 */
@WebServlet("/ImageSave")
@MultipartConfig(maxFileSize=500*1024) 

public class ImageSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Assignment4/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = null ;
		
		Cookie[] cookies = request.getCookies();
		if (cookies!=null)
		{
			for (Cookie c : cookies) {
				if(c.getName().equals("username"))
				{
					username = c.getValue();
				}
			}
		}
		if (username==null)
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login First!!');");
		    out.println("location='/Assignment4/';");
			out.println("</script>");
			return ;
		}
		
		Part part = null ;
		try {
			part = request.getPart("imgFile");
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Image size greater than 500 KB!!');");
		    out.println("location='/Assignment4/ImageUtility';");
			out.println("</script>");
			return  ;
		}
		
		String fileName = extractFileName(part);
		
		String SAVE_DIR = "Images";
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String filePath = savePath + File.separator + fileName ;
		InputStream inputStream = part.getInputStream();
		byte[] bFile = new byte[(int) part.getSize()];
		inputStream.read(bFile);
		part.write(filePath );


		Image i = new Image() ;
		i.setImg(new File(filePath)) ;
		i.setImageData(bFile);
		
		
		
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User where username=:username");
		query.setParameter("username", username);
		
		User user = (User)query.uniqueResult();
		user.getImageList().add(i);
		i.setUser(user);
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Image could not be saved !!');");
		    out.println("location='ImageUtility';");
			out.println("</script>");
			return  ;
		}
		session.close();
		response.getWriter().print("");
		response.sendRedirect("ImageUtility");
		
	}
}