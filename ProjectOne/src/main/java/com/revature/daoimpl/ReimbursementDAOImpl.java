package com.revature.daoimpl;

import java.sql.Connection;
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
				form.setEventDate(rs.getString(2));
				form.setRequestDate(rs.getString(3));
				form.setLocation(rs.getString(4));
				form.setAmount(rs.getInt(5));
				form.setDescription(rs.getString(6));
				form.setEventType(rs.getString(7));
				form.setStatus(rs.getString(8));
					
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
			ps.setString(2, form.getEventDate());
			ps.setString(3, form.getRequestDate());
			ps.setString(4, form.getLocation());
			ps.setInt(5, form.getAmount());
			ps.setString(6, form.getDescription());
			ps.setString(7, form.getEventType());
			ps.setString(8, form.getGradeType());
			ps.setString(9, form.getStatus());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByEmpID(int empID) throws SQLException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}
	public List<Reimbursement> getReimbursementByStatus() throws SQLException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursement WHERE status=pending";
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
	public void updateReimbursementGrade(int reimid, String grade) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "update reimbursement set grade_value =? where reimbursement_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reimid);
		ps.setString(2, grade);
		ps.executeUpdate();

	
	}


}
