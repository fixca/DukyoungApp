package kr.hs.dukyoung.DYApp.jaehoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.AnnouncementManager;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.view.AnnouncementActivity;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.view.ScheduleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final AnnouncementManager manager = AnnouncementManager.getInstance();
        int index = manager.addInstance("10월 학사운영 계획 안내",
                "10월 학사운영 계획 안내입니다.\n세부내용은 붙임파일을 참고하세요.",
                "김영은",
                "2021-09-29",
                true);
        manager.addLink(manager.getAnnouncementList().get(index), "2021년 10월 학생운영계획.xlsx (12.89KB)", "http://www.dukyoung.hs.kr/download/1240/menu/1210/300/1/2021%EB%85%84%2010%EC%9B%94%20%ED%95%99%EC%82%AC%EC%9A%B4%EC%98%81%EA%B3%84%ED%9A%8D.xlsx");
                //""
                //

        List<String> activityList = new ArrayList<>();
        activityList.add("announcement");
        activityList.add("schedule");

        ListView listView = findViewById(R.id.main_listview);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, activityList));
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (i) {
                case 0:
                    Intent intent = new Intent(getApplicationContext(), AnnouncementActivity.class);
                    intent.putExtra("linkable", manager.getAnnouncementList().get(index).isExternalFile());
                    intent.putExtra("index", index);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), ScheduleActivity.class);
                    startActivity(intent1);
                    break;
                default:
                    Toast.makeText(MainActivity.this, "Invalid Action!", Toast.LENGTH_LONG).show();
                    break;
            }
        });




//        finish();
    }
}