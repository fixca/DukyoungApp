package kr.hs.dukyoung.DYApp.main.begin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.main.begin.adapter.NoticeAdapter;
import kr.hs.dukyoung.DYApp.main.begin.model.Notice_title;
import kr.hs.dukyoung.DYApp.meal.view.SchoolMealActivity;
import kr.hs.dukyoung.DYApp.request.Request;
import kr.hs.dukyoung.DYApp.request.URLRequest;
import kr.hs.dukyoung.DYApp.schedule.view.ScheduleActivity;
import kr.hs.dukyoung.DYApp.timetable.view.TimeTableActivity;

public class MainBeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_begin);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH) + 1;

        ImageButton cafeteria_button = findViewById(R.id.cafeteria_button);
        ImageButton timetable_button = findViewById(R.id.timetable_button);
        ImageButton schedule_button = findViewById(R.id.schedule_button);

        Intent intent = getIntent();
        String grade = intent.getStringExtra("gradetext");
        String stuclass = intent.getStringExtra("stuclasstext");

        ListView Notice_list = (ListView)findViewById(R.id.Notice_list);
        ArrayList<Notice_title> NoticeList = new ArrayList<>();

        //공지사항 api 받아서 넣으면 됨
        NoticeList.add(new Notice_title("Tlqkf","2021.10.29"));
        NoticeList.add(new Notice_title("tlqkf","2021.10.29"));
        NoticeList.add(new Notice_title("tbqkf","2021.10.29"));
        NoticeList.add(new Notice_title("Tbqkf","2021.10.29"));
        NoticeList.add(new Notice_title("Tmqkf","2021.10.29"));
        NoticeList.add(new Notice_title("tmqkf","2021.10.29"));
        NoticeAdapter adapter = new NoticeAdapter(this, R.layout.notice_title_listview, NoticeList);
        Notice_list.setAdapter(adapter);

        TextView menuView = (TextView) findViewById(R.id.menuText);
        menuView.setText(grade+"학년 "+stuclass+"반 학생");


        //여기 아래 부분은 엑티비티 넘길 예정

        cafeteria_button.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), SchoolMealActivity.class);
            Request request = new Request(() -> {
                try {
                    URLRequest urlRequest = new URLRequest("http://117.123.207.101:8080/api/detailLunch?year=" + year + "&month=" + month);
                    String jsonString = urlRequest.sendRequest();
                    intent1.putExtra("jsonString", jsonString);
                    startActivity(intent1);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainBeginActivity.this, "서버 요청중 에러가 발생했습니다!\n인터넷 연결 상태를 확인해주시고 다시 실행해주세요!", Toast.LENGTH_LONG).show();
                }
            });
            request.execute();
        });
        timetable_button.setOnClickListener(view -> {

            //T0D0
            // 여기에 timetable 구현
            Intent intent12 = new Intent(getApplicationContext(), TimeTableActivity.class);
            intent.putExtra("grade",grade);
            intent.putExtra("stuclass",stuclass);
            startActivity(intent12);
        });
        schedule_button.setOnClickListener(view -> {
            Intent intent13 = new Intent(MainBeginActivity.this, ScheduleActivity.class);
            Request request = new Request(() -> {
                try {
                    URLRequest urlRequest = new URLRequest("http://117.123.207.101:8080/api/detailSchoolSchedule?year=" + year + "&month=" + month);
                    String jsonString = urlRequest.sendRequest();
                    intent13.putExtra("jsonString", jsonString);
                    startActivity(intent13);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainBeginActivity.this, "서버 요청중 에러가 발생했습니다!\n인터넷 연결 상태를 확인해주시고 다시 실행해주세요!", Toast.LENGTH_LONG).show();
                }
            });
            request.execute();

        });
//        Notice_button.setOnClickListener(view -> {
//            Intent intent13 = new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(intent13);
//        });
    }
}