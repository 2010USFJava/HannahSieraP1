package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.EmployeeController;
import com.revature.controller.ReimbursementController;
import com.revature.model.Employee;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException, SQLException {
		switch (req.getRequestURI()) {

		case "/ProjectOne/getsession.json":
			EmployeeController.getSessionEmployee(req, res);
			break;

		case "/ProjectOne/reimbursement.json":
			System.out.println("in reimbursement.json helper");
			ReimbursementController.getReimbursement(req);
			break;

		default:
			Employee emp = new Employee("?", "?", "?", "?", 0);
			res.getWriter().write(new ObjectMapper().writeValueAsString(emp));

		}

	}
}
