package com.studentportal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/admin")
	public void redirectAdmin(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath() + "/admin/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/student")
	public void redirectStudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath() + "/enroll/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
