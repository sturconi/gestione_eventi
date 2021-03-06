package com.example.applicazionevera;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applicazionevera.model_and_adapter.PlaceAutoSuggestAdapter;
import com.example.applicazionevera.retrofit.Event;
import com.example.applicazionevera.retrofit.EventoUtente;
import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.google.android.gms.maps.model.LatLng;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreaEvento extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    TextView timer;
    int thour, tminute;
    private Button dateButton;
    TimePickerDialog timePickerDialog;
    private EditText nomeevento, luogo, descrizioneEvento;
    Button data_evento, button;
    private Event eve;
    private int numero_evento, ID_posto;
    Object item;
    int statusCode;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;
    DatePickerDialog datePickerDialog;
    private ImageView imageView;
    Date data=null;
    int idu;
    EventoUtente eu;
    private int PICK_IMAGE_REQUEST = 1;
    private Uri filepath;
    private Bitmap bitmap;
    String tv,nnev;
    List<Event> eventonome;
    int idevv=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_evento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initDatePicker();
        nomeEvento();
        idu=getIntent().getExtras().getInt("idutente");
        final AutoCompleteTextView autoCompleteTextView=findViewById(R.id.autoComplete);
        autoCompleteTextView.setAdapter(new PlaceAutoSuggestAdapter(CreaEvento.this,android.R.layout.simple_list_item_1));

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Address : ",autoCompleteTextView.getText().toString());
                LatLng latLng=getLatLngFromAddress(autoCompleteTextView.getText().toString());
                if(latLng!=null) {
                    Log.d("Lat Lng : ", " " + latLng.latitude + " " + latLng.longitude);
                    Address address=getAddressFromLatLng(latLng);
                    if(address!=null) {
                        Log.d("Address : ", "" + address.toString());
                        Log.d("Address Line : ",""+address.getAddressLine(0));
                        Log.d("Phone : ",""+address.getPhone());
                        Log.d("Pin Code : ",""+address.getPostalCode());
                        Log.d("Feature : ",""+address.getFeatureName());
                        Log.d("More : ",""+address.getLocality());
                    }
                    else {
                        Log.d("Address","Address Not Found");
                    }
                }
                else {
                    Log.d("Lat Lng","Lat Lng Not Found");
                }

            }
        });
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.CategorieArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(this);

        timer = findViewById(R.id.timerPicker);
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(CreaEvento.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        timer.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        dateButton = (Button) findViewById(R.id.dataEvento);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker(v);
            }
        });
        nomeevento = (EditText) findViewById(R.id.nomeEvento);

        descrizioneEvento = (EditText) findViewById(R.id.descrizioneEvento);
        dateButton = (Button) findViewById(R.id.dataEvento);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button = (Button) findViewById(R.id.buttonEvent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ora = timer.getText().toString();
                String Enome = nomeevento.getText().toString();
                String EdescrizioneEvento = descrizioneEvento.getText().toString();
                String Edata_evento =dateButton.getText().toString();
                String categoria = item.toString();
                String luogo= autoCompleteTextView.getText().toString();
                eve = new Event(numero_evento,categoria, Enome, Edata_evento, ora, EdescrizioneEvento,luogo);
                creaEvento();
                eu= new EventoUtente(idu,idevv);
                addAutore();
                Toast.makeText(CreaEvento.this, "Evento creato!", Toast.LENGTH_SHORT).show();
                openHome();
                if (statusCode == 500 || statusCode == 400) {

                }

            }
        });
        //imageView = (ImageView) findViewById(R.id.fotoevento);




        Button b = (Button) findViewById(R.id.addfotoevento);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage(CreaEvento.this);
            }
        });
    }

    private void selectImage(Context context) {
        final CharSequence[] options = {"Scegli dalla galleria", "Cancella"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Scegli la tua foto profilo");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
        builder.show();
    }



     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {

            filepath = data.getData();
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                // Toast.makeText(getApplicationContext(),getPath(filepath),Toast.LENGTH_LONG).show();
            } catch (Exception ex) {

            }
        }
    }


    private LatLng getLatLngFromAddress(String address){

        Geocoder geocoder=new Geocoder(CreaEvento.this);
        List<Address> addressList;

        try {
            addressList = geocoder.getFromLocationName(address, 1);
            if(addressList!=null){
                Address singleaddress=addressList.get(0);
                LatLng latLng=new LatLng(singleaddress.getLatitude(),singleaddress.getLongitude());
                return latLng;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    private Address getAddressFromLatLng(LatLng latLng){
        Geocoder geocoder=new Geocoder(CreaEvento.this);
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 5);
            if(addresses!=null){
                Address address=addresses.get(0);
                return address;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

         datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year) {
        return day + " " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "GEN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAG";
        if (month == 6)
            return "GIU";
        if (month == 7)
            return "LUG";
        if (month == 8)
            return "AGO";
        if (month == 9)
            return "SET";
        if (month == 10)
            return "OTT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DIC";
        return "GEN";
    }

    public void openDatePicker(View v) {
        datePickerDialog.show();
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void creaEvento() {

        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<Event> call = apiService.createEvent(eve);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                 statusCode = response.code();
                eve = response.body();
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
            }
        });
    }


    public void addAutore() {

        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<EventoUtente> call = apiService.addautore(eu);
        call.enqueue(new Callback<EventoUtente>() {
            @Override
            public void onResponse(Call<EventoUtente> call, Response<EventoUtente> response) {
                statusCode = response.code();
                eu = response.body();
            }

            @Override
            public void onFailure(Call<EventoUtente> call, Throwable t) {
            }
        });
    }

    public void nomeEvento() {

        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<List<Event>> call = apiService.getNumeroEvento();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                statusCode = response.code();
                eventonome = response.body();
                idevv=eventonome.get(0).getnumero_evento()+1;
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
            }
        });
    }


    public static final String BASE_URL = "http://10.0.2.2:8080/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    }


