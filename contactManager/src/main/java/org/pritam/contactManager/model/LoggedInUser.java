package org.pritam.contactManager.model;

import org.pritam.contactManager.entity.User;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LoggedInUser {
	private User user;
	
}
