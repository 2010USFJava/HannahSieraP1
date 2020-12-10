package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByID(int ID);
	public List<Employee> getEmployees();
	public Employee updateEmployee();
	public void addEmployee(Employee emp);
	public Employee getEmployeeByUsername(String username);
	public void updateEmployeeUsername(String newUsername, int id) throws SQLException;
	public void updateEmployeePassword(String newPassword, int id) throws SQLException;
	
	
}
