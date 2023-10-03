package org.pritam.contactManager.repository;

import java.util.Optional;

import org.pritam.contactManager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
	public Optional<User> findByEmail(String email);
}
