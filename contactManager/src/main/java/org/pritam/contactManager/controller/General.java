package org.pritam.contactManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class General {
	@GetMapping("/")
	public String welcome() {
		return "home";
	}
}
