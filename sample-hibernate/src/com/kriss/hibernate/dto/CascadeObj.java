package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Use cascade attribute with type as persist to save all the dependent objects.
 * 2. Use All as cascade type to do all cascade types
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_10")
public class CascadeObj {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE_10", joinColumns=@JoinColumn(name="USER_ID"), 
				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
		)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
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
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
}

