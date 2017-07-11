package com.kriss.hibernate.dto;

/*
 * Learn - Extension to User class
 * 1. Annotations can be placed either on variables or on getters. If the ID is placed on variable, all the columns are saved with
 * 		variable values. If the ID is placed on getter, all the columns are saved with getter values.
 * 2. Note: All the Annotations for each field will also work in the same way as above depending on the ID
 * 3. Note: Any framework uses getter and setter values to identify the bean values
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="USER_EXTN")
public class UserExtn {

	private int userId;
	private String userName;
	
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	
	private String Address;
	
	@Lob
	private String description;
	private String star = "";
	
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
		return userName + star;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	
}
