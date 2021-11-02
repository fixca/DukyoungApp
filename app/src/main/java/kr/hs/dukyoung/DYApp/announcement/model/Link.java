package kr.hs.dukyoung.DYApp.announcement.model;

import java.io.Serializable;

public class Link implements Serializable {
    private String name;
    private String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }
}
