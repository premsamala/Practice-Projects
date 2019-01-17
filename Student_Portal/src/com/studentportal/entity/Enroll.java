package com.studentportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "enroll")
@IdClass(EnrollComposite.class)
public class Enroll {

	@Id
	@Column(name = "courseid")
	private int courseId;

	@Id
	@Column(name = "studentid")
	private int studentId;

	public Enroll() {

	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
