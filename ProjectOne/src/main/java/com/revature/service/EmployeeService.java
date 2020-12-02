package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;

public class EmployeeService {

		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		public boolean loginVerify(String username, String password) throws SQLException{
			List<Employee> eList= edao.getEmployees();
			boolean verify = false;
			for(Employee emp: eList) {
				if(emp.getUsername().equals(username)&& emp.getPassword().equals(password)) {
					verify = true;
				}
			}
			return verify;
			
		}
		
		public Employee loginGetEmployee(String username, String password) throws SQLException{
			
			if(loginVerify(username,password)) {
				return edao.getEmployeeByUsername(username);
			}
			return null;
		}
		
		public void addEmployee(Employee emp) {
			edao.addEmployee(emp);
		}
		public EmployeeService() {
			// TODO Auto-generated constructor stub
		}

	}

