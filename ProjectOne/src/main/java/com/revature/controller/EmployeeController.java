package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;

import com.revature.service.EmployeeService;

public class EmployeeController {
	static EmployeeService eServ = new EmployeeService();
	static EmployeeDAO edao = new EmployeeDAOImpl();

	//employee session
	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int emp= (int) session.getAttribute("currentemp");
		Employee empObj = eServ.getSessionEmployee(emp);
		System.out.println("in employee controller");
		System.out.println(empObj);
		ObjectMapper om = new ObjectMapper ();
		String empString = om.writeValueAsString(empObj);
		String newString = "{\"employee\":" + empString + "}";
		System.out.println(newString);
		res.getWriter().write(newString);
	}

	//method to update employee information 
	public static String updateEmployee(HttpServletRequest req) throws SQLException {
		if (!req.getMethod().equals("POST")) {
			return "resources/html/updateEmployeeProfile.html";
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String eid = req.getParameter("eid");
		Integer id = Integer.valueOf(eid);
		
		if (username != null) {
			eServ.updateEmployeeUsername(username, id);
		} 
		if (password != null){
			eServ.updateEmployeePassword(password, id);
		
		}
		
		return "updatesuccess.change";

		
		
		}
	


	
}
