package com.example.nino.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
    implements View.OnClickListener{
    private String GOOGLE_API_KEY = ""; 
    private String YOUTUBE_VIDEO_ID = "XiB4pqusHe0";
    private String YOUTUBE_PLAYLIST_ID = "PLx0sYbCqOb8TBPRdmBHs5Iftvv9TPboYG";
    private Button btnPlayVideo, btnPlayPlaylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayPlaylist = (Button) findViewById(R.id.btnPlayerList);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);

        btnPlayPlaylist.setOnClickListener(this);
        btnPlayVideo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayerList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST_ID);
                break;
            default:
        }

        if(intent != null) {
            startActivity(intent);
        }

    }
}
