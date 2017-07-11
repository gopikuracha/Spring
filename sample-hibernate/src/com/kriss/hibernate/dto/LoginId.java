package com.kriss.hibernate.dto;

import java.io.Serializable;


public class LoginId  implements Serializable {
	
	static final long serialVersionUID = 12345678L;

	private int userId;
	private int userTypeId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	
}
