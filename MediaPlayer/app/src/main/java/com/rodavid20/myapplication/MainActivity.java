package com.rodavid20.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(this, R.raw.sample);
            mediaPlayer.start(); // no need to call prepare(); create() does that for you
        });
        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(v -> {
            if(mediaPlayer != null) {
                mediaPlayer.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}