package com.app.landingpage.translations;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TranslationRepository extends MongoRepository<Translation, String> {
}
