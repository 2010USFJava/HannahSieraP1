package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
				eventType, gradeType, "pending", "pending", "pending", "null");

		rdao.addReimbursement(r);
		return "sucessreimbursement.change";
	}

	 //get reimbursement by employee id in json rhelper
	public static void getReimbursementByStatus(HttpServletRequest req, HttpServletResponse res) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		List<Reimbursement> rList = new ArrayList<>();
		rList = rdao.getReimbursementByStatus();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(out, rList);
		byte [] data = out.toByteArray();
		res.getWriter().write("{\"reim\":" + new String(data) + "}");
		System.out.println(new String(data));
		

	}
	public static String updateReimbursement(HttpServletRequest req) throws SQLException {
		if (!req.getMethod().equals("POST")) {
			return "resources/html/updateGrade.html";
		}
		
		String reimid = req.getParameter("reimid");
		int rid = Integer.valueOf(reimid);
		String grade = req.getParameter("grade");

		rServ.updateReimbursement(rid, grade);
		
		return "updateGradeSuccess.change";

		
		
		}
	

}
