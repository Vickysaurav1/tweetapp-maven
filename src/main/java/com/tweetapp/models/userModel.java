package com.tweetapp.models;

import java.sql.Date;

public class userModel {
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date date) {
		this.dob = (Date) date;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userModel [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", dob=" + dob + ", emailId=" + emailId + "]";
	}
	private int userId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String emailId;
	private String password;
	private int loggedIn;
	public int getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(int loggedIn) {
		this.loggedIn = loggedIn;
	}
}
