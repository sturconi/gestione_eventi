package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.applicazionevera.model_and_adapter.EvCatData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Search extends AppCompatActivity {

    private List<EvCatData> evcatData;
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






        //filter
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this, FilterActivity.class);
            startActivityForResult(intent,104);

        });








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


    //filter
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==104)
        {
            TextView textView = findViewById(R.id.tvprova);
            textView.setText(data.getStringExtra("data"));

        }

    }


    private void setArrayInfo() {
        evcatData = new ArrayList<>();
        evcatData.add(new EvCatData(R.drawable.duomo,"Calcetto pazzo sgravato","Via Fiorella Mannoia","28 FEB 2002"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_music_note_24, "Concerto di Antonio Giuseppe","Via delle esplosioni","14 NOV 2015"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchview, menu);

        MenuItem menuItem = menu.findItem(R.id.searchview);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                customAdapter.getFilter().filter(s);
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {
    private List<EvCatData> evcatData;
    private List<EvCatData> evcatDatafiltered;
    private Context context;

        public CustomAdapter(List<EvCatData> evcatData,  Context context) {
            this.evcatData = evcatData;
            this.evcatDatafiltered = evcatData;
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


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search.this, EventoDettagliato.class));
            }
        });

        return view1;
    }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults = new FilterResults();

                    if(charSequence == null || charSequence.length()==0){

                        filterResults.count= evcatDatafiltered.size();
                        filterResults.values = evcatDatafiltered;

                    }else{
                        String searchChr = charSequence.toString().toLowerCase();
                        ArrayList<EvCatData> searchresult = new ArrayList<>();

                        for(EvCatData evCatData:evcatDatafiltered){
                            if(evCatData.getData().toLowerCase().contains(searchChr)|| evCatData.getIndirizzo().toLowerCase().contains(searchChr) ||  evCatData.getTitolo().toLowerCase().contains(searchChr)){
                                searchresult.add(evCatData);
                            }
                        }

                        filterResults.count = searchresult.size();
                        filterResults.values = searchresult;
                    }


                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                    evcatData = (List<EvCatData>) filterResults.values;
                    notifyDataSetChanged();


                }
            };

            return filter;
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





}