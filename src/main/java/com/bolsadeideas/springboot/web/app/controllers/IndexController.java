package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${text.indexcontroller.index.title}")
	private String indexText;

	@Value("${text.indexcontroller.profile.title}")
	private String profileText;

	@Value("${text.indexcontroller.list.title}")
	private String listText;

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("title", indexText);
		return "index";
	}

	@GetMapping("/profile")
	public String profile(Model model) {

		User user = new User();
		user.setFirstName("Jordi");
		user.setLastName("Morera");
		user.setEmail("jordimorera86@gmail.com");

		model.addAttribute("user", user);
		model.addAttribute("title", profileText.concat(user.getFirstName()));

		return "profile";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", listText);

		return "list";
	}

	@ModelAttribute("users")
	public List<User> fillUsers() {

		return Arrays.asList(new User("Jordi", "Morera", "jordimorera86@gmail.com"),
				new User("John", "Doe", "john@mail.com"), new User("Jane", "Doe", "jane@mail.com"),
				new User("Anita", "Bath", "anita@mail.com"));
	}

}
