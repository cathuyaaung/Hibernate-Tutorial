package org.thomas.java;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thomas.java.dto.UserDetails;
import org.thomas.java.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = new UserDetails();
		user.setUserName("alexandra");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclename("car");	
		user.setVehicle(vehicle);
		
		session.save(user);
		session.save(vehicle);
		
		session.getTransaction().commit();
		session.close();
		
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		session.close();
		
		
	}

}
