package com.app.landingpage.galleries;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "galleries")
public class Gallery {

    @Id
    private String id;
    private String name;
    private String description;
    private List<Project> projects;

    public Gallery() {
    }

    public Gallery(String id, String name, String description, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projects = projects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
