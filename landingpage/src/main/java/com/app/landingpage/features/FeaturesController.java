package com.app.landingpage.features;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeaturesController {

    public final FeaturesService featuresService;

    @Autowired
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @PostMapping
    public Features createFeatures(@RequestBody Features features) {
        return featuresService.createFeature(features);
    }

    @GetMapping
    public List<Features> getAllFeatures() {
        return featuresService.getAllFeatures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Features> getFeatureById(@PathVariable String id) {
        return featuresService.getFeatureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Features updateFeature(@PathVariable String id, @RequestBody Features updatedFeatures) {
        return featuresService.updateFeature(id, updatedFeatures);
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable String id) {
        featuresService.deleteFeatures(id);
    }
}
