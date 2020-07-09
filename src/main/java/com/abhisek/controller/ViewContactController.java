package com.abhisek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhisek.dto.Contact;
import com.abhisek.service.ContactDetailsService;

@Controller
public class ViewContactController {
	@Autowired
	private ContactDetailsService service;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("contactId") Integer contactId, Model model) {
		Contact contact = service.getContactById(contactId);
		model.addAttribute("contact", contact);
		return "contactInfo";
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public String deleteContact(@RequestParam("contactId") Integer contactId) {
		boolean isDeleted = service.deleteContact(contactId);
		if (isDeleted) {
			return "redirect:/viewContacts";
		}

		return null;
	}
}
