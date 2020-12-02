package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Manager;
import com.revature.service.ManagerService;

public class ManagerLoginController {

	static ManagerService eServ = new ManagerService();
	public static String login(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "reources/html/managerlogin.html";
			
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Manager man = eServ.loginGetManager(username, password);
		if(man==null) {
			return "wrongcreds.change";
			
		} else {
			req.getSession().setAttribute("currentman", man);
			return "manageprofile.change";
		}
	}

}