package org.pritam.contactManager.controller;

import org.pritam.contactManager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class General {
	@GetMapping("/")
	public String welcome() {
		return "home";
	}
	
	@GetMapping("/getRegistered")
	public String getRegistered() {
		return "registrationPage";
	}
	
	@PostMapping("/getRegistered")
	public String getRegistered(@ModelAttribute User user) {
		System.out.println(user);
		return "home";
	}
}
