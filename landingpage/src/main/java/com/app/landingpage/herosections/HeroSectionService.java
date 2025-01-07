package com.app.landingpage.herosections;

import com.app.landingpage.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public Optional<HeroSection> getHeroSectionById(String id) {
        return heroSectionRepository.findById(id);
    }

    public HeroSection updateHeroSection(String id, HeroSection updatedHeroSection) {
        return heroSectionRepository.findById(id)
                .map(existing -> {
                    if (updatedHeroSection.getTitle() != null) {
                        existing.setTitle(updatedHeroSection.getTitle());
                    }
                    if (updatedHeroSection.getSubtitle() != null) {
                        existing.setSubtitle(updatedHeroSection.getSubtitle());
                    }
                    if (updatedHeroSection.getImage() != null) {
                        existing.setImage(updatedHeroSection.getImage());
                    }
                    return heroSectionRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("HeroSection nieznalezione."));
    }

    public void deleteHeroSection(String id) {
        heroSectionRepository.deleteById(id);
    }
}
