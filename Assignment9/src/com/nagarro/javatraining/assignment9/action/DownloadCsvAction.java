package com.nagarro.javatraining.assignment9.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.javatraining.assignment9.Dao.EmployeeDao;
import com.nagarro.javatraining.assignment9.HB.EmployeeDBAcessService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadCsvAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private InputStream fileInputStream;

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	
	@Action(value="download",results={
	         @Result(name="success",type="stream",params = {
	                 "contentType",
	                 "application/octet-stream",
	                 "inputName","fileInputStream",
	                 "bufferSize","1024","contentDisposition",
	                 "filename=employee.csv"}),
	         @Result(name="error", location="/Fail.jsp"),
	         @Result(name="login", type ="redirect" ,location="/index.jsp")
			})
	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(!session.containsKey("user"))
			return LOGIN ;
		
		String destPath = "C:/Users/ronakkalyani/workspace/Assignment9/WebContent/content/employee.csv";
		File file = new File(destPath);
	    if (file.exists()) {
	       file.delete();     
	    }
	    
		EmployeeDao empDB = new EmployeeDBAcessService();
		if(!empDB.createCSVFromDB(destPath))
		{
			return ERROR;
		}
		
		 try {
			fileInputStream = new FileInputStream(new File(destPath));
		} catch (FileNotFoundException e) {
			System.out.println("file not found exception occured during "
					+ "inputstream which means database failed to write file to "+destPath);
			return ERROR;
		}
		return SUCCESS;
			
	}
}
