package com.studentportal.dao;

import java.util.List;

import com.studentportal.entity.Course;

public interface CourseDAO {
	public List<Course> getCourses();

	public List<Course> getCourses(int[] courseId);

	public List<Course> getCourses(int studentId);
        
        public List<Course> getInstructorCourses(int instructorId);

	public int deleteCourses(int studentId, int[] courseId);

	public int save(Course theCourse);

	public Course getCourse(int theCourseId);

	public void deleteCourse(int thecourseId);
}
