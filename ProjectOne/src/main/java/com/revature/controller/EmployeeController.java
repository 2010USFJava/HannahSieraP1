package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;

import com.revature.service.EmployeeService;

public class EmployeeController {
	static EmployeeService eServ = new EmployeeService();
	static EmployeeDAO edao = new EmployeeDAOImpl();

	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		Employee emp = (Employee) req.getSession().getAttribute("currentemp");
		res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}

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
