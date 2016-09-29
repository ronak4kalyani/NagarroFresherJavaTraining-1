package com.nagarro.javatraining.assignment9.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.javatraining.assignment9.Dao.EmployeeDao;
import com.nagarro.javatraining.assignment9.HB.EmployeeDBAcessService;
import com.nagarro.javatraining.assignment9.modelObjects.Employee;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateEmpAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Employee emp = new Employee();
	
	public int geteCode() {
		return emp.getEmployeeCode();
	}
	public void seteCode(int ecode) {
		emp.setEmployeeCode(ecode) ;
	}
	public String getName() {
		return emp.getName();
	}
	public void setName(String name) {
		emp.setName(name);
	}
	public String getLocation() {
		return emp.getLocation();
	}
	public void setLocation(String location) {
		emp.setLocation(location);
	}
	public String getEmail() {
		return emp.getEmail();
	}
	public void setEmail(String email) {
		emp.setEmail(email);
	}
	public String getDob() {
		return emp.getDob();
	}
	public void setDob(String dob) {
		emp.setDob(dob);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Action(value="updateemp",results={
			   @Result(name="success",type="redirect", location="emplist")
			})
	public String execute()
	{
		EmployeeDao empDB = new EmployeeDBAcessService();
		empDB.updateEmployee(emp);
			return SUCCESS ;
	}
	
}
