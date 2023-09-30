package org.pritam.contactManager.service;

import org.pritam.contactManager.entity.Contact;
import org.pritam.contactManager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;
	
	@Transactional
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}
}
