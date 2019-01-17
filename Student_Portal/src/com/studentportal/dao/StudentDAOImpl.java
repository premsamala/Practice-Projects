package com.studentportal.dao;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentportal.entity.Course;
import com.studentportal.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO, Serializable {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CourseDAO theCourseDAO;

	// private Course[] courseSelection;

	@Override
	@Transactional
	public List<Student> getStudents() {

		Session session = sessionFactory.getCurrentSession();

		Query<Student> theQuery;
            theQuery = session.createQuery("from Student", Student.class);

		List<Student> students = theQuery.getResultList();

		return students;
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, studentId);
		if (student != null) {
			System.out.println(student.getStudentFirstName());
		}
		return student;
	}

	@Override
	@Transactional
	public boolean addCourses(int studentId, List<Course> courses) {
		Session session = sessionFactory.getCurrentSession();
		Student student = getStudent(studentId);
		student.setCourses(courses);
		session.saveOrUpdate(student);
		return true;
	}

	@Override
	@Transactional
	public int saveStudent(Student theStudent) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.println(theStudent.getCourseSelection().length);
		session.saveOrUpdate(theStudent);
		return theStudent.getStudentId();
	}

	@Override
	@Transactional
	public void deleteStudent(int theStudentId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getStudent(theStudentId));

	}

	@Override
	@Transactional
	public int saveStudent(Student theStudent, List<Course> courses) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.println(theStudent.getCourseSelection().length);
		theStudent.setCourses(courses);
		session.saveOrUpdate(theStudent);
		return theStudent.getStudentId();
	}

	@Override
	@Transactional
	public void addCourse(int studentId, Course theCourse) {
		Session session = sessionFactory.getCurrentSession();
		Student theStudent = getStudent(studentId);
		theStudent.addCourse(theCourse);
		session.saveOrUpdate(theStudent);
	}

	@Override
	@Transactional
	public void deleteCourses(int theStudentId, int[] courseSelection) {
		Session session = sessionFactory.getCurrentSession();
		Student theStudent = getStudent(theStudentId);
		List<Course> courses = theCourseDAO.getCourses(courseSelection);
		theStudent.deleteCourses(courses);
		session.saveOrUpdate(theStudent);

	}

}
