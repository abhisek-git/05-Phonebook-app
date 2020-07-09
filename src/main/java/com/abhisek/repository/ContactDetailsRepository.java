package com.abhisek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhisek.model.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer> {

}
