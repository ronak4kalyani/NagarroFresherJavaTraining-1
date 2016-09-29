package com.nagarro.javatraining.assignment9.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.javatraining.assignment9.Dao.EmployeeDao;
import com.nagarro.javatraining.assignment9.HB.EmployeeDBAcessService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Action(value="upload",results={
		   @Result(name="success",type="redirect", location="emplist"),
		   @Result(name="error", location="/Fail.jsp"),
		   @Result(name="input", location="/EmployeeDetails.jsp")
		})
public class UploadCsvAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private File csvFile; 
	private String csvFileFileName;
	private String destPath;

	public String getCsvFileFileName() {
		return csvFileFileName;
	}

	public void setCsvFileFileName(String csvFileFileName) {
		this.csvFileFileName = csvFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	
	@RequiredFieldValidator(message = "No file was Choosen",  shortCircuit = true)
	public File getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}
	
	  
	 public String execute()
	   {
	      boolean res = uploadToServer() && uploadToDB() ;
	      if (res)
	    	  return SUCCESS ;
	      
	      System.out.println("Either the file was not uploaded to server sucessfully \n"
	      		+ "or database was not able to restore from csv");
	    	  return ERROR ;
	   }
		
		private boolean uploadToServer(){
			/* Copy file to a safe location */
		      destPath = "/content/employee.csv";
//		      System.out.println("Dst File name: " + csvFileFileName);
		      try{	 
		     	 File destFile  = new File(destPath);
		    	 FileUtils.copyFile(csvFile, destFile);
		      }catch(IOException e){
		         e.printStackTrace();
		         return false;
		      }

		      return true;
		}
		
		private boolean uploadToDB(){
			EmployeeDao empDB = new EmployeeDBAcessService();
			if(empDB.loadEmployeeFromCSV(destPath))
				return true ;
			else
				return false;
		}
}
