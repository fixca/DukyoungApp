package kr.hs.dukyoung.DYApp.jaehoon.announcement.model;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementManager {

    private static AnnouncementManager instance = null;

    private List<Announcement> announcementList;

    public static AnnouncementManager getInstance() {
        if(instance == null) {
            instance = new AnnouncementManager();
        }
        return instance;
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public AnnouncementManager() {
        announcementList = new ArrayList<>();
    }

    public void addInstance(String title, String description, String creator, String createdTime, boolean externalFile) {
        announcementList.add(new Announcement(title, description, creator, createdTime, externalFile));
    }

    public void addLink(Announcement announcement, String name, String link) {
        announcement.addLink(new Link(name, link));
    }
}
