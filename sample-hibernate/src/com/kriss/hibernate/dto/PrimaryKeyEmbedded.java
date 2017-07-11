package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Entity Object carry a meaning while Value Objects do not
 * 2. To include a Value Object inside any entity Object, use Embeddable on top the the Value Object 
 * 			Or Use Embedded on top of that value Object variable in entity Object
 * 3. If you want to override the default column names of the value objects, use AttributeOverrides and AttributeOverride
 * 4. Use EmbeddedId instead of Id and Embedded together for Composite Primary Key
 * 5. Composite Id embedded class should implement Serializable interface 
 */

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_3")
public class PrimaryKeyEmbedded {
	
	@EmbeddedId
	private LoginId userId;
	private String userName;
	
	@Embedded
	private Address address;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride (name="street", column=@Column(name="OFC_STREET")),
	@AttributeOverride (name="city", column=@Column(name="OFC_CITY")),
	@AttributeOverride (name="country", column=@Column(name="OFC_COUNTRY")),
	})
	private Address OfcAddress;
	
	public LoginId getUserId() {
		return userId;
	}
	public void setUserId(LoginId userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getOfcAddress() {
		return OfcAddress;
	}
	public void setOfcAddress(Address ofcAddress) {
		OfcAddress = ofcAddress;
	}
	
}
