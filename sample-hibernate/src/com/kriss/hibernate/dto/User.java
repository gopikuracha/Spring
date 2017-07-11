package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Annotations can be placed either on variables or on getters. If the ID is placed on variable, all the columns are saved with
 * 		variable values. If the ID is placed on getter, all the columns are saved with getter values.
 * 2. Note: All the Annotations for each field will also work in the same way as above depending on the ID
 * 3. Note: Any framework uses getter and setter values to identify the bean values
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAILS_1")
public class User {
	
	private int userId;
	private String userName;
	
	@Id
	@Column (name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name="USER_NAME")
	public String getUserName() {
		return userName + " from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
