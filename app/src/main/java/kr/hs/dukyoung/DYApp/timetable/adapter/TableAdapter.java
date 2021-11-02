package kr.hs.dukyoung.DYApp.timetable.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.timetable.model.Time;
import kr.hs.dukyoung.DYApp.timetable.model.TimeManager;

public class TableAdapter extends BaseAdapter {

    private final Context context;
    private final int view;
    private final LayoutInflater inflater;
    private final GridView gridView;

    private final String[] dates = {"", "월", "화", "수", "목", "금"};
    private final String[] classes = {"", "1교시", "2교시", "3교시", "4교시", "5교시", "6교시", "7교시"};

    public TableAdapter(Context context, int resource, GridView gridView) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.view = resource;
        this.gridView = gridView;
    }

    @Override
    public int getCount() {
        return 48;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(view, null);
            convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP(), getHeight()));

            TextView textView = convertView.findViewById(R.id.subject);
            textView.setGravity(Gravity.CENTER);

            if(position < 6) {
                textView.setText(dates[position]);
                return convertView;
            }
            if(position % 6 == 0) {
                textView.setText(classes[(position / 6)]);
                return convertView;
            }

            Time time = TimeManager.getInstance().getTime();
            textView.setText(time.getTitle());
        }
        return convertView;
    }

    private int getCellWidthDP()
    {
        int layoutWidth = gridView.getWidth();
//		int width = LayoutUtils.dpToPx(context, layoutWidth);

        return layoutWidth/6;
    }

    private int getHeight() {
        int layoutHeight = gridView.getHeight();
        return layoutHeight / 8;
    }

}
