package kr.hs.dukyoung.DYApp.jaehoon.announcement;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.AnnouncementManager;

public class AnnouncementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final AnnouncementManager manager = AnnouncementManager.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(manager.getAnnouncementList().isEmpty()) {
                    Snackbar.make(view, "첨부파일이 없습니다!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {

                }
            }
        });
    }
}