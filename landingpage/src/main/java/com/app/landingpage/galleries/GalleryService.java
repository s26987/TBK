package com.app.landingpage.galleries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    public final GalleryRepository galleryRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<Gallery> getAllGalleries() {
        return galleryRepository.findAll();
    }

    public Optional<Gallery> getGalleryById(String id) {
        return galleryRepository.findById(id);
    }

    public Gallery saveGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public Gallery updateGallery(String id, Gallery updatedGallery) {
        return galleryRepository.findById(id)
                .map(existing -> {
                    if (updatedGallery.getName() != null) {
                        existing.setName(updatedGallery.getName());
                    }
                    if (updatedGallery.getDescription() != null) {
                        existing.setDescription(updatedGallery.getDescription());
                    }
                    if (updatedGallery.getProjects() != null) {
                        existing.setProjects(updatedGallery.getProjects());
                    }
                    return galleryRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Gallery o id: " + id + " nie zostalo znalezione"));
    }

    public void deleteGallery(String id) {
        galleryRepository.deleteById(id);
    }

}
