package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Use @ManyToMany on top of the Vehicle collection in User class
 * 2. Use @ManyToMany on top of the User collection in Vehicle class
 * 3. Use @joinTable and @JoinCloumn for naming the table and column
 * 4. Use MappedBy attribute in Vehicle class to avoid duplicate table creation
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_9")
public class RelationMTM {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ManyToMany
	@JoinTable(name="USER_VEHICLE_9", joinColumns=@JoinColumn(name="USER_ID"),
		inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
		)
	private Collection<Vehicle3> vehicle = new ArrayList();
	
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
	
	public Collection<Vehicle3> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle3> vehicle) {
		this.vehicle = vehicle;
	}
	
}

