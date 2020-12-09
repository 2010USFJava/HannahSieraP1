package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByID(int ID);
	public List<Employee> getEmployees();
	public Employee updateEmployeeUsername(String newUsername, int id, Employee e) throws SQLException;
	public Employee updateEmployeePassword(String newPassword, int id, Employee e) throws SQLException;
	public void addEmployee(Employee emp);
	public Employee getEmployeeByUsername(String username);
	
	
}
