package com.app.landingpage.galleries;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GalleryRepository extends MongoRepository<Gallery, String> {

}
