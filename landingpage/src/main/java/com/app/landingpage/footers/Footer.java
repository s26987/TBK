package com.app.landingpage.footers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "footers")
public class Footer {

    @Id
    private String id;
    private ContactInfo contactInfo;
    private List<Link> links;
    private List<SocialMediaLink> socialMedia;

    public Footer() {
    }

    public Footer(String id, ContactInfo contactInfo, List<Link> links, List<SocialMediaLink> socialMedia) {
        this.id = id;
        this.contactInfo = contactInfo;
        this.links = links;
        this.socialMedia = socialMedia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<SocialMediaLink> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(List<SocialMediaLink> socialMedia) {
        this.socialMedia = socialMedia;
    }
}
