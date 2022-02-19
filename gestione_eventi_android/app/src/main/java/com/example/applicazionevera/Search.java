package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.applicazionevera.model_and_adapter.EvCatData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private ArrayList<EvCatData> evcatData;
    GridView gridView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    setArrayInfo();
        gridView = findViewById(R.id.gridView);
        customAdapter = new CustomAdapter(evcatData, this);
        gridView.setAdapter(customAdapter);




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.toSearch);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toHome:
                        openHome();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.toSearch:
                        openSearch();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.toNotifications:
                        openNotifications();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.toSettings:
                        openSettings();
                        overridePendingTransition(0,0);
                        break;
                }
                return false;
            }
        });


    }

    private void setArrayInfo() {
        evcatData = new ArrayList<>();
        evcatData.add(new EvCatData(R.drawable.duomo,"Calcetto pazzo sgravato","Via Fiorella Mannoia","28 FEB 2002"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_music_note_24, "Concerto di Antonio Lezzi","Via delle esplosioni","14 NOV 2015"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
    }
public class CustomAdapter extends BaseAdapter{
    private ArrayList<EvCatData> evcatData;
    private Context context;

    public CustomAdapter(ArrayList<EvCatData> evcatData, Context context) {
        this.evcatData = evcatData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return evcatData.size();
    }

    @Override
    public Object getItem(int i) {
        return evcatData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        EvCatData evCatData = evcatData.get(i);

        if(view1==null){
            view1 = LayoutInflater.from(context).inflate(R.layout.row_items, viewGroup, false);
        }

        ImageView tvImage = view1.findViewById(R.id.immagineEvCat);
        TextView tvindirizzo = view1.findViewById(R.id.indirizzoEv);
        TextView tvtitolo = view1.findViewById(R.id.titoloEv);
        TextView tvdata = view1.findViewById(R.id.dataEv);

        String indirizzo = evCatData.getIndirizzo();
        String titolo = evCatData.getTitolo();
        String data = evCatData.getData();
        int image= evCatData.getImage();

        tvImage.setImageResource(image);
        tvindirizzo.setText(indirizzo);
        tvtitolo.setText(titolo);
        tvdata.setText(data);

        return view1;
    }
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



    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}