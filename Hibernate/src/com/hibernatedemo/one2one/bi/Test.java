package com.hibernatedemo.one2one.bi;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Instructor.class)
										.buildSessionFactory();
		InstructorDetail instructorDetail= new InstructorDetail("youtube.com/prem", "cricket");
		Instructor instructor = new Instructor("Prem", "Samala", "abc@gmail.com", instructorDetail);
		instructorDetail.setInstructor(instructor);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.persist(instructor);
		session.saveOrUpdate(instructorDetail);
		//System.out.println(id);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
