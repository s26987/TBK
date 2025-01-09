package com.app.landingpage.features;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "features")
public class Features {

    @Id
    private String id;
    private String features;
    private String benefits;

    public Features() {
    }

    public Features(String id, String features, String benefits) {
        this.id = id;
        this.features = features;
        this.benefits = benefits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
