package kr.hs.dukyoung.DYApp.timetable.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONObject;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.timetable.adapter.TableAdapter;
import kr.hs.dukyoung.DYApp.timetable.model.TimeManager;

public class TimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        Intent thisIntent = getIntent();


        String jsonString = thisIntent.getStringExtra("jsonString");
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for(int i = 0; i < 7; i++) {
                for(int j = 0; j < 5; j++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(j);
                    String[] timetables = ((String) jsonObject.get("subject")).split("\\|");
//                    Log.i(j + ", " + i, j + ", " + i + " | " + timetables[i]);
                    TimeManager.getInstance().addInstance(i, j, timetables[i]);
                }
            }
        }
        catch(Exception e) {

        }




        TextView textView = findViewById(R.id.timetable_textview);
        textView.setText("시간표");
        GridView gridView = findViewById(R.id.timetable_grid_layout);
//        for(int i = 0; i < 7; i++) {
//            for(int j = 0; j < 5; j++) {
//                TimeManager.getInstance().addInstance(i, j, "(" + i + ", " + j + ")");
//            }
//        }
//        timeList.add(TimeManager.getInstance().addInstance(0,0, "정보", "ㅁㄴㅇㄹ"));
        gridView.setAdapter(new TableAdapter(this, R.layout.timetable_index, gridView));
    }
}