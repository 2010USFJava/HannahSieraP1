package com.revature.model;



public class Reimbursement {

	public int formID;
	public int empID;
	public String eventDate;
	public String requestDate;
	public String location;
	public int amount;
	public String description;
	public String eventType;
	public String gradeType;
	public boolean status;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int formID, int empID, String eventDate, String requestDate, String location, int amount,
			String description, String eventType, String gradeType, boolean status) {
		super();
		this.formID = formID;
		this.empID = empID;
		this.eventDate = eventDate;
		this.requestDate = requestDate;
		this.location = location;
		this.amount = amount;
		this.description = description;
		this.eventType = eventType;
		this.gradeType = gradeType;
		this.status = status;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [formID=" + formID + ", empID=" + empID + ", eventDate=" + eventDate + ", requestDate="
				+ requestDate + ", location=" + location + ", amount=" + amount + ", description=" + description
				+ ", eventType=" + eventType + ", gradeType=" + gradeType + ", status=" + status + "]";
	}
	
	
}
