package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class CreaEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_evento);

        String[] Categorie = new String[]{"Intrattenimento", "Servizi", "Cultura", "Sport"};
        ListView cat = (ListView) findViewById(R.id.Listcategorie);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreaEvento.this, android.R.layout.simple_list_item_1, Categorie);
        cat.setAdapter(adapter);

        Button button;
        button = (Button) findViewById(R.id.pagSucc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreaEvento.this, CreaEvento2.class);
                startActivity(intent);
            }
        });

        }



    public void openHome() {
        Intent HomeIntent = new Intent(this, Home.class);
        startActivity(HomeIntent);
    }
    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void openNotifications() {
        Intent intent = new Intent(this, Notifiche.class);
        startActivity(intent);
    }

    public void openSearch() {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }
}
