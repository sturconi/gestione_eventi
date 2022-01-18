package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Settings<button> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ToggleButton ToggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        Button button;
        button = (Button) findViewById(R.id.Preferenze);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPreferenza();
            }
        });

        button = (Button) findViewById(R.id.Notifiche);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotifiche();
            }
        });

        button = (Button) findViewById(R.id.Account);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccount();
            }
        });

        button = (Button) findViewById(R.id.Assistenza);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAssistenza();
            }
        });

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrivacy();
            }
        });

        ToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ToggleButton.isChecked() == true) {
                    Toast.makeText(Settings.this, "Notifchie Attivate!", Toast.LENGTH_LONG).show();
                    ToggleButton.setTextColor(Color.GREEN);
                } else {
                    ToggleButton.setTextColor(Color.RED);
                    Toast.makeText(Settings.this, "Notifchie Disattivate!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openPreferenza() {
        Intent intent = new Intent(this, Preferenze.class);
        startActivity(intent);
    }
    public void openNotifiche() {
        Intent intent = new Intent(this, Notifiche.class);
        startActivity(intent);
    }
    public void openAccount() {
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
    }
    public void openAssistenza() {
        Intent intent = new Intent(this, Assistenza.class);
        startActivity(intent);
    }
    public void openPrivacy() {
        Intent intent = new Intent(this, Privacy.class);
        startActivity(intent);
    }

}