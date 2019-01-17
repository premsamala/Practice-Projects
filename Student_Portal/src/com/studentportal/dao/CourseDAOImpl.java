package com.studentportal.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentportal.entity.Course;
import com.studentportal.entity.Instructor;
import com.studentportal.entity.Student;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private InstructorDAO theInstructorDAO;

	@Autowired
	private StudentDAO theStudentDAO;

	@Override
	@Transactional
	public List<Course> getCourses() {

		Session session = sessionFactory.getCurrentSession();

		Query<Course> theQuery = session.createQuery("from Course", Course.class);

		List<Course> courses = theQuery.getResultList();

		return courses;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Course> getCourses(int[] courseId) {

		Session session = sessionFactory.getCurrentSession();
		List<Integer> courseIds = Arrays.stream(courseId).boxed().collect(Collectors.toList());
		List<Course> courses = session.createQuery("SELECT temp FROM Course temp WHERE temp.courseId IN :courseIds")
				.setParameter("courseIds", courseIds).getResultList();
		return courses;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Course> getCourses(int studentId) {
		Session session = sessionFactory.getCurrentSession();
		Student theStudent = theStudentDAO.getStudent(studentId);
		if (theStudent.getCourses().size() == 0) {
			return null;
		}
		List<Integer> courseIds = session
				.createQuery("SELECT temp.courseId FROM Enroll temp WHERE temp.studentId =: studentId")
				.setParameter("studentId", studentId).getResultList();
		List<Course> courses = session.createQuery("SELECT temp FROM Course temp WHERE temp.courseId IN :courseIds")
				.setParameter("courseIds", courseIds).getResultList();
		System.out.println(courses.size());
		return courses;
	}
        
        @SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Course> getInstructorCourses(int instructorId) {
		Session session = sessionFactory.getCurrentSession();
		Instructor theInstructor = theInstructorDAO.getInstructor(instructorId);
		if (theInstructor.getCourses().isEmpty()) {
			return null;
		}
		return theInstructor.getCourses();
	}

	@Override
	@Transactional
	public int deleteCourses(int studentId, int[] courseId) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> courseIds = Arrays.stream(courseId).boxed().collect(Collectors.toList());
		int deletedRecords = session
				.createQuery(
						"DELETE FROM Enroll temp WHERE temp.studentId =: studentId AND temp.courseId IN :courseIds")
				.setParameter("studentId", studentId).setParameter("courseIds", courseIds).executeUpdate();
		return deletedRecords;
	}

	@Override
	@Transactional
	public int save(Course theCourse) {
		Session session = sessionFactory.getCurrentSession();

		// int theInstructorId = theCourse.getInstructorId();
		// System.out.println(theInstructor.getInstructorFirstName());
		// session.merge(theCourse);
		// session.merge(theInstructor);
		// theCourse.setInstructor(theInstructor);
		session.saveOrUpdate(theCourse);
		return theCourse.getCourseId();
	}

	@Override
	@Transactional
	public Course getCourse(int theCourseId) {
		Session session = sessionFactory.getCurrentSession();
		Course theCourse = session.get(Course.class, theCourseId);
		return theCourse;
	}

	@Override
	@Transactional
	public void deleteCourse(int theCourseId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getCourse(theCourseId));
	}

}
