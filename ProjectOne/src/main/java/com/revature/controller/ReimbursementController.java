package com.revature.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

public class ReimbursementController {

	static ReimbursementService rServ = new ReimbursementService();
	static ReimbursementDAO rdao = new ReimbursementDAOImpl();

	public static String addReimbursement(HttpServletRequest req) throws SQLException {
		if (!req.getMethod().equals("POST")) {
			return "resources/html/reimbursement.html";

		}

		// int formID = Integer.parseInt(req.getParameter("formID"));
		String empID = req.getParameter("empID");
		Integer intempID = Integer.valueOf(empID);
		String eventDate = req.getParameter("eventDate");
		// Date dateeventDate = Date.valueOf(eventDate);
		String requestDate = req.getParameter("requestDate");
		String location = req.getParameter("location");
		String amount = req.getParameter("amount");
		String description = req.getParameter("description");
		String eventType = req.getParameter("eventType");
		String gradeType = req.getParameter("gradeType");
		Integer intAmount = Integer.valueOf(amount);
		// String status = Boolean.parseBoolean(req.getParameter("status"));

		Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount, description,
				eventType, gradeType, false);

		rdao.addReimbursement(r);
		return "sucessreimbursement.change";
	}

	 
	public static String getReimbursement(HttpServletRequest req) throws SQLException {
		if (!req.getMethod().equals("POST")) {
			return "resources/html/viewReimbursement.html";
		}
		
		String eid = req.getParameter("eid");
		Integer id = Integer.valueOf(eid);
		List<Reimbursement> rList= new ArrayList<>();
		rServ.getReimbursementByEmployeeID(id);
		String rStringList = rList.toString();
		return rStringList;

	}
	

}
