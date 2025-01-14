package com.app.landingpage.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    public final MediaRepository mediaRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Optional<Media> getMediaById(String id) {
        return mediaRepository.findById(id);
    }

    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    public Media updateMedia(String id, Media updatedMedia) {
        return mediaRepository.findById(id)
                .map(existing -> {
                    if (updatedMedia.getName() != null) {
                        existing.setName(updatedMedia.getName());
                    }
                    if (updatedMedia.getUrl() != null) {
                        existing.setUrl(updatedMedia.getUrl());
                    }
                    if (updatedMedia.getType() != null) {
                        existing.setType(updatedMedia.getType());
                    }
                    return mediaRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Media o id: " + id + " nie zostalo znalezione"));
    }

    public void deleteMedia(String id) {
        mediaRepository.deleteById(id);
    }

}
