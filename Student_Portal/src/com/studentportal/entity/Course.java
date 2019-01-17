package com.studentportal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "courseid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "course_courseid", initialValue = 1, allocationSize = 3)
	private int courseId;

	@Column(name = "coursename")
	@NotBlank(message = "Course Name cannot be empty")
	private String courseName;

	@Column(name = "credits")
	@Min(value = 1, message = "The range of credits should be 1-3")
	@Max(value = 3, message = "The range of credits should be 1-3")
	@NotNull(message = "Credits field cannot be empty")
	private int credits;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.PERSIST }, mappedBy = "courses")
	private List<Student> students;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.PERSIST })
	@JoinColumn(name = "instructorid")
	private Instructor instructor;

	@Transient
	private int instructorId;

	public Course() {

	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public void addStudent(Student theStudent) {
		if (students == null) {
			students = new ArrayList<Student>();
		}
		students.add(theStudent);
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

}
