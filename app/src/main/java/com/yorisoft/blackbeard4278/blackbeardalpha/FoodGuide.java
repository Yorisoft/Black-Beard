package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


//TODO add margin bottom to GUI

public class FoodGuide extends AppCompatActivity {


    TextView bla ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_diet);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0F833BB01FC8E0A5D3592824FD6F0322")//DeviceID
                .build();
        AdView adView =  (AdView)this.findViewById(R.id.adView);
        adView.loadAd(adRequest);

    }
}
