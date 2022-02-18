package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicazionevera.model_and_adapter.MyData;
import com.example.applicazionevera.model_and_adapter.NotData;
import com.example.applicazionevera.model_and_adapter.NotViewAdapter;
import com.example.applicazionevera.model_and_adapter.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Notifiche extends AppCompatActivity {

    private ArrayList<NotData> notdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifiche);

        setArrayInfo();
        setData();





        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.toNotifications);

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
        notdata = new ArrayList<>();
        notdata.add(new NotData(R.drawable.duomo,"MISSCROFT98: Noooo amo non puoi capire, siamo tantisssimi"));
        notdata.add(new NotData(R.drawable.duomo,"Il tuo evento è in programma domani"));
        notdata.add(new NotData(R.drawable.duomo,"Settimana prossima concerto di Rosa Chemical"));
        notdata.add(new NotData(R.drawable.duomo,"Lorenzo Arecco a teatro, imperdibile"));
        notdata.add(new NotData(R.drawable.duomo,"MISSCROFT98: COSAAAA!?!? CR7 a Milano??"));
        notdata.add(new NotData(R.drawable.duomo,"MISSCROFT98: Sei un fake, devi stare muto"));
        notdata.add(new NotData(R.drawable.duomo,"MISSCROFT98: Deve essere frustrante"));
        notdata.add(new NotData(R.drawable.duomo,"MISSCROFT98: 5 €, 2 canne. Andata?"));

    }


    private void setData() {
        RecyclerView recyclerViewOK = (RecyclerView) findViewById(R.id.nrc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Notifiche.this);
        NotViewAdapter adapter = new NotViewAdapter(notdata);
        recyclerViewOK.setHasFixedSize(true);
        recyclerViewOK.setLayoutManager(new LinearLayoutManager(Notifiche.this));
        recyclerViewOK.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewOK.getContext(), layoutManager.getOrientation());
        recyclerViewOK.addItemDecoration(dividerItemDecoration);
        recyclerViewOK.setAdapter(adapter);
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