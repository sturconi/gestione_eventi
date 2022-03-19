package com.example.applicazionevera;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.applicazionevera.model_and_adapter.ListLocationModel;
import com.example.applicazionevera.model_and_adapter.LocationModel;
import com.example.applicazionevera.retrofit.ApiClient;
import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LocationModel> mListMarker = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttarevia);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        getAllDataLocationLatLng();
    }


    private void getAllDataLocationLatLng(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Cercando gli eventi vicino a te ..");
        dialog.show();

        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<List<LocationModel>> call = apiService.getAllLocation();
        call.enqueue(new Callback<List<LocationModel>>() {
            @Override
            public void onResponse(Call<List<LocationModel>> call, Response<List<LocationModel>> response) {
                dialog.dismiss();
                mListMarker.addAll(response.body());
                initMarker(mListMarker);
            }

            @Override
            public void onFailure(Call<List<LocationModel>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }


    private void initMarker(List<LocationModel> listData){

        for (int i=0; i<mListMarker.size(); i++){

            LatLng location = new LatLng(Double.parseDouble(mListMarker.get(i).getLatitude()), Double.parseDouble(mListMarker.get(i).getLongitude()));

            mMap.addMarker(new MarkerOptions().position(location).title(mListMarker.get(i).getImageLocationName()));

            LatLng latLng = new LatLng(Double.parseDouble(mListMarker.get(0).getLatitude()), Double.parseDouble(mListMarker.get(0).getLongitude()));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 12));

        }
    }

    public static final String BASE_URL = "http://10.0.2.2:8080/";
    Gson gson= new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();





}