package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreaEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_evento);




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toHome:
                        openHome();
                        break;
                    case R.id.toSearch:
                        openSearch();
                        break;
                    case R.id.toNotifications:
                        openNotifications();
                        break;
                    case R.id.toSettings:
                        openSettings();
                        break;
                }
                return false;
            }
        });

        String[] Categorie = new String[]{"Intrattenimento", "Servizi", "Cultura", "Sport"};
        ListView cat = (ListView) findViewById(R.id.Listcategorie);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreaEvento.this, android.R.layout.simple_list_item_1, Categorie);
        cat.setAdapter(adapter);

        ImageButton ib;
        Button button;
        button = (Button) findViewById(R.id.pagSucc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPagSucc();
            }
        });

}

    public void openPagSucc() {
        Intent intent = new Intent(this, CreaEvento2.class);
        startActivity(intent);
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
