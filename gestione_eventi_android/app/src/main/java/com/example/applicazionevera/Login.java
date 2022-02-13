package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicazionevera.retrofit.LoginInterface;
import com.example.applicazionevera.retrofit.PreferenceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Login extends AppCompatActivity {

    EditText userET = null;
    EditText passwordET = null;

    String username =  null;
    String password = null ;
    private  final  static  String  MY_PREFERENCES  =  "MyPref";

    private  final  static  String  TEXT_LOGIN_KEY  =  "textLogin";
    private  final  static  String  TEXT_PASSWORD_KEY  =  "textPassword";






    private PreferenceHelper preferenceHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferenceHelper = new PreferenceHelper(this);

        Button button;
        userET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);

        /*
        updatePreferencesData();
        if(username.length()>0 && password.length()>0) {
            openHome();
            Account();
            finish();
        }
        */


        button =(Button) findViewById(R.id.buttonAccedi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

                /*
                 username =  userET.getText().toString();
                 password = passwordET.getText().toString();
                if (username.contains("@")) {

                savePreferencesData();
                openHome();
                //Account();
                //updatePreferencesData()
                }
                */
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


    private void loginUser() {

        final String username = userET.getText().toString().trim();
        final String password = passwordET.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginInterface.LOGINURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        LoginInterface api = retrofit.create(LoginInterface.class);

        Call<String> call = api.getUserLogin(username,password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        parseLoginData(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void parseLoginData(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {

                saveInfo(response);

                Toast.makeText(Login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                openHome();
                this.finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
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





    public void openRegistrazione() {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
    public void Account(){
        Intent AccountIntent = new Intent(this, Account.class);
        AccountIntent.putExtra("user", username);
        AccountIntent.putExtra("pwd", password);
    }
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
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