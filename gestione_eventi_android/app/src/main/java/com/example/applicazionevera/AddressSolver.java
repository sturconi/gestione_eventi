package com.example.applicazionevera;

import static org.chromium.base.ContextUtils.getApplicationContext;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

private class AddressSolver extends AsyncTask<Location, Void, String> {
    @Override
    protected String doInBackground(Location... params) {
        Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());
        Location pos = params[0];
        double latitude = pos.getLatitude();
        double longitude = pos.getLongitude();
        List<Address> addresses = null;
        try {
            addresses = geo.getFromLocation(latitude, longitude, 1);
        }
        catch(IOException e){ }
        if (addresses != null) {
            if (addresses.isEmpty())
                return null;
            else{
                if (addresses.size() > 0) {
                StringBuffer address = new StringBuffer();
                Address tmp = addresses.get(0);
                for (int y = 0; y < tmp.getMaxAddressLineIndex(); y++)
                    address.append(tmp.getAddressLine(y) + "\n");
                return address.toString();
            }
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        if (result != null)
            updateText(R.id., result);
        else
            updateText(R.id.where, "N.A.");
    }
}
