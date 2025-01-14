package com.app.landingpage.personalizations;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalizationRepository extends MongoRepository<Personalization, String> {

}
