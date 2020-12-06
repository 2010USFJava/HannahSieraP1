package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Manager;
import com.revature.model.Reimbursement;

public class ReimbursementController {
		
		public static void getSessionReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
			Reimbursement re = (Reimbursement) req.getSession().getAttribute("currentre");
				res.getWriter().write(new ObjectMapper().writeValueAsString(re));
		}
}
