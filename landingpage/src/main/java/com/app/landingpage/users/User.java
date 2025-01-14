package com.app.landingpage.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String email;
    private Map<String, String> preferences; //klucz->wartosc ???
    private Role role;

    public User() {
    }

    public User(String id, String email, Map<String, String> preferences, Role role) {
        this.id = id;
        this.email = email;
        this.preferences = preferences;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
