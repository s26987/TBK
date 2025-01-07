package com.app.landingpage.herosections;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "hero-sections")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
