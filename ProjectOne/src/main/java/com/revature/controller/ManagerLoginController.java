package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Manager;
import com.revature.service.ManagerService;

public class ManagerLoginController {

static ManagerService mServ = new ManagerService();
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/managerlogin.html";
			
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Manager man = mServ.loginGetManager(username, password);
		if(man==null) {
			return "wrongcreds.change";
			
		} else {
			req.getSession().setAttribute("currentman", man);
			return "profile.change";
		}
	}

}
