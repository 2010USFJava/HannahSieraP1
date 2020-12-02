package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByID(int ID) throws SQLException;
	public List<Employee> getEmployees() throws SQLException;
	public Employee updateEmployee() throws SQLException;
	public void addEmployee(Employee emp) throws SQLException;
	public Employee getEmployeeByUsername(String username) throws SQLException;
	
	
}
