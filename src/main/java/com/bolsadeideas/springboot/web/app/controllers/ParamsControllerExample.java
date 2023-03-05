package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsControllerExample {

	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String param(@RequestParam(name = "text", required = false, defaultValue = "any value...") String text,
			Model model) {
		model.addAttribute("result", "Value text: " + text);
		return "params/view";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String text, @RequestParam Integer number, Model model) {
		model.addAttribute("result", "Text sent is: '" + text + "' and number '" + number + "'");
		return "params/view";
	}

	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String text = request.getParameter("text");
		Integer number;

		try {
			number = Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
			number = 0;
		}

		model.addAttribute("result", "Text sent is: '" + text + "' and number '" + number + "'");
		return "view";
	}

}
