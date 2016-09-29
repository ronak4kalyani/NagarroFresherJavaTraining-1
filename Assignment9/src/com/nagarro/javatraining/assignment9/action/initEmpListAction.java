package com.nagarro.javatraining.assignment9.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.javatraining.assignment9.Dao.EmployeeDao;
import com.nagarro.javatraining.assignment9.HB.EmployeeDBAcessService;
import com.nagarro.javatraining.assignment9.modelObjects.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class initEmpListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Employee> empList = new ArrayList<Employee>();
	
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	} 
	
	@Action(value="emplist",results={
			   @Result(name="success",location="/EmployeeDetails.jsp"),
			   @Result(name="error", location="/Fail.jsp")
			})  
	public String execute()
	{
		EmployeeDao empDB = new EmployeeDBAcessService();
		this.setEmpList(empDB.getAllEmployees());
		if (empList==null)
		{
			System.out.println("employee list failed to load");
			return ERROR ;
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("empList",empList);
		return SUCCESS ;
			
	}

	
}
