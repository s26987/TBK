package com.app.landingpage.personalizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalizations")
public class PersonalizationController {

    public final PersonalizationService personalizationService;

    @Autowired
    public PersonalizationController(PersonalizationService personalizationService) {
        this.personalizationService = personalizationService;
    }

    @GetMapping
    public List<Personalization> getAllPersonalizations() {
        return personalizationService.getAllPersonalizations();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Personalization> getPersonalizationById(@PathVariable String id) {
        return personalizationService.getPersonalizationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Personalization createPersonalization(@RequestBody Personalization personalization) {
        return personalizationService.addPersonalization(personalization);
    }

    @PutMapping(path = "/{id}")
    public Personalization updatePersonalization(@PathVariable String id, @RequestBody Personalization updatedPersonalization) {
        return personalizationService.updatePersonalization(id, updatedPersonalization);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonalization(@PathVariable String id) {
        personalizationService.deletePersonalization(id);
    }

}
