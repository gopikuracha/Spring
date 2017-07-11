package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. There are two types of Primary keys - Natural and Surrogate key. Natural keys are Unique values that are used in the application
 * 		while Surrogate keys are the one that are unique but doesn't matter what value they are
 * 2. Here ID is a Surrogate value which can be handled by Hibernate using @GenerateValue. 
 * 3. @GenerateValue has a strategy which is by default AUTO. It can be a database sequence also.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_2")
public class PrimaryKey {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
