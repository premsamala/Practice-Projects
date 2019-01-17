package com.studentportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentportal.dao.CourseDAO;
import com.studentportal.dao.InstructorDAO;
import com.studentportal.entity.Course;
import com.studentportal.entity.Instructor;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseDAO theCourseDAO;

	@Autowired
	private InstructorDAO theInstructorDAO;

	@RequestMapping("/")
	public String welcome() {
		return "redirect:menu";
	}

	@GetMapping("/menu")
	public String menu() {
		return "course-menu";
	}

	@GetMapping("/backtomenu")
	public String backToMenu() {
		return "redirect:/admin/menu";
	}

	@GetMapping("/register")
	public String registerCourse(Model theModel) {
		theModel.addAttribute("course", new Course());
		theModel.addAttribute("instructors", theInstructorDAO.getInstructors());
		return "register-course";
	}

	@PostMapping("/savecourse")
	public String saveCourse(@Valid @ModelAttribute("course") Course theCourse, BindingResult theBindingResult,
			Model theModel) {
		System.out.println(theCourse.getInstructorId());
		System.out.println(theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "redirect:register";
		} else {
			Instructor theInstructor = theInstructorDAO.getInstructor(theCourse.getInstructorId());
			theCourse.setInstructor(theInstructor);
			int courseId = theCourseDAO.save(theCourse);
			System.out.println("Course saved iwth ID:" + courseId);
			return "registration-success";
		}

	}

	@RequestMapping("/managecourse")
	public String displayCourses(Model theModel) {
		List<Course> courses = theCourseDAO.getCourses();
		theModel.addAttribute("courses", courses);
		return "course-list";
	}

	@RequestMapping("/updatecourse")
	public String updateCourse(@RequestParam("courseId") int theCourseId, Model theModel) {

		theModel.addAttribute("course", theCourseDAO.getCourse(theCourseId));
		theModel.addAttribute("instructors", theInstructorDAO.getInstructors());

		return "register-course";
	}

	@RequestMapping("/deletecourse")
	public String deleteCourse(@RequestParam("courseId") int theCourseId, Model theModel) {
		theCourseDAO.deleteCourse(theCourseId);
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
}
