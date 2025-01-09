package com.app.landingpage.testimonials;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestimonialsRepository extends MongoRepository<Testimonials, String> {

}
