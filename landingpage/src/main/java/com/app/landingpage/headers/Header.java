package com.app.landingpage.headers;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "headers")
public class Header {

    @Id
    private String id;
    private String logo;
    private List<String> navigationLinks;
    private String slogan; //haslo fdirmowe
    private String callToActionButton; //signup itd

    public Header() {
    }

    public Header(String id, String logo, List<String> navigationLinks, String slogan, String callToActionButton) {
        this.id = id;
        this.logo = logo;
        this.navigationLinks = navigationLinks;
        this.slogan = slogan;
        this.callToActionButton = callToActionButton;
    }
}
