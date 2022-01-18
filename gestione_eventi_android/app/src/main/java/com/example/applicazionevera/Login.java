package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userET = null;
    EditText passwordET = null;

    String username =  null; //userET.getText().toString();
    String password = null ; //passwordET.getText().toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button;
        userET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);


        button =(Button) findViewById(R.id.buttonAccedi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username =  userET.getText().toString();
                String password = passwordET.getText().toString();
                if (username.contains("@")) {
                openHome();

                }
                else
                    Toast.makeText(Login.this, "@ mancante", Toast.LENGTH_SHORT).show();
            }
        });

        button =(Button) findViewById(R.id.buttonReg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrazione();
            }
        });
    }

    public void openHome() {
        Intent HomeIntent = new Intent(this, Home.class);

        HomeIntent.putExtra("user", username);
        HomeIntent.putExtra("pwd",  password);
        startActivity(HomeIntent);
    }

    public void openRegistrazione() {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
}