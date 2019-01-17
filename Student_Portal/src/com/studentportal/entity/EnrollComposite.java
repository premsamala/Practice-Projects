package com.studentportal.entity;

import java.io.Serializable;

public class EnrollComposite implements Serializable {

	private int courseId;

	private int studentId;

	public EnrollComposite() {

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
