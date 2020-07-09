package com.abhisek.service;

import java.util.List;


import com.abhisek.dto.Contact;

public interface ContactDetailsService {
	boolean saveContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactById(Integer contactId);

	//boolean updateContact(Contact contact);

	boolean deleteContact(Integer contactId);
}
