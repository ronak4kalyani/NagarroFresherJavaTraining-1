package com.nagarro.javatraining.assignment9.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.javatraining.assignment9.Dao.HrDao;
import com.nagarro.javatraining.assignment9.HB.HrDBAcessService;
import com.nagarro.javatraining.assignment9.modelObjects.Hr;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;


public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Hr hrEmp = new Hr() ;
	String rePass ;
	
	@RequiredStringValidator(message = "userid is mandatory",  shortCircuit = true)
	public String getUserId() {
		return hrEmp.getUserId();
	}
	public void setUserId(String userId) {
		hrEmp.setUserId(userId);
	}
	
	@RequiredStringValidator(message = "password is mandatory",  shortCircuit = true)
	public String getPass() {
		return hrEmp.getPass();
	}
	
	public void setPass(String pass) {
		hrEmp.setPass(pass);
	}
	
	@RequiredStringValidator(message = "re-password is mandatory",  shortCircuit = true)
	public String getRePass() {
		return rePass ;
	}
	
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}
	@Action(value="register",results={
			   @Result(name="success", location="/index.jsp"),
			   @Result(name="input", location="/register.jsp")
			})  
	public String execute(){
		
		HrDao HrDBAcesssServiceObject = new HrDBAcessService() ;
		if (HrDBAcesssServiceObject.addHrUser(hrEmp))
		return SUCCESS;
		else
		{
			addFieldError("userId", "username should be Unique !!");
			return INPUT ;
		}
	}
	
	@Override
	public void validate(){
		
		if((rePass!=null)&&(!rePass.equals(getPass())))
			addFieldError("rePass","Password must be same"); 
	}
	
}
