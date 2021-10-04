package kr.hs.dukyoung.DYApp.jaehoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.AnnouncementManager;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.view.AnnouncementActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final AnnouncementManager manager = AnnouncementManager.getInstance();
        manager.addInstance("10월 학사운영 계획 안내",
                "10월 학사운영 계획 안내입니다.\n세부내용은 붙임파일을 참고하세요.",
                "김영은",
                "2021-09-29",
                true);
        manager.addLink(manager.getAnnouncementList().get(0), "2021년 10월 학생운영계획.xlsx (12.89KB)", "http://www.dukyoung.hs.kr/download/1240/menu/1210/300/1/2021%EB%85%84%2010%EC%9B%94%20%ED%95%99%EC%82%AC%EC%9A%B4%EC%98%81%EA%B3%84%ED%9A%8D.xlsx");
                //""
                //


        Intent intent = new Intent(getApplicationContext(), AnnouncementActivity.class);
        intent.putExtra("linkable", true);
        intent.putExtra("index", 0);
        startActivity(intent);

//        finish();
    }
}