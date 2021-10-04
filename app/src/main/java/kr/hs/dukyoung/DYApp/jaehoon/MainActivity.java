package kr.hs.dukyoung.DYApp.jaehoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import kr.hs.dukyoung.DYApp.jaehoon.announcement.AnnouncementActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), AnnouncementActivity.class);
        startActivity(intent);

//        finish();
    }
}