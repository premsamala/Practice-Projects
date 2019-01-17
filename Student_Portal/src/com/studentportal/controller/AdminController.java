package com.studentportal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/")
	public String loginRequest(Model theModel) {

		return "admin-welcome";
	}

	@PostMapping("/loginAuthenticate")
	public RedirectView loginAuthenticate(@RequestParam("userName") String userName,
			@RequestParam("password") String password, Model theModel, RedirectAttributes redirectAttributes) {
		if (userName.equals("alpha") && password.equals("0000")) {
			return new RedirectView("menu");
		}
		redirectAttributes.addFlashAttribute("errormessage", "Please enter correct login details");
		return new RedirectView("/admin/", true);
	}

	@GetMapping("/backtowelcome")
	public void backToWelcome(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/student")
	public void studentRedirect(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/student/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/instructors")
	public void instructorRedirect(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/instructor/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/courses")
	public void courseRedirect(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/course/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/registrations")
	public void registrationsRedirect(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/registrations/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/menu")
	public String menu() {
		return "admin-menu";
	}

	@GetMapping("logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
