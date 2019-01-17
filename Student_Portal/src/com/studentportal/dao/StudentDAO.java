package com.studentportal.dao;

import java.util.List;

import javax.validation.Valid;

import com.studentportal.entity.Course;
import com.studentportal.entity.Student;

public interface StudentDAO {
	public List<Student> getStudents();

	public Student getStudent(int studentId);

	public boolean addCourses(int studentId, List<Course> courses);

	public int saveStudent(Student theStudent);

	public void deleteStudent(int theStudentId);

	public int saveStudent(@Valid Student theStudent, List<Course> courses);

	public void addCourse(int studentId, Course theCourse);

	public void deleteCourses(int theStudentId, int[] courseSelection);
}
