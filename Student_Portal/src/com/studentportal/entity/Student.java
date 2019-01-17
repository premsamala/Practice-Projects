package com.studentportal.entity;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "student")
@DynamicUpdate
public class Student implements Serializable {

	@Id
	@Column(name = "studentid", updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "student_studentid", initialValue = 1, allocationSize = 3)
	private int studentId;

	@Column(name = "studentfirstname")
	@NotBlank(message = "First Name cannot be empty")
	private String studentFirstName;

	@Column(name = "studentlastname")
	@NotBlank(message = "Last Name cannot be empty")
	private String studentLastName;

	@Column(name = "studentemailid")
	@NotBlank(message = "Email Address cannot be empty")
	private String studentEmailId;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	@JoinTable(name = "enroll", joinColumns = @JoinColumn(name = "studentid"), inverseJoinColumns = @JoinColumn(name = "courseid"))
	private List<Course> courses;

	@Transient
	private int[] courseSelection;

	public Student() {

	}

	public Student(int studentId, @NotBlank(message = "First Name cannot be empty") String studentFirstName,
			@NotBlank(message = "Last Name cannot be empty") String studentLastName,
			@NotBlank(message = "Email Address cannot be empty") String studentEmailId, List<Course> courses,
			@NotBlank @NotNull @NotEmpty int[] courseSelection) {
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentEmailId = studentEmailId;
		this.courses = courses;
		this.courseSelection = courseSelection;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course theCourse) {
		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add(theCourse);
	}

	public void add(Course theCourse) {
		courses.add(theCourse);
	}

	public int[] getCourseSelection() {
		return courseSelection;
	}

	public void setCourseSelection(int[] courseSelection) {
		this.courseSelection = courseSelection;
	}

	public void deleteCourses(List<Course> coursesSelected) {

		courses.removeAll(coursesSelected);

	}

}
