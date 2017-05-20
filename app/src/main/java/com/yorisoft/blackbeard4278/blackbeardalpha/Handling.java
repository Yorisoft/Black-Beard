package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Handling extends AppCompatActivity {

    //Declaring all TextViews
    TextView handlingTitle,infoOne,infoTwo,infoThree,infoFour,infoFive,titleOne,titleTwo,
            titleThree,titleFour,titleFive;

    //Declaring all Typefaces
    Typeface Roboto,Congratulations,gravity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handling);


        //Initializing variables for Typefaces
        Roboto = Typeface.createFromAsset(getAssets(),"font/Roboto-Light.ttf" );
        Congratulations = Typeface.createFromAsset(getAssets(),"font/Congratulations_DEMO.ttf" );
        gravity = Typeface.createFromAsset(getAssets(),"font/Gravity-Regular.ttf" );


        //Initializing variables for Textviews
        handlingTitle = (TextView)findViewById(R.id.handlingTitle);
        handlingTitle.setTypeface(gravity);

        titleOne = (TextView)findViewById(R.id.titleOne);
        titleOne.setTypeface(Congratulations);
        titleTwo = (TextView)findViewById(R.id.titleTwo);
        titleTwo.setTypeface(Congratulations);
        titleThree = (TextView)findViewById(R.id.titleThree);
        titleThree.setTypeface(Congratulations);
        titleFour = (TextView)findViewById(R.id.titleFour);
        titleFour.setTypeface(Congratulations);
        titleFive = (TextView)findViewById(R.id.titleFive);
        titleFive.setTypeface(Congratulations);


        infoOne = (TextView)findViewById(R.id.infoOne);
        infoOne.setTypeface(Roboto);
        infoTwo = (TextView)findViewById(R.id.infoTwo);
        infoTwo.setTypeface(Roboto);
        infoThree = (TextView)findViewById(R.id.infoThree);
        infoThree.setTypeface(Roboto);
        infoFour = (TextView)findViewById(R.id.infoFour);
        infoFour.setTypeface(Roboto);
        infoFive= (TextView)findViewById(R.id.infoFive);
        infoFive.setTypeface(Roboto);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView adView =  (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0F833BB01FC8E0A5D3592824FD6F0322")//DeviceID
                .build();
        adView.loadAd(adRequest);

    }
}
