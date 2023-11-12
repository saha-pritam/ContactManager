package org.pritam.contactManager.security;

import org.pritam.contactManager.entity.User;
import org.pritam.contactManager.model.LoggedInUser;
import org.pritam.contactManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoggedInUser loggedInUser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getByEmail(username);
		if(user==null)
			throw new UsernameNotFoundException("User Not Found");
		loggedInUser.setUser(user);
		return new UserDetailsImpl(user);
	}

}
