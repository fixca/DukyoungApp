package kr.hs.dukyoung.DYApp.main.begin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import kr.hs.dukyoung.DYApp.MainActivity;
import kr.hs.dukyoung.DYApp.jaehoon.R;

public class MainBeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_begin);

        Button cafeteria_button = findViewById(R.id.cafeteria_button);
        Button timetable_button = findViewById(R.id.timetable_button);
        Button Notice_button = findViewById(R.id.Notice_button);

        Intent intent = getIntent();

        //String student_Num = intent.getStringExtra("studentNum");
        //int student = Integer.parseInt(student_Num);

        String grade = intent.getStringExtra("gradetext");
        String stuclass = intent.getStringExtra("stuclasstext");

        //int grade = intent.getIntExtra("gratetext",0);

        TextView menuView = (TextView) findViewById(R.id.menuText);
        menuView.setText(grade+"학년"+stuclass+"반 학생");

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