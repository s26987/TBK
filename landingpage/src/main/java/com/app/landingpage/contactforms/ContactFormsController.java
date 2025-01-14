package com.app.landingpage.contactforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-forms")
public class ContactFormsController {

    public final ContactFormsService contactFormsService;

    @Autowired
    public ContactFormsController(ContactFormsService contactFormsService) {
        this.contactFormsService = contactFormsService;
    }

    @PostMapping
    public ContactForms createContactForms(@RequestBody ContactForms contactForms) {
        return contactFormsService.addContactForms(contactForms);
    }

    @GetMapping
    public List<ContactForms> getAllContactForms() {
        return contactFormsService.getAllContactForms();
    }

    @PutMapping(path = "/{id}")
    public ContactForms updateContactForms(@PathVariable String id, @RequestBody ContactForms contactForms) {
        return contactFormsService.updateContactForms(id, contactForms);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteContactForms(@PathVariable String id) {
        contactFormsService.deleteContactForms(id);
    }
}
