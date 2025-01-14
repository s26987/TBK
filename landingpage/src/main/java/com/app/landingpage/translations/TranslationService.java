package com.app.landingpage.translations;

import com.app.landingpage.testimonials.Testimonials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TranslationService {

    public final TranslationRepository translationRepository;

    @Autowired
    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public List<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }

    public Optional<Translation> getTranslationById(String id) {
        return translationRepository.findById(id);
    }

    public Translation addTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    public Translation updateTranslation(String id, Translation updatedTranslation) {
        return translationRepository.findById(id)
                .map(existing -> {
                    if (updatedTranslation.getKey() != null) {
                        existing.setKey(updatedTranslation.getKey());
                    }
                    if (updatedTranslation.getTranslations() != null) {
                        existing.setTranslations(updatedTranslation.getTranslations());
                    }
                    if (updatedTranslation.getCreatedAt() != null) {
                        existing.setCreatedAt(updatedTranslation.getCreatedAt());
                    }
                    return translationRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Translation o id: " + id + " nieznaleziony"));
    }

    public void deleteTranslation(String id) {
        translationRepository.deleteById(id);
    }

}
