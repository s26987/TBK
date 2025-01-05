package com.app.landingpage.herosections;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroSectionRepository extends MongoRepository<HeroSection, String> {
    // w mongodb nie trzeba dawac @Repository, spring data sam rozpoznaje
}
