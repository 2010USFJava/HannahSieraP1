package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByID(int ID);
	public List<Employee> getEmployees();
	public Employee updateEmployee();
	public void addEmployee(Employee emp);
	public Employee getEmployeeByUsername(String username);
	
	
}
