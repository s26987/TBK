package com.app.landingpage.headers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeaderRepository extends MongoRepository<Header, String> {
}
