package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.EmployeeController;
import com.revature.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONRequestHelper {


	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		switch(req.getRequestURI()) {
		case "/ProjectOne/getsession.json":
			EmployeeController.getSessionEmployee(req, res);
			break;
			default:
				Employee emp = new Employee("?","?","?","?",0);
					res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
		}
	}
}

