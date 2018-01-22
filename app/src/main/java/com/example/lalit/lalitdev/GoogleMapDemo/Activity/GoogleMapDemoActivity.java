package com.example.lalit.lalitdev.GoogleMapDemo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lalit.lalitdev.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Admin on 1/8/2018.
 * url - https://developers.google.com/maps/documentation/embed/get-api-key
 * Step 1: Get an API Key from the Google API Console
 * Step 2: Add the API key to your application
 * Follow these steps to get an API key:

 Go to the Google API Console.
 Create or select a project.
 Click Continue to enable the API.
 On the Credentials page, get an API key.
 Note: If you have an existing unrestricted API key, or a key with browser restrictions, you may use that key.
 From the dialog displaying the API key, select Restrict key to set a browser restriction on the API key.
 In the Key restriction section, select HTTP referrers (web sites), then follow the on-screen instructions to set referrers, then click Save. Read more about restricting API keys.

 1.create the fragment in xml
 2.call the MapFragment and get getMapAsync and set lang and long.

 */

public class GoogleMapDemoActivity  extends Activity implements OnMapReadyCallback {
    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private GoogleMap map;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap_demo_activity);
        //Get User records from SQLite DB
        MapFragment mapFragment = ((MapFragment )getFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
        initViews();
    }
    public  void initViews(){
    }
    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(18.31, 73.55))
                .title("Marker"));
    }
}