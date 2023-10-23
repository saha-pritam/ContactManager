package org.pritam.contactManager.controller;

import org.pritam.contactManager.entity.User;
import org.pritam.contactManager.security.UserDetailsImpl;
import org.pritam.contactManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authenticated")
public class AuthenticatedGeneral {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonAttributes(Model model) {
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.getByEmail(userDetailsImpl.getUsername());
		model.addAttribute("userFirstName", user.getFirstName());
	}
	
	@GetMapping("/showContacts")
	public String showContacts() {
		return "showContacts";
	}
}
