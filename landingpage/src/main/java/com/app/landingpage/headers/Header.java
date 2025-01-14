package com.app.landingpage.headers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "headers")
public class Header {

    @Id
    private String id;
    private String logo;
    private String slogan;
    private List<MenuItem> menu;

    public Header() {
    }

    public Header(String id, String logo, String slogan, List<MenuItem> menu) {
        this.id = id;
        this.logo = logo;
        this.slogan = slogan;
        this.menu = menu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}
