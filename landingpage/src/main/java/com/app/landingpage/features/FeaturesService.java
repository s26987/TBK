package com.app.landingpage.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeaturesService {

    public final FeaturesRepository featuresRepository;

    @Autowired
    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    public Features createFeature(Features features) {
        return featuresRepository.save(features);
    }

    public List<Features> getAllFeatures() {
        return featuresRepository.findAll();
    }

    public Optional<Features> getFeatureById(String id) {
        return featuresRepository.findById(id);
    }

    public Features updateFeature(String id, Features updatedFeatures) {
        return featuresRepository.findById(id)
                .map(existing -> {
                    if (updatedFeatures.getFeatures() != null) {
                        existing.setFeatures(updatedFeatures.getFeatures());
                    }
                    if (updatedFeatures.getBenefits() != null) {
                        existing.setBenefits(updatedFeatures.getBenefits());
                    }
                    return featuresRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("HeroSection nieznalezione."));
    }

    public void deleteFeatures(String id) {
        featuresRepository.deleteById(id);
    }
}
