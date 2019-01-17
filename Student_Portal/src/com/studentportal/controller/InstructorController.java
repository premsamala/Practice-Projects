package com.studentportal.controller;

import com.studentportal.dao.CourseDAO;
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

import com.studentportal.dao.InstructorDAO;
import com.studentportal.entity.Course;
import com.studentportal.entity.Instructor;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	private InstructorDAO theInstructorDAO;
        
        @Autowired CourseDAO theCourseDAO;

	@RequestMapping("/")
	public String welcome() {
		return "redirect:menu";
	}

	@GetMapping("/menu")
	public String menu() {
		return "instructor-menu";
	}

	@GetMapping("/backtomenu")
	public String backToMenu() {
		return "redirect:/admin/menu";
	}

	@GetMapping("/register")
	public String registerInstructor(Model theModel) {
		theModel.addAttribute("instructor", new Instructor());
		return "register-instructor";
	}

	@PostMapping("/saveinstructor")
	public String saveInstructor(@Valid @ModelAttribute("instructor") Instructor theInstructor,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			return "redirect:register";
		} else {
                        List<Course> courses = theCourseDAO.getInstructorCourses(theInstructor.getInstructorId());
                        theInstructor.setCourses(courses);
			int instructorId = theInstructorDAO.save(theInstructor);
			System.out.println("Instructor saved iwth ID:" + instructorId);
			return "registration-success";
		}

	}

	@RequestMapping("/manageinstructor")
	public String displayInstructors(Model theModel) {
		List<Instructor> instructors = theInstructorDAO.getInstructors();
		theModel.addAttribute("instructors", instructors);
		return "instructor-list";
	}

	@RequestMapping("/updateInstructor")
	public String updateInstructor(@RequestParam("instructorId") int theInstructorId, Model theModel) {

		theModel.addAttribute("instructor", theInstructorDAO.getInstructor(theInstructorId));

		return "register-instructor";
	}

	@RequestMapping("/deleteInstructor")
	public String deleteInstructor(@RequestParam("instructorId") int theInstructorId, Model theModel) {
		theInstructorDAO.deleteInstructor(theInstructorId);
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
