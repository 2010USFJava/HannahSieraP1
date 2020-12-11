package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeController {

	static EmployeeDAO edao = new EmployeeDAOImpl();
	
	static EmployeeService eServ = new EmployeeService();
	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Employee emp = (Employee) req.getSession().getAttribute("currentemp");
			res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}
	
	public static void getSessionEmp(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int emp= (int) session.getAttribute("currentemp");
		Employee empObj = eServ.getSessionEmp(emp);
		System.out.println("in employee controller");
		System.out.println(empObj);
		ObjectMapper mapper = new ObjectMapper ();
		String empString = mapper.writeValueAsString(empObj);
		String newString = "{\"employee\":" + empString + "}";
		System.out.println(newString);
		res.getWriter().write(newString);
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
			edao.updateEmployeeUsername(username, id);
		} 
		if (password != null){
			edao.updateEmployeePassword(password, id);
		
		}
		
		return "updatesuccess.change";

		
		
		}
}



