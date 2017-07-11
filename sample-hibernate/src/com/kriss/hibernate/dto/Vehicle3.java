package com.kriss.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE3")
public class Vehicle3 {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicle")
	private Collection<RelationMTM> users = new ArrayList();
	
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
	
	public Collection<RelationMTM> getUsers() {
		return users;
	}
	public void setUsers(Collection<RelationMTM> users) {
		this.users = users;
	}
	
	
}

