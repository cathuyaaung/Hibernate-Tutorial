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
		user.setUserName("alexandra");

		Address address = new Address();
		address.setBlock("12-12");
		address.setCity("Singpaore city");
		address.setCountry("Singapore");
		address.setPostalcode("600600");
		address.setState("Singapore State");
		address.setStreet("Downing Street");
		user.getListOfAddresses().add(address);
		
		address = new Address();
		address.setBlock("123-123");
		address.setCity("Yangon city");
		address.setCountry("Myanmar");
		address.setPostalcode("B48787");
		address.setState("SHukhinthar State");
		address.setStreet("Mandalar Street");
		user.getListOfAddresses().add(address);		

		session.save(user);
		
		user = new UserDetails();
		user.setUserName("franz");
		user.setUserDesc("how now brown cow");
		session.save(user);
		
		user = new UserDetails();
		user.setUserName("winston");
		user.setUserDOB(new Date());
		session.save(user);

		user = new UserDetails();
		user.setUserName("xxx");
		session.save(user);		
		
		session.getTransaction().commit();
		session.close();
		
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		
	}

}
