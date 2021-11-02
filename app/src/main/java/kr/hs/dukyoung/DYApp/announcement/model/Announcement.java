package kr.hs.dukyoung.DYApp.announcement.model;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        return this.title;
    }

    public int addLink(Link link) {
        links.add(link);
        return links.size() - 1;
    }

    public List<Link> getLinks() {
        return links;
    }

    public List<String> getLinksTitle() {
        List<String> list = new ArrayList<>();
        for(Link link : links) {
            list.add(link.getName());
        }
        return list;
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


