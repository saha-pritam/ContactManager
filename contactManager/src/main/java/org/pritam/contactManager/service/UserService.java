package org.pritam.contactManager.service;

import org.pritam.contactManager.entity.User;
import org.pritam.contactManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
