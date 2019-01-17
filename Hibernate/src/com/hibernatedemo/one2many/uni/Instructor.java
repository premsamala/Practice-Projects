package com.hibernatedemo.one2many.uni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name="instructor")
public class Instructor implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(mappedBy="instructor", cascade=CascadeType.ALL)
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy="instructor", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
												CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> course;

	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String email, InstructorDetail instructorDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetail = instructorDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public void addCourse(Course thecourse) {
		if(course == null) {
			course = new ArrayList<Course>();
		}
		thecourse.setInstructor(this);
		course.add(thecourse);
	}
	
	
}
