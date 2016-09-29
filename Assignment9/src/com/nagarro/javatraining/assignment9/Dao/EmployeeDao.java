package com.nagarro.javatraining.assignment9.Dao;

import java.util.List;

import com.nagarro.javatraining.assignment9.modelObjects.Employee;

public interface EmployeeDao {
	
	
//	boolean deleteEmployee(int id);
//	boolean addEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	boolean updateEmployee(Employee employee);
	public boolean loadEmployeeFromCSV(String filePath) ;
	public boolean createCSVFromDB(String filePath) ;
}
