package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class EnclosureGuide extends AppCompatActivity {



    TextView enclosureTittle,titleOne,titleOneAndHalf, titleTwo, titleThree,titleFour,titleFive,titleSix, infoOne, infoOneAndHalf, infoTwo, infoThree, infoFour, infoFive, infoSix;
    Typeface Roboto,Congratulations,coffee_tea,coco,coco_light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enclosure);

        Roboto = Typeface.createFromAsset(getAssets(),"font/Roboto-Light.ttf" );
        Congratulations = Typeface.createFromAsset(getAssets(),"font/Congratulations_DEMO.ttf" );
        coffee_tea = Typeface.createFromAsset(getAssets(),"font/coffee_tea.ttf" );
        coco = Typeface.createFromAsset(getAssets(),"font/CocoGothic_trial.ttf" );
        coco_light = Typeface.createFromAsset(getAssets(),"font/CocoGothic-Light_trial.ttf" );


        enclosureTittle = (TextView)findViewById(R.id.enclosureTittle);
        enclosureTittle.setTypeface(coco);


        titleOne = (TextView)findViewById(R.id.titleOne);
        titleOne.setTypeface(Congratulations);
        titleOneAndHalf = (TextView)findViewById(R.id.titleOneAndHalf);
        titleOneAndHalf.setTypeface(Congratulations);
        titleTwo = (TextView)findViewById(R.id.titleTwo);
        titleTwo.setTypeface(Congratulations);
        titleThree = (TextView)findViewById(R.id.titleThree);
        titleThree.setTypeface(Congratulations);
        titleFour = (TextView)findViewById(R.id.titleFour);
        titleFour.setTypeface(Congratulations);
        titleFive = (TextView)findViewById(R.id.titleFive);
        titleFive.setTypeface(Congratulations);
        titleSix = (TextView)findViewById(R.id.titleSix);
        titleSix.setTypeface(Congratulations);


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
