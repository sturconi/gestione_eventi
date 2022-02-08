package com.example.applicazionevera;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrazione extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        EditText nickname = findViewById(R.id.usernameReg);
        EditText email = findViewById(R.id.emailReg);
        EditText password = findViewById(R.id.passwordReg);
        EditText passConf = findViewById(R.id.passwordConf);
        Button button;

    button =(Button) findViewById(R.id.buttonReg);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String emailString = email.getText().toString();
            String passwordString = password.getText().toString();
            String passConfString = passConf.getText().toString();
            if (emailString.contains("@")) {
                if (passwordString.length()>=5) {
                    if (passwordString.equals(passConfString)) {
                        openLogin();
                    }
                    else
                        Toast.makeText(Registrazione.this, "la conferma password deve essere uguale alla password", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Registrazione.this, "La password deve essere almeno di cinque caratteri", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(Registrazione.this, "email non valida", Toast.LENGTH_SHORT).show();


        }
    });


}



    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
