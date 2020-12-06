package com.revature.servlets;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;
import com.revature.controller.ManagerLoginController;
import com.revature.controller.ProfileController;
import com.revature.controller.ReimbursementController;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws SQLException {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ProjectOne/login.change":
			System.out.println("in login.change rhelper");
			return LoginController.login(req);

		case "/ProjectOne/managerlogin.change":
			System.out.println("in managerlogin.change rhelper");
			return ManagerLoginController.login(req);

		case "/ProjectOne/managerhomepage.change":
			System.out.println("in managerhomepage.change rhelper");
			return ManagerController.managerhome(req);

		case "/ProjectOne/profile.change":
			System.out.println("in profile.change rhelper");
			return ProfileController.profile(req);

		case "/ProjectOne/reimbursement.change":
			System.out.println("in reimbursement.change rhelper");
			return ReimbursementController.reimbursement(req);

		case "/ProjectOne/viewreimbursement.change":
			System.out.println("in reimbursement.change rhelper");
			return "ViewReimbursementServlet";

		default:
			System.out.println("in default case");
			return "resources/html/unsuccessfullogin.html";
		}

	}

}
