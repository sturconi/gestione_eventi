package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends AppCompatActivity {

    String username =  null;
    String password = null ;

    TextView user=null;
    TextView pass=null;
    ImageView img=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();


        user=findViewById(R.id.userTextView);
        pass=findViewById(R.id.passTextView);
        img=findViewById(R.id.imgView);


        Bundle datiLogin = getIntent().getExtras();
        if(datiLogin != null) {
             username = datiLogin.getString("user");
             password = datiLogin.getString("pwd");
             user.setText(username);
             pass.setText(password);
            Toast.makeText(this, "Benvenuto " + username, Toast.LENGTH_SHORT).show();
        }

        Button button = (Button) findViewById(R.id.Cambiopass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCambioPass();
            }
        });


    }

    public void openCambioPass() {
        Intent intent = new Intent(this, Cambiopassword.class);
        startActivity(intent);
    }

}