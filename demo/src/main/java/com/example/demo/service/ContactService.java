package com.example.demo.service;

import com.example.demo.dto.ContactDetail;

import java.util.Set;

public interface ContactService {
    Set<ContactDetail> getAllContacts();

    ContactDetail saveContactDetail(ContactDetail contact);

    ContactDetail updateContact(ContactDetail contact);

    ContactDetail deleteContact(Integer  id);
}
