package com.example.applicazionevera;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String user, password, ip, port, database;

    public Connection connectionclass(){
        ip="localhost";
        database="AppEventi";
        user="root";
        password="password";
        port="3306";

        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection= null;
        String ConnectionURL= null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ database+";user="+user+";password="+password+";";
            connection= DriverManager.getConnection(ConnectionURL);
        }

        catch(Exception ex){
            Log.e("Error", ex.getMessage());

        }
        return connection;
    }
}
