package com.app.landingpage.personalizations;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "personalizations")
public class Personalization {

    @Id
    private String id;
    private Map<String, String> preferences;

    public Personalization() {
    }

    public Personalization(String id, Map<String, String> preferences) {
        this.id = id;
        this.preferences = preferences;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }
}
