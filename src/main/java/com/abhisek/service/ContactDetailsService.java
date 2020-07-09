package com.abhisek.service;

import java.util.List;

import com.abhisek.dto.Contact;

public interface ContactDetailsService {
	boolean saveContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactById(Integer contactId);

	boolean deleteContact(Integer contactId);
}
