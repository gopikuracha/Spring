package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Use @OneToMany on top of the Vehicle Collection
 * 2. A new table will be created for this relation between User and Vehicle by using @JoinTable and @JoinColumn
 * 3. Add User object in Vehicle class to access the User object from Vehicle Object if the table structure is bi directional
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_7")
public class RelationOTM {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@OneToMany
	@JoinTable(name="USER_VEHICLE_7", joinColumns=@JoinColumn(name="USER_ID"), 
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

