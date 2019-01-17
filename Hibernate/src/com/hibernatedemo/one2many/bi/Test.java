package com.hibernatedemo.one2many.bi;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
											addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).
											addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/prem", "Study");
		Instructor instructor = new Instructor("Sai", "Pokala", instructorDetail);
		instructorDetail.setInstructor(instructor);
		Course course1 = new Course("Learn Spring Framework");
		Course course2 = new Course("Learn Hibernate Framework");
		Course course3 = new Course("Learn Bitcoin");		
		session.beginTransaction();
		//session.getTransaction();
		Serializable id = session.save(instructor);
		System.out.println("\n\n\nInstructor object saved with id:" + id);
		System.out.println("\n\n\nInstructor with id:" + instructor.getId());
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);
		session.save(course1);
		session.save(course2);
		session.save(course3);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
