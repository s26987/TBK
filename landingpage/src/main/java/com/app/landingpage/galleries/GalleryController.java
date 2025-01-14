package com.app.landingpage.galleries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galleries")
public class GalleryController {

    public final GalleryService galleryService;

    @Autowired
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping
    public List<Gallery> getAllGalleries() {
        return galleryService.getAllGalleries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable String id) {
        return galleryService.getGalleryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gallery addGallery(@RequestBody Gallery gallery) {
        return galleryService.saveGallery(gallery);
    }

    @PutMapping("/{id}")
    public Gallery updateGallery(@PathVariable String id, @RequestBody Gallery updatedGallery) {
        return galleryService.updateGallery(id, updatedGallery);
    }

    @DeleteMapping("/{id}")
    public void deleteGallery(@PathVariable String id) {
        galleryService.deleteGallery(id);
    }
}
