package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;

public class EmployeeService {

	EmployeeDAO edao = new EmployeeDAOImpl();

	public boolean loginVerify(String username, String password) {
		List<Employee> eList = edao.getEmployees();
		boolean verify = false;
		for (Employee emp : eList) {
			if (emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
				verify = true;
			}
		}
		System.out.println(verify);
		return verify;

	}

	public Employee loginGetEmployee(String username, String password) {

		if (loginVerify(username, password)) {
			return edao.getEmployeeByUsername(username);
		}
		return null;
	}

	public void addEmployee(Employee emp) {
		edao.addEmployee(emp);
	}

	public void updateEmployeeUsername(String newUsername, int id) throws SQLException {
		 edao.updateEmployeeUsername(newUsername, id);
	}

	public void updateEmployeePassword(String newPassword, int id) throws SQLException {
		edao.updateEmployeePassword(newPassword, id);
	}

}
