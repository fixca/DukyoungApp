package kr.hs.dukyoung.DYApp.jaehoon.announcement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Announcement implements Serializable {
    private String title;
    private boolean externalFile;
    private String description;
    private String creator;
    private String createdTime;

    private List<Link> links;

    public Announcement(String title, String description, String creator, String createdTime, boolean externalFile) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.createdTime = createdTime;
        this.externalFile = externalFile;

        if(externalFile) {
            links = new ArrayList<>();
        }
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public boolean isExternalFile() {
        return externalFile;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setExternalFile(boolean externalFile) {
        this.externalFile = externalFile;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


