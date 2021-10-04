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
}
