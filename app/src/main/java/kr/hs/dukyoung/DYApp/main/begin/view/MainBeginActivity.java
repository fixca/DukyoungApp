package kr.hs.dukyoung.DYApp.main.begin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dukyoung.DYApp.MainActivity;
import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.request.IDoInBackground;
import kr.hs.dukyoung.DYApp.request.Request;
import kr.hs.dukyoung.DYApp.request.URLRequest;
import kr.hs.dukyoung.DYApp.schedule.adapter.CalendarAdapter;
import kr.hs.dukyoung.DYApp.timetable.view.TimeTableActivity;

public class MainBeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_begin);

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

        Request request = new Request(new IDoInBackground() {
            @Override
            public void doInBackground() {
                try {
                    URLRequest urlRequest = new URLRequest("https://dukyoung.hs.kr/board.list?mcode=1210");
                    String html = urlRequest.sendRequest();
                    Log.i("html",html);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        request.execute();

        //여기 아래 부분은 엑티비티 넘길 예정

//        cafeteria_button.setOnClickListener(view -> {
//            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent1);
//        });
//        timetable_button.setOnClickListener(view -> {
//            Intent intent12 = new Intent(getApplicationContext(),MainActivity.class);
//            intent.putExtra("grade",grade);
//            intent.putExtra("stuclass",stuclass);
//            startActivity(intent12);
//        });
//        Notice_button.setOnClickListener(view -> {
//            Intent intent13 = new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(intent13);
//        });
    }
}