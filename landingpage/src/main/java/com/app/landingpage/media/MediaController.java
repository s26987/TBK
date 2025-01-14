package com.app.landingpage.media;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable String id) {
        return mediaService.getMediaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Media addMedia(@RequestBody Media media) {
        return mediaService.addMedia(media);
    }

    @PutMapping("/{id}")
    public Media updateMedia(@PathVariable String id, @RequestBody Media updatedMedia) {
        return mediaService.updateMedia(id, updatedMedia);
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable String id) {
        mediaService.deleteMedia(id);
    }
}
