package com.revature.model;

import java.io.Serializable;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1221768556715342873L;
	public String firstName;
	public String lastName;
	public String username;
	public String password;
	public int empID;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", empID=" + empID + "]";
	}
	public Employee(String firstName, String lastName, String username, String password, int empID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.empID = empID;
	}
	

}
