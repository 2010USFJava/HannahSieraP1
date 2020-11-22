package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.util.*;

import com.revature.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public Employee getEmployeeByID(int ID) throws SQLException {
		Connection conn =cf.getConnection();
		String sql= "select * from customers where eid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,  ID);
		ResultSet rs= ps.executeQuery();
		Employee e= null;
		while(rs.next()) {
			e= new Employee(rs.getString(1),rs.getString(3),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		return e;
	}
	}

	public List<Employee> getEmployees() throws SQLException {
		List<Employee> employeeList= new ArrayList<Employee>();
		Connection conn= cf.getConnection();
		java.sql.Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from employees;");
		Employee e= null;
		while(rs.next()) {
			e= new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			employeeList.add(c);
		}
		return employeeList;
	}

	public Employee updateEmployeeFirstName(String firstnameNew, Employee e, String firstname) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "update customers set firstname =? where firstname=?;"; //or maybe by id?
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstnameNew);
		ps.setString(2, firstname);
		ps.executeUpdate();
		e.setFirstName(firstnameNew);
		LogThis.LogIt("info", " A customer has an updated password: " + e.getFirstName());
		return e;
	}

	@Override
	public Employee updateEmployeeLastName(String lastnameNew, Employee e, String lastname) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "update customers set lastname =? where lastname=?;";//or maybe by id?
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, lastnameNew);
		ps.setString(2, lastname);
		ps.executeUpdate();
		e.setLastName(lastnameNew);
		LogThis.LogIt("info", " A customer has an updated password: " + e.getLastName());
		return e;
	}

	@Override
	public Employee updateEmployeeUsername(String usernameNew, Employee e, String username) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "update customers set username =? where username=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, usernameNew);
		ps.setString(2, username);
		ps.executeUpdate();
		e.setFirstName(usernameNew);
		LogThis.LogIt("info", " A customer has an updated password: " + e.getUsername());
		return e;
	}

	@Override
	public Employee updateEmployeePassword(String passwordNew, Employee e, String password) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "update customers set password =? where password=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, passwordNew);
		ps.setString(2, password);
		ps.executeUpdate();
		e.setFirstName(passwordNew);
		LogThis.LogIt("info", " A customer has an updated password: " + e.getPassword());
		return e;
	}

}
