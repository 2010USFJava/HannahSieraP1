package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class ReimbursementController {

	public static String reimbursement(HttpServletRequest req) {
		return "resources/html/reimbursement.html";
		

	}
	public static String viewreimbursement(HttpServletRequest req) {
		return "resources/html/viewreimbursement.html";
	}
}
