package com.spring.mvc;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @Scope("prototype")
@RequestMapping("/customer")
@PropertySources({
		@PropertySource("file:/Users/premsamala/Spring-Framework/UdemyPracticeMVC/WebContent/WEB-INF/countries.properties"),
		@PropertySource("file:/Users/premsamala/Spring-Framework/UdemyPracticeMVC/WebContent/WEB-INF/fav-games.properties") })
public class CustomerController {
	@Autowired
	private Customer customer;
	@Value("#{${country.properties}}")
	private Map<String, String> countryOptions;
	@Value("#{'${games}'.split(',')}")
	private List<String> favGames;

	@ModelAttribute("countryOptions")
	public Map<String, String> addCountryOptions() {
		Map<String, String> theCountryOptions = this.countryOptions;
		return theCountryOptions;
	}

	@ModelAttribute("favGames")
	public List<String> addfavGames() {
		List<String> theFavGames = this.favGames;
		return theFavGames;
	}

	@InitBinder
	public void stringTrimmer(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", customer);
		// model.addAttribute("countryOptions", addCountryOptions());
		// model.addAttribute("favGames", addfavGames());
		return "customer-registration";
	}

	@RequestMapping("/processForm")
	public String registrationConfirmation(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult bindingResult, Model model) {
		System.out.println("Customer details:" + theCustomer.getAddress().toString());
		System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {
			// model.addAttribute("customer", theCustomer);
			// model.addAttribute("countryOptions", countryOptions);
			// model.addAttribute("favGames", favGames);
			return "customer-registration";
		} else {
			return "customer-confirmation";
		}
	}
}
