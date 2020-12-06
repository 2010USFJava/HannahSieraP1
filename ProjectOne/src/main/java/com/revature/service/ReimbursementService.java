package com.revature.service;

import com.revature.model.Reimbursement;

import java.sql.SQLException;

import com.revature.dao.*;
import com.revature.daoimpl.*;

public class ReimbursementService {
	
	ReimbursementDAO rdao = new ReimbursementDAOImpl();
	
	public void addReimbursement(Reimbursement re) throws SQLException {
		rdao.addReimbursement(re);
	}

}
