package com.app.landingpage.headers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeaderService {

    public final HeaderRepository headerRepository;

    @Autowired
    public HeaderService(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    public Header createHeader(Header header) {
        return headerRepository.save(header);
    }

    public List<Header> getAllHeaders() {
        return headerRepository.findAll();
    }

    public Optional<Header> getHeaderById(String id) {
        return headerRepository.findById(id);
    }

    public Header updateHeader(String id, Header updatedHeader) {
        return headerRepository.findById(id)
                .map(existing -> {
                    if (updatedHeader.getLogo() != null) {
                        existing.setLogo(updatedHeader.getLogo());
                    }
                    if (updatedHeader.getSlogan() != null) {
                        existing.setSlogan(updatedHeader.getSlogan());
                    }
                    if (updatedHeader.getMenu() != null) {
                        existing.setMenu(updatedHeader.getMenu());
                    }
                    return headerRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Header nieznaleziony."));
    }

    public void deleteHeader(String id) {
        headerRepository.deleteById(id);
    }
}
