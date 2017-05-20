package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView newNavigation;

    Typeface Roboto,coffee_tea,Congratulations,bebasKai,gravity,gravityBold;

    TextView mainTitle, aboutDevTitle,missionTitle,sourcesTitle,aboutInfo,missionInfo,sourcesInfo, sourceContainer,sourceExtra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

//TypeFace
        Roboto = Typeface.createFromAsset(getAssets(),"font/Roboto-Light.ttf" );
        Congratulations = Typeface.createFromAsset(getAssets(),"font/Congratulations_DEMO.ttf" );
        gravity = Typeface.createFromAsset(getAssets(),"font/Gravity-Regular.ttf" );
        gravityBold = Typeface.createFromAsset(getAssets(),"font/Gravity-Bold.ttf" );
        bebasKai = Typeface.createFromAsset(getAssets(),"font/BebasKai-Regular.ttf" );


        mainTitle = (TextView)findViewById(R.id.aboutMainTitle);
        mainTitle.setTypeface(gravity);
        aboutDevTitle= (TextView)findViewById(R.id.devTitle);
        aboutDevTitle.setTypeface(gravity);
        missionTitle= (TextView)findViewById(R.id.missionTitle);
        missionTitle.setTypeface(gravity);
        sourcesTitle= (TextView)findViewById(R.id.sourceTitle);
        sourcesTitle.setTypeface(gravity);



        aboutInfo = (TextView)findViewById(R.id.devSumm);
        aboutInfo.setTypeface(Roboto);
        missionInfo = (TextView)findViewById(R.id.missionSumm);
        missionInfo.setTypeface(Roboto);
        sourcesInfo = (TextView)findViewById(R.id.sourceSumm);
        sourcesInfo.setTypeface(Roboto);
        sourceContainer = (TextView)findViewById(R.id.sourceContainer);
        sourceContainer.setTypeface(Roboto);
        sourceExtra = (TextView)findViewById(R.id.sourceContainerExtra);
        sourceExtra.setTypeface(Roboto);




//Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//Drawer and Nav.
        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerMain);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);

        newNavigation = (NavigationView)findViewById(R.id.navView);
        newNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.petDragons:
                        //Do some thing here
                        nDrawerLayout.closeDrawers();
                        Intent userPets = new Intent(AboutUs.this,MainActivity.class);
                        startActivity(userPets);

                        break;
                    case R.id.careTips:
                        //Do some thing here
                        nDrawerLayout.closeDrawers();
                        Intent careGuide = new Intent(AboutUs.this,CareGuideSelect.class);
                        startActivity(careGuide);

                        break;

                    case R.id.settings:
                        nDrawerLayout.closeDrawers();
                        Intent nSetting = new Intent(AboutUs.this,Settings.class);
                        startActivity(nSetting);

                        break;

                    case R.id.aboutUS:

                        nDrawerLayout.closeDrawers();

                        break;

                    case R.id.premium:
                        nDrawerLayout.closeDrawers();
                        Intent premium = new Intent(AboutUs.this, Premium.class);
                        startActivity(premium);

                        break;

                }
                return false;
            }

        });
        nToggle.syncState();


//NavHeader and/or other values
        getValues();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return(nToggle.onOptionsItemSelected(item));

    }


    private void getValues() {

        //SharedPreferences
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        String navName = prefs.getString("dragon_name","Pet name");
        String navGender = prefs.getString("dragon_gender","GENDER");
//NavHeader
        newNavigation = (NavigationView) findViewById(R.id.navView);
        View hView =  newNavigation.getHeaderView(0);
        TextView navPetName = (TextView)hView.findViewById(R.id.navPetName1);
        ImageView navPetGen = (ImageView)hView.findViewById(R.id.navPetGen1);


//set Nav gender
        if (navGender.equals("GENDER")){

        } if (navGender.equals("FEMALE")) {
            navPetGen.setImageResource(R.drawable.female);


        } else if (navGender.equals("MALE")) {
            navPetGen.setImageResource(R.drawable.male);

        }
//set Nav pet name
        if (navName.equals("Pet name")) {
            //Keep Hint
        } else {
            navPetName.setText(" "+ navName +" ");
            navPetName.setAllCaps(true);
            navPetName.setTypeface(gravityBold);
           // navPetName.setTextSize(38);
        }


    }



}
