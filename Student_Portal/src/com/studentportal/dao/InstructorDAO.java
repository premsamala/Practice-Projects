package com.studentportal.dao;

import java.util.List;

import com.studentportal.entity.Instructor;

public interface InstructorDAO {
	public List<Instructor> getInstructors();

	public Instructor getInstructor(int instructorId);

	public int save(Instructor theInstructor);

	void deleteInstructor(int theInstructorId);
}
