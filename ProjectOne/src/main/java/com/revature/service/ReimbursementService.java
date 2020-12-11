package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService {

	ReimbursementDAO rdao = new ReimbursementDAOImpl();

	// adds reimbursements
	public void addReimbursement(Reimbursement re) throws SQLException {
		rdao.addReimbursement(re);
	}

	// get list of reimbursements by employee id
	public List<Reimbursement> getReimbursementByEmployeeID(int id) throws SQLException {
		return rdao.getReimbursementByEmpID(id);
	}

	// get all reimbursements from all employees
	public List<Reimbursement> getReimbursementByStatus() throws SQLException {
		return rdao.getReimbursementByStatus();
	}
	//update grade
	public void updateReimbursement(int reimid, String grade) throws SQLException {
		rdao.updateReimbursement();
	}

}
