package com.studentportal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentportal.entity.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Instructor> getInstructors() {

		Session session = sessionFactory.getCurrentSession();

		Query<Instructor> theQuery = session.createQuery("from Instructor", Instructor.class);

		List<Instructor> instructors = theQuery.getResultList();

		return instructors;
	}

	@Override
	@Transactional
	public Instructor getInstructor(int instructorId) {

		Session session = sessionFactory.getCurrentSession();
		Instructor instructor = session.get(Instructor.class, instructorId);
		return instructor;
	}

	@Override
	@Transactional
	public int save(Instructor theInstructor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theInstructor);
		return theInstructor.getInstructorId();

	}

	@Override
	@Transactional
	public void deleteInstructor(int theInstructorId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getInstructor(theInstructorId));
	}

}
