package com.app.landingpage.aboutus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutUsService {

    public final AboutUsRepository aboutUsRepository;

    @Autowired
    public AboutUsService(AboutUsRepository aboutUsRepository) {
        this.aboutUsRepository = aboutUsRepository;
    }

    public AboutUs createAboutUs(AboutUs aboutUs) {
        return aboutUsRepository.save(aboutUs);
    }

    public List<AboutUs> getAllAboutUs() {
        return aboutUsRepository.findAll();
    }

    public Optional<AboutUs> findAboutUsById(String id){
        return aboutUsRepository.findById(id);
    }

    public AboutUs updateAboutUs(String id, AboutUs updatedAboutUs) {
        return aboutUsRepository.findById(id)
                .map(existing -> {
                    if (updatedAboutUs.getInfo() != null) {
                        existing.setInfo(updatedAboutUs.getInfo());
                    }
                    if (updatedAboutUs.getMission() != null) {
                        existing.setMission(updatedAboutUs.getMission());
                    }
                    if (updatedAboutUs.getValues() != null) {
                        existing.setValues(updatedAboutUs.getValues());
                    }
                    if (updatedAboutUs.getTeams() != null) {
                        existing.setTeams(updatedAboutUs.getTeams());
                    }
                    return aboutUsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("AboutUs nieznalezione."));
    }

    public void deleteAboutUsById(String id) {
        aboutUsRepository.deleteById(id);
    }
}
