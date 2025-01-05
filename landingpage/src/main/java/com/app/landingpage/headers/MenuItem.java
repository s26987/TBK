package com.app.landingpage.headers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItem {
    //menuitem jako osobna klasa ze wzgledu na elastycznosc zarzadzania elementami
    private String name;
    private String url;

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
