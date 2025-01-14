package com.app.landingpage.contactforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactFormsService {

    public final ContactFormsRepository contactFormsRepository;

    @Autowired
    public ContactFormsService(ContactFormsRepository contactFormsRepository) {
        this.contactFormsRepository = contactFormsRepository;
    }

    public List<ContactForms> getAllContactForms() {
        return contactFormsRepository.findAll();
    }

    public ContactForms addContactForms(ContactForms contactForms) {
        return contactFormsRepository.save(contactForms);
    }

    public Optional<ContactForms> getContactFormsById(String id) {
        return contactFormsRepository.findById(id);
    }

    public ContactForms updateContactForms(String id, ContactForms updatedContactForms) {
        return contactFormsRepository.findById(id)
                .map(existing -> {
                    if (updatedContactForms.getName() != null) {
                        existing.setName(updatedContactForms.getName());
                    }
                    if (updatedContactForms.getEmail() != null) {
                        existing.setEmail(updatedContactForms.getEmail());
                    }
                    if (updatedContactForms.getSubject() != null) {
                        existing.setSubject(updatedContactForms.getSubject());
                    }
                    if (updatedContactForms.getMessage() != null) {
                        existing.setMessage(updatedContactForms.getMessage());
                    }
                    if (updatedContactForms.getStatus() != null) {
                        existing.setStatus(updatedContactForms.getStatus());
                    }
                    if (updatedContactForms.getDate() != null) {
                        existing.setDate(updatedContactForms.getDate());
                    }
                    return contactFormsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("ContactForms o id: " + id + " nie zostalo znalezione"));
    }

    public void deleteContactForms(String id) {
        contactFormsRepository.deleteById(id);
    }
}
