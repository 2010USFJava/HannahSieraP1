package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public Employee getEmployeeByID(int id) throws SQLException {
		Employee emp = new Employee();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM Employee WHERE emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setEmpID(rs.getInt(5));
				
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		List<Employee> eList = new ArrayList<Employee>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM Employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				eList.add(new Employee());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eList;
	}

	@Override
	public Employee updateEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void addEmployee(Employee emp) {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO Employee values(?,?,?,?,DEFAULT)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getUsername());
			ps.setString(4, emp.getPassword());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployeeByUsername(String username) throws SQLException{
		Employee emp = new Employee();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM Employee WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setUsername(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setEmpID(rs.getInt(5));
				
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

}
