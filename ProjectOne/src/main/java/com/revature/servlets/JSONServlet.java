package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSONServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8170353066782994112L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("in doGet");
		try {
			JSONRequestHelper.process(req, res);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("in doPost");
		try {
			JSONRequestHelper.process(req, res);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

