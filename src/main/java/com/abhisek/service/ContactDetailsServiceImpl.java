package com.abhisek.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisek.dto.Contact;
import com.abhisek.model.ContactDetails;
import com.abhisek.repository.ContactDetailsRepository;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

	@Autowired
	private ContactDetailsRepository repository;

	@Override
	public boolean saveContact(Contact contact) {
		ContactDetails contactDetails = new ContactDetails();

		BeanUtils.copyProperties(contact, contactDetails);
		ContactDetails savedEntity = repository.save(contactDetails);
		return savedEntity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactDetails> entities = repository.findAll();
		return entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<ContactDetails> contactDetails = repository.findById(contactId);
		if (contactDetails.isPresent()) {
			ContactDetails c = contactDetails.get();
			Contact contact = new Contact();
			BeanUtils.copyProperties(c, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		repository.deleteById(contactId);
		return true;
	}

}
