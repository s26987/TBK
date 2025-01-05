package com.app.landingpage.headers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {

    public final HeaderRepository headerRepository;

    @Autowired
    public HeaderService(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }
}
