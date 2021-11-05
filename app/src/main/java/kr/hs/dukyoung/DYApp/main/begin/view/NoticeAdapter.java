package kr.hs.dukyoung.DYApp.main.begin.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.hs.dukyoung.DYApp.jaehoon.R;

public class NoticeAdapter extends ArrayAdapter {

    private int resourceLayout;
    private Context mContext;

    public NoticeAdapter(Context context, int resource, List<Notice_title> Notice_titles){
        super(context, resource, Notice_titles);
        this.resourceLayout = resource;
        this.mContext = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Notice_title N = (Notice_title) getItem(position);

        if (N != null) {
            TextView Notice_title_view = (TextView) v.findViewById(R.id.Notice_title);
            TextView Notice_day_view = (TextView) v.findViewById(R.id.Notice_day);

            if (Notice_title_view != null) {
                Notice_title_view.setText(N.title);
            }

            if (Notice_day_view != null) {
                Notice_day_view.setText(N.day);
            }
        }

        return v;
    }

}
