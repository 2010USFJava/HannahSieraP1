package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeController {

	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Employee emp = (Employee) req.getSession().getAttribute("currentemp");
			res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}
}



