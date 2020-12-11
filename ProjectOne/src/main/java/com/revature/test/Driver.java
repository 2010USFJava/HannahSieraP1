package com.revature.test;

import java.sql.SQLException;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementDAOImpl;

public class Driver {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO edao = new EmployeeDAOImpl();
		//ReimbursementDAO rdao = new ReimbursementDAOImpl();
		System.out.println(edao.getEmployeeByID(1));
		//edao.withdraw(4);
	}
}
