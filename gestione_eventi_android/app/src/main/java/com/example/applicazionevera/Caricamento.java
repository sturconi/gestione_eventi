package com.example.applicazionevera;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;


public class Caricamento extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caricamento);
        getSupportActionBar().hide();
/*
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
      //  audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);


        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.introguitar);
                    mediaPlayer.start();
                    sleep(2000);

                } catch (InterruptedException e) {

                } finally {

                    openLogin();
                }
            }
        };
        timer.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        finish();
    }

    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}