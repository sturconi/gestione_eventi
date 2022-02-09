package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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



        user=findViewById(R.id.userTextView);
        pass=findViewById(R.id.passTextView);
        img=findViewById(R.id.imgView);


        Bundle datiLogin = getIntent().getExtras();
        if(datiLogin != null) {
             username = datiLogin.getString("user");
             password = datiLogin.getString("pwd");
             user.setText(username);
             pass.setText(password);

        }

        Button bottone;

        bottone  = (Button) findViewById(R.id.CambioPass);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCambioPass();
            }
        });

        bottone  = (Button) findViewById(R.id.ModImm);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModImm();
            }
        });
        bottone  = (Button) findViewById(R.id.buttonLogout);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrazione();
            }
        });


    }

    public void openCambioPass() {
        Intent intent = new Intent(this, Cambiopassword.class);
        startActivity(intent);
    }
    public void openModImm() {
        Intent intent = new Intent(this,Modificaimmagine.class);
        startActivity(intent);
    }
    public void openRegistrazione() {
        Intent intent = new Intent(this,Registrazione.class);
        startActivity(intent);
    }

}