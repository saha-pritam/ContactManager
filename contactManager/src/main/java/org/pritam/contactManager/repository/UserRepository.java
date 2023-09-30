package org.pritam.contactManager.repository;

import org.pritam.contactManager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
