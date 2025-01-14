package com.app.landingpage.footers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooterService {

    public final FooterRepository footerRepository;

    @Autowired
    public FooterService(FooterRepository footerRepository) {
        this.footerRepository = footerRepository;
    }

    public List<Footer> getAllFooters() {
        return footerRepository.findAll();
    }

    public Optional<Footer> getFooterById(String id) {
        return footerRepository.findById(id);
    }

    public Footer addFooter(Footer footer) {
        return footerRepository.save(footer);
    }

    public Footer updateFooter(String id, Footer updatedFooter) {
        return footerRepository.findById(id)
                .map(existingFooter -> {

                    if (updatedFooter.getContactInfo() != null) {
                        ContactInfo updatedContactInfo = updatedFooter.getContactInfo();
                        ContactInfo existingContactInfo = existingFooter.getContactInfo();
                        if (existingContactInfo == null) {
                            existingFooter.setContactInfo(updatedContactInfo);
                        } else {
                            if (updatedContactInfo.getEmail() != null) {
                                existingContactInfo.setEmail(updatedContactInfo.getEmail());
                            }
                            if (updatedContactInfo.getPhone() != null) {
                                existingContactInfo.setPhone(updatedContactInfo.getPhone());
                            }
                            if (updatedContactInfo.getAddress() != null) {
                                existingContactInfo.setAddress(updatedContactInfo.getAddress());
                            }
                        }
                    }

                    if (updatedFooter.getLinks() != null) {
                        existingFooter.setLinks(updatedFooter.getLinks());
                    }

                    if (updatedFooter.getSocialMedia() != null) {
                        existingFooter.setSocialMedia(updatedFooter.getSocialMedia());
                    }

                    return footerRepository.save(existingFooter);
                })
                .orElseThrow(() -> new RuntimeException("Footer o id: " + id + " nie zostal znaleziony"));
    }

    public void deleteFooter(String id) {
        footerRepository.deleteById(id);
    }
}
