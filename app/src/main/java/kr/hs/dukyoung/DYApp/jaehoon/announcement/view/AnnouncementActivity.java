package kr.hs.dukyoung.DYApp.jaehoon.announcement.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.Announcement;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.AnnouncementManager;

public class AnnouncementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent thisIntent = getIntent();
        int index = thisIntent.getExtras().getInt("index");
        boolean linkAble = thisIntent.getExtras().getBoolean("linkable");

        final AnnouncementManager manager = AnnouncementManager.getInstance();
        FloatingActionButton fab = findViewById(R.id.fab);
        Announcement announcement = manager.getAnnouncementList().get(index);

        TextView title = findViewById(R.id.announce_title);
        title.setText(announcement.getTitle());





        if(linkAble) {
            fab.setOnClickListener(view -> {
//                if(manager.getAnnouncementList().isEmpty()) {
//                    Snackbar.make(view, "첨부파일이 없습니다!", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//                else {
//
//                }
                String linkName = announcement.getLinks().get(0).getName();
                String link = announcement.getLinks().get(0).getUrl();
                Snackbar.make(view, "팝업을 띄워야함", Snackbar.LENGTH_LONG).setAction("Action", view1 -> {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(browser);
                }).show();
            });
        }
        else {
            fab.hide();
        }
    }
}