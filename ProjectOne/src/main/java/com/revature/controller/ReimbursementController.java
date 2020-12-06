package com.revature.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

public class ReimbursementController {
	
	static ReimbursementService rServ = new ReimbursementService();
	static ReimbursementDAO rdao = new ReimbursementDAOImpl();
	
	public static String reimbursement(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/reimbursement.html";
			
		}
		
		int formID = Integer.parseInt(req.getParameter("formID"));
		int empID = Integer.parseInt(req.getParameter("empID"));
		String eventDate = req.getParameter("eventDate");
		String requestDate = req.getParameter("requestDate");
		String location = req.getParameter("location");
		int amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");
		String eventType = req.getParameter("eventType");
		String gradeType = req.getParameter("gradeType");
		boolean status = Boolean.parseBoolean(req.getParameter("status"));
		
		Reimbursement r = new Reimbursement(formID, empID, eventDate, requestDate, location, amount,
				description, eventType, gradeType, status);
		rdao.addReimbursement(r);
		return "resourses/html/successreimbursement.html";

	}
	

	 public static String getReimbursement(HttpServletRequest req) throws SQLException {
		// if(!req.getMethod().equals("POST")) {
		//		return "resources/html/viewreimbursement.html";
				
		//	}
		 //Reimbursement reim = (Reimbursement) req.getSession().getAttribute("currentreim");
		// res.getWriter().write(new ObjectMapper().writeValueAsString(reim));
		 List<Reimbursement> rList;
		 rList = rdao.getReimbursement();
		 String rStringList = rList.toString();
		 return rStringList;
		  
	}
	
	
	

}
