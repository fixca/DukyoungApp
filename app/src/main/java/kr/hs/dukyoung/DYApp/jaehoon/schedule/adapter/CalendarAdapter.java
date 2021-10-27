package kr.hs.dukyoung.DYApp.jaehoon.schedule.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.model.calender.DayInfo;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.model.schedule.Schedule;
import kr.hs.dukyoung.DYApp.jaehoon.schedule.model.schedule.ScheduleManager;

public class CalendarAdapter extends BaseAdapter
{

    private ArrayList<DayInfo> mDayList;
    private Context mContext;
    private int mResource;
    private LayoutInflater mLiInflater;
    private int height;
    private int month;


    public CalendarAdapter(Context context, int textResource, ArrayList<DayInfo> dayList, int month)
    {
        this.month = month;
        this.mContext = context;
        this.mDayList = dayList;
        this.mResource = textResource;
        this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.height = dpToPx(109);
    }

    public int dpToPx(int dp) {
        float density = mContext.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }


    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return mDayList.size();
    }


    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return mDayList.get(position);
    }


    @Override
    public long getItemId(int position)
    {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        DayInfo day = mDayList.get(position);
        Schedule schedule = ScheduleManager.getInstance().getScheduleByDay(Integer.parseInt(day.getDay()));

        DayViewHolde dayViewHolder;

        if(convertView == null)
        {
            convertView = mLiInflater.inflate(mResource, null);

            if(position % 7 == 6)
            {
                convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP()+getRestCellWidthDP(), this.height));
            }
            else
            {
                convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP(), this.height));
            }


            dayViewHolder = new DayViewHolde();

            dayViewHolder.llBackground = (LinearLayout)convertView.findViewById(R.id.day_cell_ll_background);
            dayViewHolder.tvDay = (TextView) convertView.findViewById(R.id.day_cell_tv_day);
            dayViewHolder.schedule = (TextView) convertView.findViewById(R.id.day_schedule);

            convertView.setTag(dayViewHolder);
        }
        else
        {
            dayViewHolder = (DayViewHolde) convertView.getTag();
        }

        if(day != null)
        {
            dayViewHolder.tvDay.setText(day.getDay());

            if(day.isInMonth())
            {
                if(position % 7 == 0)
                {
                    dayViewHolder.tvDay.setTextColor(Color.RED);
                }
                else if(position % 7 == 6)
                {
                    dayViewHolder.tvDay.setTextColor(Color.BLUE);
                }
                else
                {
                    dayViewHolder.tvDay.setTextColor(Color.BLACK);
                }

                if(schedule != null) {
                    if(schedule.getMonth() == month) {
                        dayViewHolder.schedule.setText(schedule.getSchedule());
                    }
                    else {
                        dayViewHolder.schedule.setText("일정이 없네잉");
                    }
                }
                else {
                    dayViewHolder.schedule.setText("일정이 없네잉");
                }
            }
            else
            {
                dayViewHolder.tvDay.setTextColor(Color.GRAY);
            }

        }

        return convertView;
    }

    public class DayViewHolde
    {
        public LinearLayout llBackground;
        public TextView tvDay;
        public TextView schedule;
    }

    private int getCellWidthDP()
    {
//		int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int cellWidth = 1024/7;

        return cellWidth;
    }

    private int getRestCellWidthDP()
    {
//		int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int cellWidth = 1024%7;

        return cellWidth;
    }

    private int getCellHeightDP()
    {
        int cellHeight = 1700/6;

        return cellHeight;
    }

}
