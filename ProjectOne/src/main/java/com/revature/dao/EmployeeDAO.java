package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByID(int ID) throws SQLException;
	public List<Employee> getEmployees() throws SQLException;
	public Employee updateEmployee() throws SQLException;
	
	
	
}
