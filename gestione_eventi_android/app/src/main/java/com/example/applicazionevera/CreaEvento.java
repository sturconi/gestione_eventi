package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CreaEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_evento);

        String[] Categorie = new String[]{"Intrattenimento", "Servizi", "Cultura", "Sport"};
        ListView cat= (ListView) findViewById(R.id.Listcategorie);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(CreaEvento.this,android.R.layout.simple_list_item_1,Categorie);
        cat.setAdapter(adapter);


    }

}