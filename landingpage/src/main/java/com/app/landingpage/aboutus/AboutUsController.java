package com.app.landingpage.aboutus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/about-us")
public class AboutUsController {

    public final AboutUsService aboutUsService;

    @Autowired
    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @PostMapping
    public AboutUs createAboutUs(@RequestBody AboutUs aboutUs) {
        return aboutUsService.createAboutUs(aboutUs);
    }

    @GetMapping
    public List<AboutUs> getAllAboutUs() {
        return aboutUsService.getAllAboutUs();
    }

    @GetMapping("/{id}")
    public Optional<AboutUs> findAboutUsById(@PathVariable String id) {
        return aboutUsService.findAboutUsById(id);
    }

    @PutMapping("/{id}")
    public AboutUs updateAboutUs(@PathVariable String id, @RequestBody AboutUs updatedAboutUs) {
        return aboutUsService.updateAboutUs(id, updatedAboutUs);
    }

    @DeleteMapping("/{id}")
    public void deleteAboutUsById(@PathVariable String id) {
        aboutUsService.deleteAboutUsById(id);
    }
}
