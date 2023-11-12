package org.pritam.contactManager.service;

import java.util.List;

import org.pritam.contactManager.entity.CustomField;
import org.pritam.contactManager.repository.CustomFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomFieldService {
	
	@Autowired
	private CustomFieldRepository customFieldRepository;
	
	@Transactional
	public Iterable<CustomField> saveCustomFields(List<CustomField> customFieldList) {
		return customFieldRepository.saveAll(customFieldList);
	}
}
