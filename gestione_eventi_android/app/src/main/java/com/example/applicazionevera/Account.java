package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    EditText userET = null;
    EditText passwordET = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();
        Bundle datiLogin = getIntent().getExtras();

        userET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);


        if(datiLogin != null) {
            String username = datiLogin.getString("user");
            String password = datiLogin.getString("pwd");

            userET.setText(username);
        }


    }

}