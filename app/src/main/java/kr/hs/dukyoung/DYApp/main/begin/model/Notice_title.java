package kr.hs.dukyoung.DYApp.main.begin.model;

import java.io.Serializable;

public class Notice_title implements Serializable{
    String title;
    String day;

    public Notice_title(String title, String day){
        this.title = title;
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public String getDay() {
        return day;
    }
}
