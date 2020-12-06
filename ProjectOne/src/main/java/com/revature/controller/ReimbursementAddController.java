package com.revature.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

public class ReimbursementAddController {
	static ReimbursementService rServ = new ReimbursementService();
			
	public static String reimbursement(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/reimbursement.html";
			
		}
		
		int formID = Integer.parseInt(req.getParameter("formID"));
		int empID = Integer.parseInt(req.getParameter("empID"));
		Date eventDate = (Date) req.getParameter("eventDate");
		Date requestDate = (Date) req.getParameter("requestDate");
		String location = req.getParameter("location");
		int amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");
		String eventType = req.getParameter("eventType");
		String gradeType = req.getParameter("gradeType");
		boolean status = Boolean.parseBoolean(req.getParameter("status"));
		
		Reimbursement r = new Reimbursement(formID, empID, eventDate, requestDate, location, amount,
				description, eventType, gradeType, status);
		Reimbursement re = rServ.addReimbursement(r);

	}
}
