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

import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class Registrazione extends AppCompatActivity {

    private Button dateButton;
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        EditText nickname = findViewById(R.id.usernameReg);
        EditText email = findViewById(R.id.emailReg);
        EditText password = findViewById(R.id.passwordReg);
        EditText passConf = findViewById(R.id.passwordConf);
        Button button;

        initDatePicker();


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
                            openLogin();
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



    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
