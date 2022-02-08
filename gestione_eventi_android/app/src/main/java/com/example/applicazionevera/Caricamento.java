package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;

public class Caricamento extends AppCompatActivity {


    int timeout = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caricamento);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                openLogin();
                finish();
            }
        }, timeout);
    }


    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}