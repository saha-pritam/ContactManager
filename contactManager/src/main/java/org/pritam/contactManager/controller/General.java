package org.pritam.contactManager.controller;

import org.pritam.contactManager.entity.User;
import org.pritam.contactManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class General {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message1", "Smart Contact Manager");
		model.addAttribute("message2", "Start Collecting Your Contacts In Very Smarter Way.");
		model.addAttribute("message3", "We Provide Very Efficient And Smarter Way Of Handling Contacts.");
		return "home";
	}
	
	@GetMapping("/getRegistered")
	public String getRegistered(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registrationPage";
	}
	
	@PostMapping("/getRegistered")
	public String getRegistered(@ModelAttribute("user") User user,Model model){
		if(userService.isEmailExists(user.getEmail())) {
			model.addAttribute("duplicateEmail", true);
			return "registrationPage";
		}
		user.setEnabled(true);
		user.setRole("USER");
		if(user.getDescription()!=null && user.getDescription().length()==0)
			user.setDescription(null);
		userService.saveUser(user);
		model.addAttribute("message1", "Hey User, Welcome To Smart Contact Manager");
		model.addAttribute("message2", "Your Account Has Been Successfully Created.");
		model.addAttribute("message3", "You Can Now Login And Start Collecting Your Contacts In Very Smarter Way.");
		return "home";
	}
}
