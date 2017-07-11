package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Use @OneToMany on top of the Vehicle Collection
 * 2. We can also have the User Id in the Vehicle table without having a new table.
 * 3. This class and Vechicle2 class is the combination for this example
 * 4. @NotFound to ignore the exception of the data not present 
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_8")
public class RelationOTM2 {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@OneToMany(mappedBy="user")
	private Collection<Vehicle2> vehicle = new ArrayList<Vehicle2>();
	
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
	
	public Collection<Vehicle2> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle2> vehicle) {
		this.vehicle = vehicle;
	}
	
}

