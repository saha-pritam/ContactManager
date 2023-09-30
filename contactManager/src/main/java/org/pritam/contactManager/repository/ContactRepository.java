package org.pritam.contactManager.repository;

import org.pritam.contactManager.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
