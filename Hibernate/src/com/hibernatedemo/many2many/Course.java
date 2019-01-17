package com.hibernatedemo.many2many;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="courses")
public class Course implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String courseName;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
												CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
												CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="course_student", 
				joinColumns=@JoinColumn(name="course_id"), 
				inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addStudent(Student theStudent) {
		if(students == null) {
			students=new ArrayList<Student>();
		}
		students.add(theStudent);
	}
	
	public void addReview(Review theReview) {
		if(reviews == null) {
			reviews=new ArrayList<Review>();
		}
		reviews.add(theReview);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", students=" + students + "]";
	}
	
}
