package com.revature.servlets;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;
import com.revature.controller.ProfileController;


public class RequestHelper {

	public static String process(HttpServletRequest req) throws SQLException {
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/ProjectOne/login.change":
			System.out.println("in login.change rhelper");
			return LoginController.login(req);
			
		case "/ProjectOne/profile.change":
		System.out.println("in profile.change rhelper");
		return ProfileController.profile(req);
		
		default:
			System.out.println("in default case");
			return "resources/html/unsuccessfullogin.html";
		}
		
	}

}

