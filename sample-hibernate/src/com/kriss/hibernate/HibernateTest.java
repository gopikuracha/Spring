package com.kriss.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kriss.hibernate.dto.Address;
import com.kriss.hibernate.dto.CascadeObj;
import com.kriss.hibernate.dto.Contact;
import com.kriss.hibernate.dto.LoginId;
import com.kriss.hibernate.dto.PrimaryKey;
import com.kriss.hibernate.dto.PrimaryKeyEmbedded;
import com.kriss.hibernate.dto.RelationMTM;
import com.kriss.hibernate.dto.RelationOTM;
import com.kriss.hibernate.dto.RelationOTM2;
import com.kriss.hibernate.dto.RelationOTO;
import com.kriss.hibernate.dto.Vehicle;
import com.kriss.hibernate.dto.Vehicle2;
import com.kriss.hibernate.dto.Vehicle3;

public class HibernateTest {
	
	public static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		//Create Session
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Save Objects
		//savePrimaryKey(session);
		//savePrimaryKeyEmbedded(session);
		//saveContact(session);
		//saveOneToOne(session);
		//saveOneToMany(session);
		//saveOneToMany2(session);
		//saveManyToMany(session);
		//saveCascade(session);
		
		//Close Session
		session.getTransaction().commit();
		session.close();
		
		//getObject();
		
	}
	
	public static void getObject() {
		Contact cont = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		cont = (Contact) session.get(Contact.class, 1);
		System.out.println("User Name : " + cont.getUserName());
		System.out.println("Address : " + cont.getListOfAddresses());
		for(Address adr : cont.getListOfAddresses()) {
			System.out.println("Adr val " + adr.getStreet());
		}
		session.close();
	}
	
	public static void savePrimaryKey(Session session) {
		PrimaryKey user = new PrimaryKey();
		user.setUserName("First User");
		
		PrimaryKey user2 = new PrimaryKey();
		user2.setUserName("Second User");
		
		session.save(user);
		session.save(user2);
	}
	
	public static void savePrimaryKeyEmbedded(Session session) {
		PrimaryKeyEmbedded embUser = new PrimaryKeyEmbedded();
		
		LoginId loginId = new LoginId();
		loginId.setUserId(1);
		loginId.setUserTypeId(2);
		
		Address address = new Address();
		address.setCity("Bangalore");
		address.setStreet("Indiranagar");
		address.setCountry("India");
		
		Address ofcAddress = new Address();
		ofcAddress.setCity("Bangalore");
		ofcAddress.setStreet("Marathalli");
		ofcAddress.setCountry("India");
		
		embUser.setUserId(loginId);
		embUser.setUserName("Gopi Krishna");
		embUser.setAddress(address);
		embUser.setOfcAddress(ofcAddress);
		
		
		PrimaryKeyEmbedded embUser2 = new PrimaryKeyEmbedded();
		
		LoginId loginId2 = new LoginId();
		loginId2.setUserId(1);
		loginId2.setUserTypeId(3);
		
		embUser2.setUserId(loginId2);
		embUser2.setUserName("Gopi Kuracha");
		embUser2.setAddress(address);
		embUser2.setOfcAddress(ofcAddress);
		
		session.save(embUser);
		session.save(embUser2);
	}
	
	public static void saveContact(Session session) {
		Contact contact = new Contact();
		contact.setUserName("Gopi");
		
		Address address1 = new Address();
		address1.setCity("Bangalore");
		address1.setStreet("Indiranagar");
		address1.setCountry("India");
		
		Address address2 = new Address();
		address2.setCity("Bangalore");
		address2.setStreet("Marathalli");
		address2.setCountry("India");
		
		contact.getListOfAddresses().add(address1);
		contact.getListOfAddresses().add(address2);
		
		session.save(contact);
		
	}
	
	public static void saveOneToOne(Session session) {
		RelationOTO oto = new RelationOTO();
		oto.setUserName("Kriss");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("Beat");
		
		oto.setVehicle(car);
		
		session.save(oto);
		session.save(car);
	}
	
	public static void saveOneToMany(Session session) {
		RelationOTM otm = new RelationOTM();
		otm.setUserName("Kriss");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("Beat");
		
		Vehicle bike = new Vehicle();
		bike.setVehicleName("Apache");
		
		otm.getVehicle().add(car);
		otm.getVehicle().add(bike);
		
		session.save(otm);
		session.save(car);
		session.save(bike);
	}
	
	public static void saveOneToMany2(Session session) {
		RelationOTM2 otm = new RelationOTM2();
		otm.setUserName("Kriss");
		
		Vehicle2 car = new Vehicle2();
		car.setVehicleName("Beat");
		
		Vehicle2 bike = new Vehicle2();
		bike.setVehicleName("Apache");
		
		otm.getVehicle().add(car);
		otm.getVehicle().add(bike);
		
		car.setUser(otm);
		bike.setUser(otm);
		
		session.save(otm);
		session.save(car);
		session.save(bike);
	}
	
	public static void saveManyToMany(Session session) {
		RelationMTM user1 = new RelationMTM();
		user1.setUserName("Krishna");
		
		RelationMTM user2 = new RelationMTM();
		user2.setUserName("Gopi");
		
		Vehicle3 car = new Vehicle3();
		car.setVehicleName("Beat");
		
		Vehicle3 bike = new Vehicle3();
		bike.setVehicleName("Apache");
		
		user1.getVehicle().add(car);
		user1.getVehicle().add(bike);
		
		user2.getVehicle().add(car);
		user2.getVehicle().add(bike);
		
		/*car.getUsers().add(user1);
		car.getUsers().add(user2);
		
		bike.getUsers().add(user1);
		bike.getUsers().add(user2);*/
		
		session.save(user1);
		session.save(user2);
		session.save(car);
		session.save(bike);
	}
	
	public static void saveCascade(Session session) {
		CascadeObj obj = new CascadeObj();
		obj.setUserName("Kriss");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("Beat");
		
		Vehicle bike = new Vehicle();
		bike.setVehicleName("Apache");
		
		obj.getVehicle().add(car);
		obj.getVehicle().add(bike);
		
		session.persist(obj);
	}
}
