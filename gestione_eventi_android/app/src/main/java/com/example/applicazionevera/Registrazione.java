package com.example.applicazionevera;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applicazionevera.retrofit.PreferenceHelper;
import com.example.applicazionevera.retrofit.RegistrazioneInterface;
import com.google.android.material.datepicker.MaterialDatePicker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Registrazione extends AppCompatActivity {

    private Button dateButton;
    private DatePickerDialog datePickerDialog;

    private PreferenceHelper preferenceHelper;


        private EditText nome, cognome, uname,  email , password;

    Button data_nascita ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        nome = (EditText) findViewById(R.id.nome);
        cognome = (EditText) findViewById(R.id.cognome);
        uname = (EditText) findViewById(R.id.usernameReg);
        data_nascita = (Button) findViewById(R.id.dataNascita);
        email = (EditText) findViewById(R.id.emailReg);
        password = (EditText) findViewById(R.id.passwordReg);
        EditText passConf = findViewById(R.id.passwordConf);
        Button button;

        initDatePicker();
        preferenceHelper = new PreferenceHelper(this);



        if(preferenceHelper.getIsLogin()){
            openLogin();
            this.finish();
        }


        button = (Button) findViewById(R.id.buttonReg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               String emailString = email.getText().toString();
                String passwordString = password.getText().toString();
                String passConfString = passConf.getText().toString();
                if (emailString.contains("@")) {
                    if (passwordString.length() >= 5) {
                        if (passwordString.equals(passConfString)) {
                            registerMe();
                        } else
                            Toast.makeText(Registrazione.this, "la conferma password deve essere uguale alla password", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(Registrazione.this, "La password deve essere almeno di cinque caratteri", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(Registrazione.this, "email non valida", Toast.LENGTH_SHORT).show();

            }





        });


        dateButton = (Button) findViewById(R.id.dataNascita);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker(v);
            }
        });

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               month = month +1;
               String date = makeDateString(day, month, year);
               dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener,year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

            private String makeDateString(int day, int month, int year) {

                return day + " " +  getMonthFormat(month) + " " + year;
            }

            private String getMonthFormat(int month) {
                if(month==1)
                    return "GEN";
                if(month==2)
                    return "FEB";
                if(month==3)
                    return "MAR";
                if(month==4)
                    return "APR";
                if(month==5)
                    return "MAG";
                if(month==6)
                    return "GIU";
                if(month==7)
                    return "LUG";
                if(month==8)
                    return "AGO";
                if(month==9)
                    return "SET";
                if(month==10)
                    return "OTT";
                if(month==11)
                    return "NOV";
                if(month==12)
                    return "DIC";


                return "GEN";
            }


    public void openDatePicker(View v){
        datePickerDialog.show();
    }





    private void registerMe() {

        final String Fnome = nome.getText().toString();
        final String Fcognome = cognome.getText().toString();
        final String Funame = uname.getText().toString();
        final String Fdata_nascita = data_nascita.getText().toString();
        final String Femail = email.getText().toString();
        final String Fpassword = password.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RegistrazioneInterface.REGIURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RegistrazioneInterface api = retrofit.create(RegistrazioneInterface.class);

        Call<String> call = api.getUserRegi(Fnome, Fcognome, Funame, Fdata_nascita, Femail ,Fpassword);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        try {
                            parseRegData(jsonresponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void parseRegData(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("status").equals("true")){

            saveInfo(response);

            Toast.makeText(Registrazione.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            openLogin();
            this.finish();
        }else {

            Toast.makeText(Registrazione.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInfo(String response){

        preferenceHelper.putIsLogin(true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    preferenceHelper.putNome(dataobj.getString("nome"));
                    preferenceHelper.putCognome(dataobj.getString("cognome"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
