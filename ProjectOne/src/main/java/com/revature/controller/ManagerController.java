package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Manager;

public class ManagerController {

	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Manager man = (Manager) req.getSession().getAttribute("currentman");
			res.getWriter().write(new ObjectMapper().writeValueAsString(man));
	}
//	public static String managerhome(HttpServletRequest req) {
//		return "resources/html/managerhomepage.html";
//	}
}
