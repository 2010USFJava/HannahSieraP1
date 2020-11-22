package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public Employee getEmployeeByID(int ID) throws SQLException;
	public List<Employee> getEmployees() throws SQLException;
	
	public Employee updateEmployeeLastName(String lastnameNew, Employee e, String lastname) throws SQLException;
	public Employee updateEmployeeUsername(String usernameNew, Employee e, String username) throws SQLException;
	public Employee updateEmployeePassword(String passwordNew, Employee e, String password) throws SQLException;
}
