package com.app.landingpage.aboutus;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aboutus")
public class AboutUs {

    @Id
    private String id;
    private String info;
    private String mission;
    private String values;
    private String teams;

    public AboutUs() {
    }

    public AboutUs(String id, String info, String mission, String values, String teams) {
        this.id = id;
        this.info = info;
        this.mission = mission;
        this.values = values;
        this.teams = teams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }
}
