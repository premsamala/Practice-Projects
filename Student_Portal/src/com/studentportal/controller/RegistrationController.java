package com.studentportal.controller;

import java.util.List;

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

import com.studentportal.dao.CourseDAO;
import com.studentportal.dao.StudentDAO;
import com.studentportal.entity.Course;
import com.studentportal.entity.Student;
import com.studentportal.entity.TempStudent;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {

	@Autowired
	private CourseDAO theCourseDAO;

	@Autowired
	private StudentDAO theStudentDAO;

	@InitBinder
	public void stringTrimmer(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/")
	public String welcome() {
		return "redirect:menu";
	}

	@GetMapping("/menu")
	public String menu() {
		return "registration-menu";
	}

	@GetMapping("/backtomenu")
	public String backToMenu() {
		return "redirect:/admin/menu";
	}

	@GetMapping("/register")
	public String newRegistration(Model theModel) {

		List<Student> studentsList = theStudentDAO.getStudents();
		List<Course> coursesList = theCourseDAO.getCourses();
		theModel.addAttribute("students", studentsList);
		theModel.addAttribute("courses", coursesList);
		return "new-registration";
	}

	@GetMapping("/newregistration")
	public String reegistration(@RequestParam("students") String studentId, @RequestParam("courses") String courseId,
			Model theModel) {
		Course theCourse = theCourseDAO.getCourse(Integer.parseInt(courseId));
		theStudentDAO.addCourse(Integer.parseInt(studentId), theCourse);
		return "registration-success";
	}

	@RequestMapping("/displayregistrations")
	public String displayRegistrations(Model theModel) {
		List<Student> studentsList = theStudentDAO.getStudents();
		theModel.addAttribute("students", studentsList);

		theModel.addAttribute("student", new TempStudent());
		return "registrations-list";
	}

	@RequestMapping("/deleteregistration")
	public String deleteStudent(@Valid @ModelAttribute("student") TempStudent theStudent,
			BindingResult theBindingResult, Model theModel) {
		System.out.println(theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "registrations-error";
		}
		theStudentDAO.deleteCourses(theStudent.getId(), theStudent.getCourseSelection());
		return "delete-success";
	}
}
