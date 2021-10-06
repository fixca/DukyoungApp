package kr.hs.dukyoung.DYApp.jaehoon.announcement.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import kr.hs.dukyoung.DYApp.jaehoon.R;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.Announcement;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.AnnouncementManager;
import kr.hs.dukyoung.DYApp.jaehoon.announcement.model.Link;

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

        TextView information = findViewById(R.id.announce_information);
        information.setText("작성일 : " + announcement.getCreatedTime() + "\n작성자 : " + announcement.getCreator());

        TextView description = findViewById(R.id.announce_description);
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 100; i++) {
//            sb.append("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
//        }
        description.setText(announcement.getDescription());




        if(linkAble) {
            fab.setOnClickListener(view -> {
                ListPopupWindow listPopupWindow = new ListPopupWindow(AnnouncementActivity.this);
                listPopupWindow.setWidth(1300);
                listPopupWindow.setHeight(800);
                listPopupWindow.setAdapter(new ArrayAdapter<>(AnnouncementActivity.this, android.R.layout.simple_list_item_1, announcement.getLinksTitle()));
                listPopupWindow.setModal(true);
                listPopupWindow.setAnchorView(fab);
                listPopupWindow.setOnItemClickListener((adapterView, view1, i, l) ->  {
                    String link = announcement.getLinks().get(i).getUrl();
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(browser);
                });
                listPopupWindow.show();
            });
        }
        else {
            fab.hide();
        }
    }
}