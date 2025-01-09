package com.app.landingpage.testimonials;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testimonials")
public class Testimonials {

    @Id
    private String id;
    private String opinions;

    public Testimonials() {
    }

    public Testimonials(String id, String opinions) {
        this.id = id;
        this.opinions = opinions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpinions() {
        return opinions;
    }

    public void setOpinions(String opinions) {
        this.opinions = opinions;
    }
}
