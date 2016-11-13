package org.thomas.java;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thomas.java.dto.Address;
import org.thomas.java.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = new UserDetails();
//		user.setUserId(1);
		user.setUserName("alexandra");
		user.setUserAdd1("Rome");
		user.setUserAdd2("Roman Empire");
		Address address = new Address();
		address.setBlock("12-12");
		address.setCity("Singpaore city");
		address.setCountry("Singapore");
		address.setPostalcode("600600");
		address.setState("Singapore State");
		address.setStreet("Downing Street");
		user.setHomeAddress(address);
		session.save(user);
		
		user = new UserDetails();
//		user.setUserId(2);
		user.setUserName("franz");
		user.setUserAdd1("Austria");
		user.setUserAdd2("Austra-Hungry Empire");
		address = new Address();
		address.setBlock("123-123");
		address.setCity("Yangon city");
		address.setCountry("Myanmar");
		address.setPostalcode("B48787");
		address.setState("SHukhinthar State");
		address.setStreet("Mandalar Street");
		user.setOfficeAddress(address);		
		session.save(user);
		
		user = new UserDetails();
//		user.setUserId(3);
		user.setUserName("winston");
		user.setUserAdd1("London");
		user.setUserAdd2("England, United Kingdom");		
		user.setUserDOB(new Date());
		session.save(user);

//		user = new UserDetails();
//		user.setUserName("xxx");
//		user.setUserAdd1("Triple X");
//		user.setUserAdd2("Hollywood");
//		session.save(user);		
		
		session.getTransaction().commit();
		session.close();
		
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		System.out.printf("%s %s %s %s %s\n", user.getUserId()
				, user.getUserName()
				, user.getUserAdd1()
				, user.getUserAdd2()
				, user.getUserCountry());
		user = session.get(UserDetails.class, 2);
		System.out.printf("%s %s %s %s %s\n", user.getUserId()
				, user.getUserName()
				, user.getUserAdd1()
				, user.getUserAdd2()
				, user.getUserCountry());
		user = session.get(UserDetails.class, 3);
		System.out.printf("%s %s %s %s %s\n", user.getUserId()
				, user.getUserName()
				, user.getUserAdd1()
				, user.getUserAdd2()
				, user.getUserCountry());		
		
	}

}
