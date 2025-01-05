package com.app.landingpage.herosections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroSectionService {

    public final HeroSectionRepository heroSectionRepository;

    @Autowired
    public HeroSectionService(HeroSectionRepository heroSectionRepository) {
        this.heroSectionRepository = heroSectionRepository;
    }

    public HeroSection createHeroSection(HeroSection heroSection) {
        return heroSectionRepository.save(heroSection);
    }

    public List<HeroSection> getAllHeroSections() {
        return heroSectionRepository.findAll();
    }

    public HeroSection updateHeroSection(String id, HeroSection updatedHeroSection) {
        return heroSectionRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedHeroSection.getTitle());
                    existing.setSubtitle(updatedHeroSection.getSubtitle());
                    existing.setImage(updatedHeroSection.getImage());
                    return heroSectionRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("HeroSection nieznalezione."));
    }

    public void deleteHeroSection(String id) {
        heroSectionRepository.deleteById(id);
    }
}
