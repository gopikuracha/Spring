package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Transient annotation or static keyword in front of any variable will not persist 
 * 		the field in database - userName and address
 * 2. Date datatype, Hibernate by default will save the Date as Timestamp in Database. Use TemporalType as Date or Time for specific use
 * 3. LOB annotation - CLOB(Character LOB) or BLOB(Byte LOB) - LOB(Large Object). For String datatype, Hibernate will save the object as CLOB
 */

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	
	@Transient
	private String userName;
	
	@Temporal (TemporalType.TIME)
	private Date joinedDate;
	
	private static String Address;
	
	@Lob
	private String description;
	
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
	
}
