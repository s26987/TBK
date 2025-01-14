package com.app.landingpage.contactforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContactForms> getContactForms(@PathVariable String id) {
        return contactFormsService.getContactFormsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
