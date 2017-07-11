package com.kriss.hibernate.dto;

/*
 * Learn
 * 1. Lazy Initialization is the default behavior of Hibernate. When we have a list of Object, hibernate do not query them until we call that getter method
 * 2. The opposite of Lazy is Eager initialization
 * 3. How does Lazy Initialization work? - By Using a Proxy Class for every entity, which is a Sub class of the actual class. 
 * 		All the getters in the proxy will call the parent getter classes after fetching the data for second level attributes like list etc
 * 4. If in case the session is closed while doing a lazy fetch on the next level, we get a LazyInitializationException that No session or session closed.
 * 		Fetch type Eager would resolve this problem
 * 5. We can configure specific fetch type for each collection attribute
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS_5")
public class ContactFetch {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", 
			joinColumns=@JoinColumn(name="USER_ID")
		)
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

