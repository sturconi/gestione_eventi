package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userET = null;
    EditText passwordET = null;

    String username =  null;
    String password = null ;
    private  final  static  String  MY_PREFERENCES  =  "MyPref";

    private  final  static  String  TEXT_LOGIN_KEY  =  "textLogin";
    private  final  static  String  TEXT_PASSWORD_KEY  =  "textPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button;
        userET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);
        updatePreferencesData();
        if(username.length()>0 && password.length()>0) {
            openHome();
            Account();
            finish();
        }


        button =(Button) findViewById(R.id.buttonAccedi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 username =  userET.getText().toString();
                 password = passwordET.getText().toString();
                if (username.contains("@")) {

                savePreferencesData();
                openHome();
                //Account();
                //updatePreferencesData()
                }


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
        HomeIntent.putExtra("pwd", password);
        startActivity(HomeIntent);
       // savePreferencesData();
    }

    public void openRegistrazione() {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
    public void Account(){
        Intent AccountIntent = new Intent(this, Account.class);
        AccountIntent.putExtra("user", username);
        AccountIntent.putExtra("pwd", password);
    }
    public  void  savePreferencesData()  {

        SharedPreferences prefs  =  getSharedPreferences(MY_PREFERENCES,  Context.MODE_PRIVATE);

        SharedPreferences.Editor  editor  =  prefs.edit();

        EditText outputUser  =  (EditText)  findViewById(R.id.username);
        EditText outputPass  =  (EditText)  findViewById(R.id.password);
        CharSequence  textUser  =  outputUser.getText();
        CharSequence  textPass  =  outputPass.getText();
        if  (textUser  !=  null && textPass != null)  {

            editor.putString(TEXT_LOGIN_KEY,  textUser.toString());
            editor.putString(TEXT_PASSWORD_KEY,  textPass.toString());
            editor.commit();
            //openHome();
        }
        updatePreferencesData();
    }
    private  void  updatePreferencesData(){

        SharedPreferences  prefs  =  getSharedPreferences(MY_PREFERENCES,  Context.MODE_PRIVATE);

        username  =  prefs.getString(TEXT_LOGIN_KEY,  "");
        password  =  prefs.getString(TEXT_PASSWORD_KEY,  "");

      //  TextView outputView  =  (TextView)  findViewById(R.id.outputData);
       // outputView.setText(textData);

    }
}