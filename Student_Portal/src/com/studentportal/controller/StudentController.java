package com.studentportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentportal.dao.StudentDAO;
import com.studentportal.entity.Course;
import com.studentportal.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDAO theStudentDAO;

	List<Course> courses;

	@InitBinder
	public void stringTrimmer(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/")
	public String welcomePage() {
		return "redirect:menu";
	}

	@RequestMapping("/register")
	public String registerStudent(Model theModel) {
		theModel.addAttribute("student", new Student());
		return "register-student";
	}

	@RequestMapping("/savestudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult,
			Model theModel) {
		System.out.println(bindingResult);
		System.out.println(theStudent.getStudentFirstName() + "---" + theStudent.getStudentLastName() + "---"
				+ theStudent.getStudentEmailId());

		if (bindingResult.hasErrors()) {
			return "registration-failure";
		} else {
			if (courses != null) {
				// theStudentDAO.saveStudent(theStudent, courses);
				System.out.println("Student updated with ID: " + theStudentDAO.saveStudent(theStudent, courses));
			} else {
				// theStudentDAO.saveStudent(theStudent);
				System.out.println("Student Saved with ID: " + theStudentDAO.saveStudent(theStudent));
			}
			// System.out.println("Student Saved with ID: " +
			// theStudentDAO.saveStudent(theStudent));
			return "registration-success";
		}

	}

	@RequestMapping("/displayStudents")
	public String displayStudents(Model theModel) {
		List<Student> students = theStudentDAO.getStudents();
		theModel.addAttribute("students", students);
		return "student-list";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") int theStudentId, Model theModel) {

		theModel.addAttribute("student", theStudentDAO.getStudent(theStudentId));
		this.courses = theStudentDAO.getStudent(theStudentId).getCourses();

		return "register-student";
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int theStudentId, Model theModel) {
		theStudentDAO.deleteStudent(theStudentId);
		return "delete-success";
	}

	@GetMapping("/mainmenu")
	public void mainMenu(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/admin/menu");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/menu")
	public String menu() {
		return "student-menu";
	}
}
