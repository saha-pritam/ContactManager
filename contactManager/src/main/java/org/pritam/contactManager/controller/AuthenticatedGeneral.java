package org.pritam.contactManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authenticated")
public class AuthenticatedGeneral {
	
	@GetMapping("/showContacts")
	@ResponseBody
	public String tessignin() {
		return "This is show contacts page";
	}
}
