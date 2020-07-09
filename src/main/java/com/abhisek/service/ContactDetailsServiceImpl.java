package com.abhisek.service;

import java.util.ArrayList;
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
		ContactDetails contactDetails=new ContactDetails();
		
		BeanUtils.copyProperties(contact, contactDetails);
		ContactDetails savedEntity=repository.save(contactDetails);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactDetails> entities=repository.findAll();
		/*List<Contact> contacts=new ArrayList<>();
		//legacy approach
		for(ContactDetails entity:entities) {
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}
		return contacts;*/
		
		//java8 approach
	List<Contact> contacts2=entities.stream().map(entity->{
		Contact contact=new Contact();
		BeanUtils.copyProperties(entity, contact);
		return contact;
	}).collect(Collectors.toList());
	return contacts2;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<ContactDetails> contactDetails=repository.findById(contactId);
		if(contactDetails.isPresent()) {
			ContactDetails c=contactDetails.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(c, contact);
			return contact;
		}
		return null;
	}
	@Override
	public boolean deleteContact(Integer contactId) {
		repository.deleteById(contactId);
		System.out.println("the record is deleted successfully with id :"+contactId);
		return true;
	}

}
