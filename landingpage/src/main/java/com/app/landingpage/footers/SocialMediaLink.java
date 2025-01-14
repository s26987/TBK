package com.app.landingpage.footers;

public class SocialMediaLink {

    private String platform;
    private String url;

    public SocialMediaLink() {
    }

    public SocialMediaLink(String url, String platform) {
        this.url = url;
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
