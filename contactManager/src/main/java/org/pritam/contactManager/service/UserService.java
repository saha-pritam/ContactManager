package org.pritam.contactManager.service;

import java.util.Optional;

import org.pritam.contactManager.entity.User;
import org.pritam.contactManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole("USER");
		return userRepository.save(user);
	}
	
	@Transactional
	public boolean isEmailExists(String email) {
		return userRepository.findByEmail(email).isPresent();
	}
	
	@Transactional
	public User getByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if(optionalUser.isPresent())
			return optionalUser.get();
		return null;
	}
}
