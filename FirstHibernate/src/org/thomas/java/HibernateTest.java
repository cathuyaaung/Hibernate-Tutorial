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

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehiclename("car1");			
		user.getVehicle().add(vehicle1);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehiclename("car2");				
		user.getVehicle().add(vehicle2);

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehiclename("car3");				
		user.getVehicle().add(vehicle3);
		
//		session.save(user);
		session.persist(user);
//		session.save(vehicle1);
//		session.save(vehicle2);
//		session.save(vehicle3);
		
		session.getTransaction().commit();
		session.close();
		
		

		
		
	}

}
