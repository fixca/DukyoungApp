package kr.hs.dukyoung.DYApp.main.begin.view;

import java.io.Serializable;

class Notice_title implements Serializable{
    String title;
    String day;

    public Notice_title(String title, String day){
        this.title = title;
        this.day = day;
    }
}
