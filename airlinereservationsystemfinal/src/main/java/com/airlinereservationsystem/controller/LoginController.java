package com.airlinereservationsystem.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.airlinereservationsystem.model.UserDetails;
import com.airlinereservationsystem.modelview.LoginWelcome;
import com.airlinereservationsystem.repository.UserDetailsRepository;

@Controller
@RequestMapping("/login")
@SessionAttributes({ "username", "flightId" })
@Scope(scopeName = "prototype")
public class LoginController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@RequestMapping("/")
	public String loginWelcome(Model theModel) {
		theModel.addAttribute("loginWelcome", new LoginWelcome());
		return "loginwelcome";
	}

	@PostMapping("/verifyuser")
	public String verifyUser(@Valid @ModelAttribute("loginWelcome") LoginWelcome loginWelcome,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("loginError", "Please fill all the fields correctly");
			return "loginwelcome";
		}
		Optional<UserDetails> userDetails = userDetailsRepository.findByUsernameAndPassword(loginWelcome.getUsername(),
				loginWelcome.getPassword());
		if (userDetails.isPresent()) {
			if (!theModel.containsAttribute("username")) {
				theModel.addAttribute("username", loginWelcome.getUsername());
			}
			return "redirect:/flightdetails/";
		} else {
			theModel.addAttribute("loginError", "No user exists with the credentials");
			return "loginwelcome";
		}
	}
}
