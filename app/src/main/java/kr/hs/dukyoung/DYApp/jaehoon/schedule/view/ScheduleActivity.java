package kr.hs.dukyoung.DYApp.jaehoon.schedule.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import kr.hs.dukyoung.DYApp.jaehoon.R;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);

        CalendarView calendarView = findViewById(R.id.schedule_calendar_view);
        calendarView.setDate(System.currentTimeMillis());
    }
}