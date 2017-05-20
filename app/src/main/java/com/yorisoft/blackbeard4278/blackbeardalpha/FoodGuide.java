package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


//TODO add margin bottom to GUI

public class FoodGuide extends AppCompatActivity {

    //Declaring all TextViews
    TextView dietTitle,infoOne,infoTwo,infoThree,infoThreeAndHalf,infoFour,titleOne,titleTwo,
    titleThree, titleThreeAndHalf,titleFour;

    //Declaring all Typefaces
    Typeface Roboto,Congratulations,gravity,coco,gravityBold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_diet);

//Initializing variables for Typefaces
        Roboto = Typeface.createFromAsset(getAssets(),"font/Roboto-Light.ttf" );
        Congratulations = Typeface.createFromAsset(getAssets(),"font/Congratulations_DEMO.ttf" );
        gravity = Typeface.createFromAsset(getAssets(),"font/Gravity-Regular.ttf" );
        gravityBold = Typeface.createFromAsset(getAssets(),"font/Gravity-Bold.ttf" );


//Initializing variables for Textviews
        dietTitle = (TextView)findViewById(R.id.dietTitle);
        dietTitle.setTypeface(gravity);

        titleOne = (TextView)findViewById(R.id.titleOneOne);
        titleOne.setTypeface(Congratulations);
        titleTwo = (TextView)findViewById(R.id.titleOneTwo);
        titleTwo.setTypeface(Congratulations);
        titleThree = (TextView)findViewById(R.id.titleOneThree);
        titleThree.setTypeface(Congratulations);
        titleThreeAndHalf = (TextView)findViewById(R.id.titleThreeAndHalf);
        titleThreeAndHalf.setTypeface(Congratulations);
        titleFour = (TextView)findViewById(R.id.titleOneFour);
        titleFour.setTypeface(Congratulations);

        infoOne = (TextView)findViewById(R.id.infoOneOne);
        infoOne.setTypeface(Roboto);
        infoTwo = (TextView)findViewById(R.id.infoOneTwo);
        infoTwo.setTypeface(Roboto);
        infoThree = (TextView)findViewById(R.id.infoOneThree);
        infoThree.setTypeface(Roboto);
        infoThreeAndHalf= (TextView)findViewById(R.id.infoThreeAndHalf);
        infoThreeAndHalf.setTypeface(Roboto);
        infoFour = (TextView)findViewById(R.id.infoOneFour);
        infoFour.setTypeface(Roboto);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0F833BB01FC8E0A5D3592824FD6F0322")//DeviceID
                .build();
        AdView adView =  (AdView)this.findViewById(R.id.adView);
        adView.loadAd(adRequest);

    }
}
