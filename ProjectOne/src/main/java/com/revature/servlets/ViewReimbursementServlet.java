package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnFactory;

public class ViewReimbursementServlet extends HttpServlet {
	public static ConnFactory cf = ConnFactory.getInstance();
	static {
		try { Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
	}
 
	     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	      {  
	         PrintWriter out = res.getWriter();  
	         res.setContentType("text/html");  
	         out.println("<html><body>");  
	         try 
	         {  
	        
	             Connection conn = cf.getConnection();  
	               
	             Statement stmt = conn.createStatement();  
	             ResultSet rs = stmt.executeQuery("select * from reimbursement");  
	             out.println("<table border=1 width=50% height=50%>");  
	             out.println("<tr><th>Reimbursement ID</th><th>Employee ID</th><th>Event Date</th><th>Request Date</th><th>Location</th><th>Amount</th><th>Description</th><th>Event Type</th><th>Grade Type</th><th>Status</th><tr>");  
	             while (rs.next()) 
	             {  
	                 int a = rs.getInt("reimbursement_id");  
	                 int b = rs.getInt("employee_id");  
	                 String c = rs.getString("event_date");
	                 String d = rs.getString("request_date");
	                 String e = rs.getString("location");
	                 int f = rs.getInt("amount");
	                 String g = rs.getString("description");
	                 String h = rs.getString("event_type");
	                 String i = rs.getString("grade_type");
	                 out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + d + "</td><td>" + e + "</td><td>"+ f +"</td><td>" + g +"</td><td>"+ h +"</td><td>"+ i +"</td></tr>");   
	             }  
	             out.println("</table>");  
	             out.println("<div>");

	             out.println("<a href=\"http://localhost:8080/ProjectOne/resources/html/profile.html\"> Back </a>");
	             out.println("</div>");
	             out.println("</html></body>");
	             
	             conn.close();  
	            }  
	             catch (Exception e) 
	            {  
	             out.println("error");  
	         }  
	     }  
	 } 
