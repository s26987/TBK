package com.app.landingpage.contactforms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "contactforms")
public class ContactForms {

    @Id
    private String id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private Enum status;
    private LocalDate date;

    public ContactForms() {
    }

    public ContactForms(String id, String email, String name, String subject, String message, LocalDate date, Enum status) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.date = date;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
