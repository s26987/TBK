package com.app.landingpage.translations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    public final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping
    public List<Translation> getAllTestimonials() {
        return translationService.getAllTranslations();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Translation> getTranslationById(@PathVariable String id) {
        return translationService.getTranslationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Translation createTranslation(@RequestBody Translation translation) {
        return translationService.addTranslation(translation);
    }

    @PutMapping(path = "/{id}")
    public Translation updateTranslation(@PathVariable String id, @RequestBody Translation updatedTranslation) {
        return translationService.updateTranslation(id, updatedTranslation);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTranslation(@PathVariable String id) {
        translationService.deleteTranslation(id);
    }

}
