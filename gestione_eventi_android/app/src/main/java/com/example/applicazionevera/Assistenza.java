package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Assistenza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistenza);

        Button button;
        button =(Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messaggio();
            }
        });
    }
    public void messaggio() {
        Toast.makeText(this, "Messaggio Inviato!", Toast.LENGTH_SHORT).show();
    }
}