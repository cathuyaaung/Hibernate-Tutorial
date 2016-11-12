package org.thomas.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.thomas.java.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
//		user.setUserId(1);
//		user.setUserName("alexandra");
//		user.setUserAdd1("Rome");
//		user.setUserAdd2("Roman Empire");

//		user.setUserId(2);
//		user.setUserName("franz");
//		user.setUserAdd1("Austria");
//		user.setUserAdd2("Austra-Hungry Empire");

		user.setUserId(3);
		user.setUserName("winston");
		user.setUserAdd1("London");
		user.setUserAdd2("England, United Kingdom");		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}
