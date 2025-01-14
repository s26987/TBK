package com.app.landingpage.translations;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document(collection = "translations")
public class Translation {

    @Id
    private String id;
    private String key;
    private Map<String, String> translations; // mapa tlumaczen (jezyk->tekst)
    private Date createdAt;

    public Translation() {
    }

    public Translation(String id, String key, Map<String, String> translations, Date createdAt) {
        this.id = id;
        this.key = key;
        this.translations = translations;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<String, String> translations) {
        this.translations = translations;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
