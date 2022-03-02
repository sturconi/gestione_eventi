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

import com.example.applicazionevera.model_and_adapter.CommentData;
import com.example.applicazionevera.model_and_adapter.CommentDataAdapter;
import com.example.applicazionevera.model_and_adapter.MyData;
import com.example.applicazionevera.model_and_adapter.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SezioneCommenti extends AppCompatActivity {

    private ArrayList<CommentData> commentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sezione_commenti);


        setArrayInfo();
        setData();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
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
        commentData = new ArrayList<>();
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));
        commentData.add(new CommentData("ABBIAMO UN SOGNO NEL CUORE", "@Giangio","Matteo Romagnoni", R.drawable.duomo));

          }


    private void setData() {
        RecyclerView recyclerViewOKL = (RecyclerView) findViewById(R.id.rcomment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(SezioneCommenti.this);
        CommentDataAdapter adapter = new CommentDataAdapter(commentData);
        recyclerViewOKL.setHasFixedSize(true);
        recyclerViewOKL.setLayoutManager(new LinearLayoutManager(SezioneCommenti.this));
        recyclerViewOKL.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewOKL.getContext(), layoutManager.getOrientation());
        recyclerViewOKL.addItemDecoration(dividerItemDecoration);
        recyclerViewOKL.setAdapter(adapter);
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
