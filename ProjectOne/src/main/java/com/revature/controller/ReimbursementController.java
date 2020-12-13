package com.revature.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

public class ReimbursementController {
	
	static ReimbursementService rServ = new ReimbursementService();
	static ReimbursementDAO rdao = new ReimbursementDAOImpl();
	static EmployeeDAO edao = new EmployeeDAOImpl();
	
	public static String addReimbursement(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/reimbursement.html";
			
		}
		
		//int formID = Integer.parseInt(req.getParameter("formID"));
		String empID = req.getParameter("empID");
		Integer intempID = Integer.valueOf(empID);
		String eventDate = req.getParameter("eventDate");
		//Date dateeventDate = Date.valueOf(eventDate);
		String requestDate = req.getParameter("requestDate");
		String location = req.getParameter("location");
		String amount = req.getParameter("amount");
		String description = req.getParameter("description");
		String eventType = req.getParameter("eventType");
		String gradeType = req.getParameter("gradeType");
		Integer intAmount = Integer.valueOf(amount);
		String urgent = req.getParameter("urgent");
		String passingGrade = req.getParameter("passingGrade");
		
		if (eventType.equalsIgnoreCase("University courses")) {
			intAmount = intAmount * (int) (0.80);
			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
					description, eventType, gradeType, "pending", "pending", "pending", "null", passingGrade, urgent);
			rdao.addReimbursement(r);
		}
		if (eventType.equalsIgnoreCase("Seminars")) {
			intAmount = intAmount * (int) (0.60);
			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
					description, eventType, gradeType, "pending", "pending", "pending", "null", passingGrade, urgent);
			rdao.addReimbursement(r);
		}
		if (eventType.equalsIgnoreCase("Certificaton Preparation Classes")) {
			intAmount = intAmount * (int) (0.75);
			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
					description, eventType, gradeType, "pending", "pending", "pending", "null", passingGrade, urgent);
			rdao.addReimbursement(r);
		}
		if (eventType.equalsIgnoreCase("Certification")) {
			intAmount = intAmount * 1;
			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
					description, eventType, gradeType, "pending", "pending", "pending", "null", passingGrade, urgent);
			rdao.addReimbursement(r);
		}
		if (eventType.equalsIgnoreCase("Technical Training")) {
			intAmount = intAmount * (int) (0.90);
			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
					description, eventType, gradeType, "pending", "pending", "pending", "null", passingGrade, urgent);
			rdao.addReimbursement(r);
		}
		if (eventType.equalsIgnoreCase("Other")) {
			intAmount = intAmount * (int) (0.30);
			Reimbursement r = new Reimbursement(1, intempID, eventDate, requestDate, location, intAmount,
					description, eventType, gradeType, "pending", "pending", "pending", "null", passingGrade, urgent);
			rdao.addReimbursement(r);
		}

		return "sucessreimbursement.change";
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
	
	 public static String withdrawEmpBalance(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/reimbursement.html";
				
		 }
		 String empID = req.getParameter("empID");
		 Integer intempID = Integer.valueOf(empID);
		 String amount = req.getParameter("amount");
		 Integer intAmount = Integer.valueOf(amount);
		 
		 edao.withdraw(intAmount, intempID);
		 return "sucessreimbursement.change";
	 }
	 
	 public static String updateReimbursementStatus(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/managerUpdateForm.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String status = req.getParameter("status");
		 rdao.updateReimbursementStatus(status, intreID);
		 
		if(status.equalsIgnoreCase("denied")) {
			 edao.deposit(intreID);
			 return "reupdatesuccess.html";
		 }
		 return "reupdatesuccess.html";
	 }
	 public static String updateReimbursementStatus2(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/deptheadUpdateForm.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String status = req.getParameter("status");
		 rdao.updateReimbursementStatus2(status, intreID);
		 
		if(status.equalsIgnoreCase("denied")) {
			 edao.deposit(intreID);
			 return "reupdatesuccessdepth.html";
		 }
		 return "reupdatesuccessdepth.html";
	 }
	 public static String updateReimbursementStatus3(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/deptheadUpdateForm.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String status = req.getParameter("status");
		 rdao.updateReimbursementStatus3(status, intreID);
		 
		if(status.equalsIgnoreCase("denied")) {
			 edao.deposit(intreID);
			 return "reupdatesuccessbenco.html";
		 }
		 return "reupdatesuccessbenco.html";
	 }
	 public static String updateReimbursementGrade(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/updatereimbursement.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String grade = req.getParameter("grade");
		 if (grade == null) {
			 return "reupdateemp.html";
		 }if(grade != null) {
			 rdao.updateReimbursementGrade(grade, intreID);
		 }
		 return "reupdateemp.html";
		 
	 }
	 public static String updateReimbursementDescription(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/updatereimbursement.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String description = req.getParameter("description");
		 if (description == null) {
			 return "reupdateemp.html";
		 }if(description != null) {
			 rdao.updateReimbursementDescription(description, intreID);
		 }
		 return "reupdateemp.html";
			 
	 }
	 public static String updateReimbursementAmount(HttpServletRequest req) throws SQLException{
		 if(!req.getMethod().equals("POST")) {
				return "resources/html/updatereimbursement.html";
				
		 }
		 String reID = req.getParameter("reID");
		 Integer intreID = Integer.valueOf(reID);
		 String amount = req.getParameter("amount");
		 Integer intAmount = Integer.valueOf(amount);
		 rdao.updateReimbursementAmount(intAmount, intreID);
		 return "reupdatesuccessbenco.html";
			 
	 }

}
