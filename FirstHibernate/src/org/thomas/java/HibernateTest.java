package org.thomas.java;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thomas.java.dto.FourWheeler;
import org.thomas.java.dto.TwoWheeler;
import org.thomas.java.dto.UserDetails;
import org.thomas.java.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehiclename("car1");			

		TwoWheeler bike = new TwoWheeler();
		bike.setVehiclename("Bike");
		bike.setSteeringHandle("Bike Handle Bars");
		
		FourWheeler car = new FourWheeler();
		car.setVehiclename("Porsche");
		car.setSteeringWheel("Power Steering");


		session.save(vehicle1);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		session.close();
		
		

		
		
	}

}
