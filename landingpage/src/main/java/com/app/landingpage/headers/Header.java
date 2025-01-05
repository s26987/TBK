package com.app.landingpage.headers;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.util.List;

@Getter
@Setter
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
}
