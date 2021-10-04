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



}
