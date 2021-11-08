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


    private final int view;
    private final LayoutInflater inflater;
    private final GridView gridView;

    private final String[] dates = {"", "월", "화", "수", "목", "금"};
    private final String[] classes = {"", "1교시", "2교시", "3교시", "4교시", "5교시", "6교시", "7교시"};

    public TableAdapter(Context context, int resource, GridView gridView) {
        //inflater를 생성하기 위해서 context 객체를 매개변수로 받음.
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //gridview 요소 하나하나에 들어갈 view를 지정해주는 변수
        this.view = resource;
        //gridview 객체
        this.gridView = gridView;
    }

    @Override
    public int getCount() {
        //총 gridview에 몇개의 뷰가 들어가는지 알려주는 메소드
        return 48;
    }

    @Override
    public Object getItem(int i) {
        //무시해도 되는 메소드
        return null;
    }

    @Override
    public long getItemId(int i) {
        //무시해도 되는 메소드
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //만약 gridview의 position번째의 영역에 view가 없을 경우에
        if(convertView == null) {

            //xml로 되어있는 view를 자바에서 쓸 수 있는 객체로 변환시켜주는 작업. 이때 view는 생성자에서 받는 view가 생성됨.
            convertView = inflater.inflate(view, null);
            //view의 높이, 넓이를 조정하는 곳. 만약 이 값을 바꾸고 싶다면 getCellWidthDP, getHeight 메소드들을 수정하면 바뀜.
            convertView.setLayoutParams(new GridView.LayoutParams(getCellWidthDP(), getHeight()));

            //Textview 객체 생성. 이때 textview 객체는 view 안에 있는 textview를 받아오므로 convertview에서 받아옴.
            TextView textView = convertView.findViewById(R.id.subject);
            //textview의 글자 정렬값을 가운데로 설정함
            textView.setGravity(Gravity.CENTER);

            //position값이 6보다 작다는것은 요일을 설정해야 하는 곳이라는 뜻
            if(position < 6) {
                textView.setText(dates[position]);
                return convertView;
            }
            //position값이 6으로 나눴을때 0으로 나누어 떨어진다는 것은 이 부분은 1교시 2교시를 표시해야하는 부분
            if(position % 6 == 0) {
                textView.setText(classes[(position / 6)]);
                return convertView;
            }

            //위에 모든 조건이 충족 안하면 시간표를 적어야 한다는 곳이어야 하는 뜻

            Time time = TimeManager.getInstance().getTime();
            //시간표 객체를 가져옴.
            if(time != null) {
                //만약 시간표 객체가 null이 아닐 경우에 textview의 메시지를 시간표로 설정함.
                textView.setText(time.getTitle());
            }

        }
        return convertView;
    }

    private int getCellWidthDP()
    {
        //gridview의 넓이를 구하고 넓이를 6으로 나눈 값을 반환. 이때 넓이 단위는 px
        int layoutWidth = gridView.getWidth();
//		int width = LayoutUtils.dpToPx(context, layoutWidth);

        return layoutWidth/6;
    }

    private int getHeight() {
        //gridview의 높이를 구하고 넓이를 8으로 나눈 값을 반환. 이때 넓이 단위는 px
        int layoutHeight = gridView.getHeight();
        return layoutHeight / 8;
    }

}
