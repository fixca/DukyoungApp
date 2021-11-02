package kr.hs.dukyoung.DYApp.jaehoon.schedule.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.adapter.CalendarAdapter;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.model.calender.DayInfo;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.model.schedule.Schedule;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.model.schedule.ScheduleManager;
import kr.hs.dukyoung.DYApp.jaehoon.utils.LayoutUtils;

public class ScheduleActivity extends AppCompatActivity implements OnClickListener, OnItemClickListener {

    public static int SUNDAY = 1;
    public static int MONDAY = 2;
    public static int TUESDAY = 3;
    public static int WEDNSESDAY = 4;
    public static int THURSDAY = 5;
    public static int FRIDAY = 6;
    public static int SATURDAY = 7;

    private TextView mTvCalendarTitle;
    private GridView mGvCalendar;

    private ArrayList<DayInfo> mDayList;
    private CalendarAdapter mCalendarAdapter;

    Calendar mLastMonthCalendar;
    Calendar mThisMonthCalendar;
    Calendar mNextMonthCalendar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);

        Button bLastMonth = (Button)findViewById(R.id.gv_calendar_activity_b_last);
        Button bNextMonth = (Button)findViewById(R.id.gv_calendar_activity_b_next);

        mTvCalendarTitle = (TextView)findViewById(R.id.gv_calendar_activity_tv_title);
        mGvCalendar = (GridView)findViewById(R.id.gv_calendar_activity_gv_calendar);


        bLastMonth.setOnClickListener(this);
        bNextMonth.setOnClickListener(this);
        mGvCalendar.setOnItemClickListener(this);

        mDayList = new ArrayList<>();
    }


    @Override
    protected void onResume()
    {
        try {
            super.onResume();
            Intent intent = getIntent();
            String jsonString = intent.getExtras().getString("jsonString");
            JSONArray jsonArray = new JSONArray(jsonString);
            for(int i = 0; i < jsonArray.length(); i++) {
                StringBuilder sb = new StringBuilder();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                JSONArray array = new JSONArray((String) jsonObject.get("eventName"));
                for(int j = 0; j < array.length(); j++) {
                    sb.append(array.get(j) + "\n");
                }
                ScheduleManager.getInstance().addInstance(Integer.parseInt((String) jsonObject.get("month")), Integer.parseInt((String) jsonObject.get("day")), sb.toString().trim());
            }
            mThisMonthCalendar = Calendar.getInstance();
            mThisMonthCalendar.set(Calendar.DAY_OF_MONTH, 1);
            getCalendar(mThisMonthCalendar);
        }
        catch(Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "오류가 발생했습니다!\n인터넷 상태를 재확인 해주신 다음, 앱을 다시 실행해주세요!", Toast.LENGTH_LONG).show();
        }
    }

    private void getCalendar(Calendar calendar)
    {
        int lastMonthStartDay;
        int dayOfMonth;
        int thisMonthLastDay;

        mDayList.clear();

        dayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
        thisMonthLastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, -1);
        Log.e("지난달 마지막", calendar.get(Calendar.DAY_OF_MONTH)+"");

        lastMonthStartDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, 1);
        Log.e("이번달 시작", calendar.get(Calendar.DAY_OF_MONTH)+"");

        if(dayOfMonth == SUNDAY)
        {
            dayOfMonth += 7;
        }

        lastMonthStartDay -= (dayOfMonth-1)-1;


        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "월");

        DayInfo day;

        Log.e("DayOfMOnth", dayOfMonth+"");

        for(int i=0; i<dayOfMonth-1; i++)
        {
            int date = lastMonthStartDay+i;
            day = new DayInfo();
            day.setDay(Integer.toString(date));
            day.setInMonth(false);

            mDayList.add(day);
        }
        for(int i=1; i <= thisMonthLastDay; i++)
        {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(true);

            mDayList.add(day);
        }
        for(int i=1; i<42-(thisMonthLastDay+dayOfMonth-1)+1; i++)
        {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(false);
            mDayList.add(day);
        }

        initCalendarAdapter();
    }


    private Calendar getLastMonth(Calendar calendar)
    {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, -1);
        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        return calendar;
    }


    private Calendar getNextMonth(Calendar calendar)
    {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.add(Calendar.MONTH, +1);
        mTvCalendarTitle.setText(mThisMonthCalendar.get(Calendar.YEAR) + "년 "
                + (mThisMonthCalendar.get(Calendar.MONTH) + 1) + "월");
        return calendar;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long arg3)
    {
        DayInfo day = (DayInfo) mCalendarAdapter.getItem(position);
        Schedule schedule = ScheduleManager.getInstance().getScheduleByDay(Integer.parseInt(day.getDay()));
        if(schedule == null) {
            Toast.makeText(this, "일정이 없네잉", Toast.LENGTH_LONG).show();
        }
        else {
            if(schedule.getMonth() != mThisMonthCalendar.get(Calendar.MONTH) + 1) {
                Toast.makeText(this, "일정이 없네잉", Toast.LENGTH_LONG).show();
            }
            else {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                PopupWindow window = new PopupWindow(inflater.inflate(R.layout.schedule_popup, null, false), LayoutUtils.dpToPx(ScheduleActivity.this, 313), LayoutUtils.dpToPx(ScheduleActivity.this, 286), true);
                TextView textView = window.getContentView().findViewById(R.id.schedule_popup_textview);
                textView.setText(schedule.getSchedule());
                window.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                window.showAtLocation(findViewById(R.id.activity_schedule), Gravity.CENTER, 0, 0);
//                Toast.makeText(this, schedule.getSchedule(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.gv_calendar_activity_b_last:
                mThisMonthCalendar = getLastMonth(mThisMonthCalendar);
                getCalendar(mThisMonthCalendar);
                break;
            case R.id.gv_calendar_activity_b_next:
                mThisMonthCalendar = getNextMonth(mThisMonthCalendar);
                getCalendar(mThisMonthCalendar);
                break;
        }
    }


    private void initCalendarAdapter()
    {
        mCalendarAdapter = new CalendarAdapter(this, R.layout.day, mDayList, mThisMonthCalendar.get(Calendar.MONTH) + 1);
        mGvCalendar.setAdapter(mCalendarAdapter);
    }
}