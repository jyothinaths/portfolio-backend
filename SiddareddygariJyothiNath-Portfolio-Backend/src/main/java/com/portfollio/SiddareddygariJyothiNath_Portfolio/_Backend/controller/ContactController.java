package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.controller;


import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Contact;
import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with ID: " + id));
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactRepository.findById(id).map(contact -> {
            contact.setEmail(updatedContact.getEmail());
            contact.setPhone(updatedContact.getPhone());
            contact.setLinkedInUrl(updatedContact.getLinkedInUrl());
            contact.setGithubUrl(updatedContact.getGithubUrl());
            contact.setAddress(updatedContact.getAddress());
            return contactRepository.save(contact);
        }).orElseThrow(() -> new RuntimeException("Contact not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}
