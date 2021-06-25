package com.example.demo.controller;

import com.example.demo.dto.ContactDetail;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public Set<ContactDetail> getContactDetails(){
        Set<ContactDetail> contactList = contactService.getAllContacts();
        return contactList;
    }
    @PostMapping("/contact")
    public ResponseEntity saveContact(@RequestBody ContactDetail contact){
        ContactDetail detail = contactService.saveContactDetail(contact);
        if(detail == null){
            return new ResponseEntity<>("Contact Already Exists", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }

    }
    @PutMapping("/contact")
    public ResponseEntity updateContact(@RequestBody ContactDetail contact){

        ContactDetail detail = contactService.updateContact(contact);
        if(detail == null){
            return new ResponseEntity<>("Contact updation failed", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
    }
    @DeleteMapping("/contact/{id}")
    public ResponseEntity deleteContact(@PathVariable Integer id){
        ContactDetail detail = contactService.deleteContact(id);
        if(detail == null){
            return new ResponseEntity<>("Contact deletion failed", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Contact deleted Successfully", HttpStatus.OK);
        }
    }
}
