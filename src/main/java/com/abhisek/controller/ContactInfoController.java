package com.abhisek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhisek.dto.Contact;
import com.abhisek.service.ContactDetailsService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactDetailsService service;

	@GetMapping(value = { "/", "/addContact" })
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";

	}

	@PostMapping(value = "/saveContact")
	public String handleSubmitBtn(@ModelAttribute Contact contact, Model model) {
		boolean isSaved = service.saveContact(contact);
		if (isSaved) {
			model.addAttribute("succMsg", "contact saved");
		} else {
			model.addAttribute("errMsg", "Failed To Save Contact");
		}
		return "contactInfo";
	}
	@GetMapping("/viewContacts")
	public String handleViewContactsLink(Model model) {
		List<Contact> contacts=service.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "viewContacts";
	}
}
