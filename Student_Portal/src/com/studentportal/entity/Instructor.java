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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@Column(name = "instructorid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "instructor_instructorid", initialValue = 1, allocationSize = 3)
	private int instructorId;

	@Column(name = "instructorfirstname")
	@NotBlank(message = "First Name cannot be null")
	private String instructorFirstName;

	@Column(name = "instructorlastname")
	@NotBlank(message = "Last Name cannot be null")
	private String instructorLastName;

	@Column(name = "instructoremailid")
	@NotBlank(message = "Email Address cannot be empty")
	private String instructorEmailId;

	@OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.PERSIST })
	private List<Course> courses;

	public Instructor() {

	}

	public Instructor(@NotBlank(message = "First Name cannot be null") String instructorFirstName,
			@NotBlank(message = "Last Name cannot be null") String instructorLastName,
			@NotBlank(message = "Email Address cannot be empty") String instructorEmailId) {
		this.instructorFirstName = instructorFirstName;
		this.instructorLastName = instructorLastName;
		this.instructorEmailId = instructorEmailId;
	}

	public Instructor(int instructorId, @NotBlank(message = "First Name cannot be null") String instructorFirstName,
			@NotBlank(message = "Last Name cannot be null") String instructorLastName) {
		this.instructorId = instructorId;
		this.instructorFirstName = instructorFirstName;
		this.instructorLastName = instructorLastName;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorFirstName() {
		return instructorFirstName;
	}

	public void setInstructorFirstName(String instructorFirstName) {
		this.instructorFirstName = instructorFirstName;
	}

	public String getInstructorLastName() {
		return instructorLastName;
	}

	public void setInstructorLastName(String instructorLastName) {
		this.instructorLastName = instructorLastName;
	}

	public String getInstructorEmailId() {
		return instructorEmailId;
	}

	public void setInstructorEmailId(String instructorEmailId) {
		this.instructorEmailId = instructorEmailId;
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

}
