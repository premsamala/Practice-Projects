package com.spring.mvc;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
@PropertySources({
		@PropertySource("file:/Users/premsamala/Spring-Framework/UdemyPracticeMVC/WebContent/WEB-INF/countries.properties"),
		@PropertySource("file:/Users/premsamala/Spring-Framework/UdemyPracticeMVC/WebContent/WEB-INF/fav-games.properties") })
public class StudentController {
	@Autowired
	private Student student;

	@Value("#{${country.properties}}")
	private Map<String, String> countryOptions;

	@Value("#{'${games}'.split(',')}")
	private List<String> favGames;

	@RequestMapping("/showForm")
	public String createStudent(Model model) {
		model.addAttribute("student", student);
		model.addAttribute("countryOptions", countryOptions);
		model.addAttribute("favGames", favGames);
		Iterator<String> iterator = favGames.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}
		return "student-registration";
	}

	@RequestMapping("/processForm")
	public String studentRegistration(@Valid @ModelAttribute("student") Student theStudent,
			BindingResult bindingResult) {
		System.out.println("Student name:" + theStudent.getFirstName() + theStudent.getLastName());
		List errors = bindingResult.getAllErrors();
		int errorCount = bindingResult.getErrorCount();
		System.out.println(errorCount);
		Iterator iterator = errors.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		if (bindingResult.hasErrors()) {
			return "student-registration";
		} else
			return "registration-success";
	}
}
