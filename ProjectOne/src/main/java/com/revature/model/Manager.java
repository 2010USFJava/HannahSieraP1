package com.revature.model;

import java.io.Serializable;

public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7307584586844010601L;
	public String firstName;
	public String lastName;
	public String username;
	public String password;
	public int manID;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String firstName, String lastName, String username, String password, int manID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.manID = manID;
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
	public int getManID() {
		return manID;
	}
	public void setManID(int manID) {
		this.manID = manID;
	}
	@Override
	public String toString() {
		return "Manager [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", manID=" + manID + "]";
	}
	
	
}
