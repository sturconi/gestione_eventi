package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Preferenze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenze);
        Toast.makeText(this, "preferenze", Toast.LENGTH_SHORT).show();
        Switch SwitchSpo = (Switch) findViewById(R.id.switchSport);
        Switch SwitchInt = (Switch) findViewById(R.id.switchIntr);
        Switch SwitchCul = (Switch) findViewById(R.id.switchCultura);
        Switch SwitchServ = (Switch) findViewById(R.id.switchServizi);


        SwitchSpo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchSpo.isChecked() == true) {
                    Toast.makeText(Preferenze.this, "Sport Attivato!", Toast.LENGTH_LONG).show();
                    SwitchSpo.setTextColor(Color.GREEN);
                } else {
                    SwitchSpo.setTextColor(Color.RED);
                    Toast.makeText(Preferenze.this, "Sport Disattivato!", Toast.LENGTH_LONG).show();
                }
            }
        });

        SwitchInt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchInt.isChecked() == true) {
                    Toast.makeText(Preferenze.this, "Intrattenimento Attivato!", Toast.LENGTH_LONG).show();
                    SwitchInt.setTextColor(Color.GREEN);
                } else {
                    SwitchInt.setTextColor(Color.RED);
                    Toast.makeText(Preferenze.this, "Intrattenimento Disattivato!", Toast.LENGTH_LONG).show();
                }
            }
        });

        SwitchCul.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchCul.isChecked() == true) {
                    Toast.makeText(Preferenze.this, "Cultura Attivato!", Toast.LENGTH_LONG).show();
                    SwitchCul.setTextColor(Color.GREEN);
                } else {
                    SwitchCul.setTextColor(Color.RED);
                    Toast.makeText(Preferenze.this, "Cultura Disattivato!", Toast.LENGTH_LONG).show();
                }
            }
        });

        SwitchServ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchServ.isChecked() == true) {
                    Toast.makeText(Preferenze.this, "Servizi Attivato!", Toast.LENGTH_LONG).show();
                    SwitchServ.setTextColor(Color.GREEN);
                } else {
                    SwitchServ.setTextColor(Color.RED);
                    Toast.makeText(Preferenze.this, "Servizi Disattivato!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}