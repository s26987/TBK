package com.app.landingpage.features;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeaturesRepository extends MongoRepository<Features, String> {
}
