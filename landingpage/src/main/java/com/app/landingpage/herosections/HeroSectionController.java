package com.app.landingpage.herosections;

import com.app.landingpage.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero-sections")
public class HeroSectionController {

    public final HeroSectionService heroSectionService;

    @Autowired
    public HeroSectionController(HeroSectionService heroSectionService) {
        this.heroSectionService = heroSectionService;
    }

    @PostMapping
    public HeroSection createHeroSection(@RequestBody HeroSection heroSection) {
        return heroSectionService.createHeroSection(heroSection);
    }

    @GetMapping
    public List<HeroSection> getAllHeroSections() {
        return heroSectionService.getAllHeroSections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroSection> getHeaderById(@PathVariable String id) {
        return heroSectionService.getHeroSectionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public HeroSection updateHeroSection(@PathVariable String id, @RequestBody HeroSection updatedHeroSection) {
        return heroSectionService.updateHeroSection(id, updatedHeroSection);
    }

    @DeleteMapping("/{id}")
    public void deleteHeroSection(@PathVariable String id) {
        heroSectionService.deleteHeroSection(id);
    }
}
