package com.app.landingpage.contactforms;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactFormsRepository extends MongoRepository<ContactForms, String> {
}
