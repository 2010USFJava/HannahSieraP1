package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDAO {

	public Reimbursement getReimbursementByID(int ID) throws SQLException;
	public List<Reimbursement> getReimbursement() throws SQLException;
	public Reimbursement updateReimbursement() throws SQLException;
	public void addReimbursement(Reimbursement form) throws SQLException;
	public Reimbursement getReimbursementByEmpID(String empID) throws SQLException;
}
