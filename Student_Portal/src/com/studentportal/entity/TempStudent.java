package com.studentportal.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class TempStudent {

	@NotNull
	private int id;

	@NotNull
	@NotEmpty
	private int[] courseSelection;

	public TempStudent() {
	}

	public TempStudent(@NotNull int id, @NotNull @NotEmpty int[] courseSelection) {
		this.id = id;
		this.courseSelection = courseSelection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getCourseSelection() {
		return courseSelection;
	}

	public void setCourseSelection(int[] courseSelection) {
		this.courseSelection = courseSelection;
	}

}
