package com.kriss.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="VEHICLE2")
public class Vehicle2 {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	@NotFound(action=NotFoundAction.IGNORE)
	private RelationOTM2 user;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public RelationOTM2 getUser() {
		return user;
	}
	public void setUser(RelationOTM2 user) {
		this.user = user;
	}
	
	
}

