package com.hibernatedemo.one2many.bi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="instructor")
public class Instructor implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn 
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy="instructor", cascade={CascadeType.PERSIST, CascadeType.DETACH,
											   CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Course> course;

	public Instructor() {
	}

	public Instructor(String firstName, String lastName, InstructorDetail instructorDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public void addCourse(Course thecourse) {
		if(course==null) {
			course= new ArrayList<Course>();
		}
		thecourse.setInstructor(this);
		course.add(thecourse);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", instructorDetail="
				+ instructorDetail + ", course=" + course + "]";
	}
	
	
}
