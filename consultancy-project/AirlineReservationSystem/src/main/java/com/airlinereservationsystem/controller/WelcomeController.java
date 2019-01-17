package com.airlinereservationsystem.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Scope(scopeName="prototype")
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/existinguser")
	public String register() {
		return "redirect:/login/";
	}
}
