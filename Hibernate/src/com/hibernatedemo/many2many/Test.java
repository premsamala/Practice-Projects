package com.hibernatedemo.many2many;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/abc", "cricket");
		Instructor instructor = new Instructor("Aneesh", "Pokala", "abc@gmail.com");
		instructor.setInstructorDetail(instructorDetail);
		instructorDetail.setInstructor(instructor);
		Student student1 = new Student("Prem", "Samala");
		Student student2 = new Student("Join", "Doe");
		Student student3 = new Student("Joe", "Root");
		Course course1 = new Course("Learn ABCDEFG");
		Course course2 = new Course("Learn today's work");
		Course course3 = new Course("Learn RESTful!");	
		Review review1 = new Review("your course is awesome");
		Review review2 = new Review("I love your course");
		Review review3 = new Review("Please improve your accent");
 		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Serializable id = session.save(instructor);
		System.out.println("\n\n\nInstructor id:" + id + "\n\n\n");
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);
		Serializable id1 = session.save(course1);
		session.save(course2);
		session.save(course3);
		System.out.println("\n\n\nCourse1 id:" + id1 + "\n\n\n");
		course1.addReview(review1);
		session.save(student1);
		session.save(student3);
		session.save(student2);
		course1.addReview(review2);
		course1.addReview(review3);
		course1.addStudent(student1);
		course2.addStudent(student2);
		course2.addStudent(student3);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
