package com.example.demo.serviceImpl;

import com.example.demo.dto.ContactDetail;
import com.example.demo.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ContactServiceImpl implements ContactService {

    static Set<ContactDetail> contactList = new HashSet<>();
    static {
        ContactDetail ct1 =new ContactDetail("1","Akash","surwase","akash@gmail.com","7777777777","Active");
        ContactDetail ct2 =new ContactDetail("2","abc","pqr","pqr@gmail.com","8888888888","Active");
        ContactDetail ct3 =new ContactDetail("3","dfg","rty","dfg@gmail.com","9999999999","Active");
        contactList.add(ct1);
        contactList.add(ct2);
        contactList.add(ct3);
    }

    static Integer counter = 4;


    @Override
    public Set<ContactDetail> getAllContacts() {
        return contactList;
    }

    @Override
    public ContactDetail saveContactDetail(ContactDetail contact) {

        if (contact.getId() == null) {
            counter = counter + 1;
            contact.setId(counter.toString());
        }

        if (contactList.add(contact)) {
            return contact;
        }
        return null;
    }

    @Override
    public ContactDetail updateContact(ContactDetail contact) {
        for (ContactDetail existingContact : contactList) {
            if (existingContact.getId().equals(contact.getId())) {
                contactList.remove(existingContact);
            }
        }
        return saveContactDetail(contact);
    }

    @Override
    public ContactDetail deleteContact(Integer id) {
        for (ContactDetail existingContact : contactList) {
            if (existingContact.getId().equals(id.toString())) {
                contactList.remove(existingContact);
                return existingContact;
            }
        }
        return null;
    }
}
