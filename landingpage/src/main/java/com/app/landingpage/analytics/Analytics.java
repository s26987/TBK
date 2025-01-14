package com.app.landingpage.analytics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "analytics")
public class Analytics {

    @Id
    private String id;
    private Long totalVisits;
    private Long conversionCount; //zapisy do newslettera itd

    public Analytics() {
    }

    public Analytics(String id, Long totalVisits, Long conversionCount) {
        this.id = id;
        this.totalVisits = totalVisits;
        this.conversionCount = conversionCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Long totalVisits) {
        this.totalVisits = totalVisits;
    }

    public Long getConversionCount() {
        return conversionCount;
    }

    public void setConversionCount(Long conversionCount) {
        this.conversionCount = conversionCount;
    }
}
