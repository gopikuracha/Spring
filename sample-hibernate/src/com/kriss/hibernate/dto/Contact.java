package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Use @ElementCollection when you have a list of Objects which is not static, to create a new Table for that list
 * 2. Use @joinTable and @JoinCloumn to name the new Table and the corresponding foreign Key
 * 3. Use the interface Collection instead of the actual type for the list.
 * 4. Use ArrayList for Primary Key of the new table as the collection should be of the type indexed
 * 5. Use @CollectionId to name and give Primary Key to the new Table. @CollectionId is not JPA standard, its specified by Hibernate
 * 6. Use a generic generator of strategy 'hilo', which is provided by Hibernate.
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name="USER_DETAILS_4")
public class Contact {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS", 
			joinColumns=@JoinColumn(name="USER_ID")
		)
	@GenericGenerator(name="hilo-gen", strategy ="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList();
	
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
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}

