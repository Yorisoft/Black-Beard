package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class EnclosureGuide extends AppCompatActivity {



    TextView infoOne,infoOneAndHalf, infoTwo, infoThree, infoFour, infoFive, infoSix;
    Typeface Roboto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enclosure);

        Roboto = Typeface.createFromAsset(getAssets(),"font/Roboto-Light.ttf" );


        infoOne = (TextView)findViewById(R.id.infoOne);
        infoOne.setTypeface(Roboto);
        infoOneAndHalf= (TextView)findViewById(R.id.infoOneAndHalf);
        infoOneAndHalf.setTypeface(Roboto);
        infoTwo = (TextView)findViewById(R.id.infoTwo);
        infoTwo.setTypeface(Roboto);
        infoThree = (TextView)findViewById(R.id.infoThree);
        infoThree.setTypeface(Roboto);
        infoFour = (TextView)findViewById(R.id.infoFour);
        infoFour.setTypeface(Roboto);
        infoFive = (TextView)findViewById(R.id.infoFive);
        infoFive.setTypeface(Roboto);
        infoSix = (TextView)findViewById(R.id.infoSix);
        infoSix.setTypeface(Roboto);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        AdView adView =  (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0F833BB01FC8E0A5D3592824FD6F0322")//DeviceID
                .build();
        adView.loadAd(adRequest);

    }

}
