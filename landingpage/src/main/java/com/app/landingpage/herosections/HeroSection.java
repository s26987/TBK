package com.app.landingpage.herosections;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "heroSections")
public class HeroSection {
    @Id
    private String id;
    private String title;
    private String subtitle;
    private String image;

    public HeroSection() {
    }

    public HeroSection(String id, String title, String subtitle, String image) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
    }

}
