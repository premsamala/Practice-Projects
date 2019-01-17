package com.studentportal.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.studentportal.dao.CourseDAO;
import com.studentportal.dao.StudentDAO;
import com.studentportal.entity.Course;
import com.studentportal.entity.Student;

@Controller
@SessionAttributes("studentId")
@RequestMapping("/enroll")
public class EnrollmentController {

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping("/welcome")
	public String studentPortal() {

		return "enroll-welcome";
	}

	@RequestMapping("/")
	public String welcome(Model theModel) {
		return "enroll-welcome";
	}

	@RequestMapping("/initiallogin")
	public RedirectView initialLogin(@RequestParam("studentId") String theId, Model theModel,
			RedirectAttributes redirectAttributes) {
		int studentId = Integer.parseInt(theId);
		theModel.addAttribute("studentId", theId);
		Student student = studentDAO.getStudent((studentId));
		if (student == null) {
			redirectAttributes.addFlashAttribute("errormessage", "You currently have no access, Please contact admin");
			return new RedirectView("/enroll/", true);
		}
		System.out.println(studentId);
		return new RedirectView("menu", true);
	}

	@RequestMapping("/menu")
	public String menuDisplayer(@ModelAttribute("studentId") String theId, Model theModel) {

		return "enroll-menu";
	}

	@RequestMapping("/enroll")
	public String enrollCourses(@ModelAttribute("studentId") String studentId, Model theModel) {
		List<Course> courses = courseDAO.getCourses();
		theModel.addAttribute("courses", courses);
		Student student = studentDAO.getStudent((Integer.parseInt(studentId)));
		System.out.println(student.getStudentId());
		theModel.addAttribute("student", student);
		return "enroll-courses";
	}

	@RequestMapping("/processrequest")
	public String registerStudent(@ModelAttribute("studentId") String studentId,
			@ModelAttribute("student") Student theStudent, BindingResult result, Model model) {
		System.out.println(Arrays.toString(theStudent.getCourseSelection()));
		List<Course> courses = courseDAO.getCourses(theStudent.getCourseSelection());
		boolean bool = studentDAO.addCourses(Integer.parseInt(studentId), courses);
		System.out.println(bool);
		return "registration-success";

	}

	@RequestMapping("/displaycourses")
	public String displayCourses(@ModelAttribute("studentId") String studentId, Model theModel) {
		List<Course> courses = courseDAO.getCourses(Integer.parseInt(studentId));
		if (courses == null) {
			return "no-courses-to-display";
		}
		courses.forEach(temp -> System.out.println(temp));
		theModel.addAttribute("courses", courses);
		return "display-courses";
	}

	@RequestMapping("/updatecourses")
	public String updateCourses(@ModelAttribute("studentId") String studentId, Model theModel) {
		List<Course> courses = courseDAO.getCourses(Integer.parseInt(studentId));
		if (courses == null) {
			return "no-courses-to-display";
		}
		courses.forEach(temp -> System.out.println(temp));
		theModel.addAttribute("courses", courses);
		theModel.addAttribute("student", new Student());
		return "update-courses";
	}

	@RequestMapping("/deletecourses")
	public String deleteCourses(@ModelAttribute("studentId") String studentId,
			@ModelAttribute("student") Student theStudent, BindingResult result, Model model) {
		System.out.println(Arrays.toString(theStudent.getCourseSelection()));
		int deletedQueries = courseDAO.deleteCourses(Integer.parseInt(studentId), theStudent.getCourseSelection());
		System.out.println(deletedQueries);
		return "registration-success";

	}

	@GetMapping("/backtowelcome")
	public void backToWelcome(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/logout")
	public void logout(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/enroll/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
