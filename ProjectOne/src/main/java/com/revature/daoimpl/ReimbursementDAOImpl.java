package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.model.Reimbursement;
import com.revature.util.ConnFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public Reimbursement getReimbursementByID(int id) throws SQLException {
		Reimbursement form = new Reimbursement();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement WHERE reimbursement_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				form.setEmpID(rs.getInt(1));
				form.setEventDate(rs.getDate(2));
				form.setRequestDate(rs.getDate(3));
				form.setLocation(rs.getString(4));
				form.setAmount(rs.getInt(5));
				form.setDescription(rs.getString(6));
				form.setEventType(rs.getString(7));
				form.setStatus(rs.getBoolean(8));
					
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return form;
	}


	@Override
	public List<Reimbursement> getReimbursement() throws SQLException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rList.add(new Reimbursement());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public Reimbursement updateReimbursement() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReimbursement(Reimbursement form) throws SQLException {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO reimbursement values(DEFAULT,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, form.getEmpID());
			ps.setDate(2, (Date) form.getEventDate());
			ps.setDate(3, (Date) form.getRequestDate());
			ps.setString(4, form.getLocation());
			ps.setInt(5, form.getAmount());
			ps.setString(6, form.getDescription());
			ps.setString(7, form.getEventType());
			ps.setString(8, form.getGradeType());
			ps.setBoolean(9, form.isStatus());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Reimbursement getReimbursementByEmpID(String empID) throws SQLException {
		Reimbursement form = new Reimbursement();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, empID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				form.setFormID(rs.getInt(1));
				form.setEventDate(rs.getDate(2));
				form.setRequestDate(rs.getDate(3));
				form.setLocation(rs.getString(4));
				form.setAmount(rs.getInt(5));
				form.setDescription(rs.getString(6));
				form.setEventType(rs.getString(7));
				form.setGradeType(rs.getString(8));
				form.setStatus(rs.getBoolean(9));
				
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return form;
	}

}
