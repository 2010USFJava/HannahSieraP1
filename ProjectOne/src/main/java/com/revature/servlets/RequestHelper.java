package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.EmployeeController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;
import com.revature.controller.ManagerLoginController;
import com.revature.controller.ProfileController;
import com.revature.controller.ReimbursementController;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws SQLException, IOException {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		//employee login
		case "/ProjectOne/login.change":
			System.out.println("in login.change rhelper");
			return LoginController.login(req);

		//manager login 
		case "/ProjectOne/managerlogin.change":
			System.out.println("in managerlogin.change rhelper");
			return ManagerLoginController.mlogin(req);

		//manager homepage 
		case "/ProjectOne/managerhomepage.change":
			System.out.println("in managerhomepage.change rhelper");
			return ManagerController.managerhome(req);

		//employee homepage 
		case "/ProjectOne/profile.change":
			System.out.println("in profile.change rhelper");
			return ProfileController.profile(req);

		//reimbursement form 
		case "/ProjectOne/reimbursement.change":
			System.out.println("in reimbursement.change rhelper");
			return "resources/html/reimbursement.html";

		//submitting reimbursement form 	
		case "/ProjectOne/successreimbursement.change":
			System.out.println("in success reimbursement.change rhelper");
			ReimbursementController.addReimbursement(req);
			return "resources/html/successreimbursement.html";
		
		//update employee username/password
		case "/ProjectOne/updateEmployeeProfile.change":
			System.out.println("in update employee profile.change rhelper");
			return "resources/html/updateEmployeeProfile.html";
	
		//successfully updating employee credentials 
		case "/ProjectOne/updatesuccess.change":
			System.out.println("in updatesuccess.change rhelper");
			EmployeeController.updateEmployee(req);
			return "/resources/html/updatesuccess.html";
		
			//update reimbursement grade
		case "/ProjectOne/updateGrade.change":
			System.out.println("in update grade rhelper");
			return "resources/html/updateGrade.html";
			
		case "/ProjectOne/updateGradeSuccess.change":
			ReimbursementController.updateReimbursement(req);
		return "/resources/html/updateGradeSuccess.html";
		
			
		//manager can view all reimbursements 
		case "/ProjectOne/viewapprovedreimbursement.change":
			System.out.println("in viewreimbursement.change rhelper");
			return "ViewReimbursementServlet";
		
		case "/ProjectOne/viewpendingreimbursement.change":
			System.out.println("in view pending rhelper");
			return "ViewPending";
		

		default:
			System.out.println("in default case");
			return "resources/html/unsuccessfullogin.html";
		}

	}

}
