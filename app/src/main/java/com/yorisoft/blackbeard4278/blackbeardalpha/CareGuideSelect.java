package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CareGuideSelect extends AppCompatActivity {

    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView newNavigation;
    LinearLayout guideLayout;

    Bitmap BM;

    Button enclosure,food,handling,behavior,genInfo ;

    Typeface odinFont,casual,gravity, bebasKai,gravityBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.care_guide_options);

        odinFont = Typeface.createFromAsset(getAssets(),"font/OdinBold.ttf" );
        casual = Typeface.createFromAsset(getAssets(),"font/SemiCasual.ttf" );
        gravity = Typeface.createFromAsset(getAssets(),"font/Gravity-Regular.ttf" );
        gravityBold = Typeface.createFromAsset(getAssets(),"font/Gravity-Bold.ttf" );
        bebasKai = Typeface.createFromAsset(getAssets(),"font/BebasKai-Regular.ttf" );


        enclosure =(Button)findViewById(R.id.enclosureButton);
        enclosure.setTypeface(casual);
        food =(Button)findViewById(R.id.foodButton);
        food.setTypeface(casual);
        handling =(Button)findViewById(R.id.handlingButton);
        handling.setTypeface(casual);
        behavior =(Button)findViewById(R.id.behaviorButton);
        behavior.setTypeface(casual);
        genInfo =(Button)findViewById(R.id.generalInfoButton);
        genInfo.setTypeface(casual);



        guideLayout = (LinearLayout)findViewById(R.id.guideLayout);


//back button

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//drawer and nav view

        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerMain);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);

        newNavigation = (NavigationView) findViewById(R.id.navView);

        newNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.petDragons:
                        //Do some thing here

                        nDrawerLayout.closeDrawers();
                        Intent userPets = new Intent(CareGuideSelect.this,MainActivity.class);
                        startActivity(userPets);

                        break;
                    case R.id.careTips:
                        //Do some thing here
                        nDrawerLayout.closeDrawers();
                        break;

                    case R.id.settings:
                        nDrawerLayout.closeDrawers();
                        Intent nSetting = new Intent(CareGuideSelect.this,Settings.class);
                        startActivity(nSetting);

                        break;

                    case R.id.aboutUS:
                        nDrawerLayout.closeDrawers();
                        Intent aboutUs = new Intent(CareGuideSelect.this,AboutUs.class);
                        startActivity(aboutUs);

                        break;

                    case R.id.premium:
                        nDrawerLayout.closeDrawers();
                        Intent premium = new Intent(CareGuideSelect.this, Premium.class);
                        startActivity(premium);

                        break;

                }
                return false;
            }
        });

        nToggle.syncState();

        getValues();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(nToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void getValues(){
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
           // navPetName.setTextSize(32);
        }


    }


    public void guideClick(View v) {
        switch(v.getId()) {
            case R.id.foodButton:
                Intent foodTips = new Intent(CareGuideSelect.this,FoodGuide.class);
                startActivity(foodTips);
                break;

            case R.id.enclosureButton:
                Intent enclosureTips = new Intent(CareGuideSelect.this,EnclosureGuide.class);
                startActivity(enclosureTips);
                break;

            case R.id.handlingButton:
                Intent handlingTips = new Intent(CareGuideSelect.this,Handling.class);
                startActivity(handlingTips);
                break;

            case R.id.behaviorButton:
                Intent behaviorTips = new Intent(CareGuideSelect.this,Behavior.class);
                startActivity (behaviorTips);
                break;

            case R.id.generalInfoButton:
                Intent genInfo = new Intent(CareGuideSelect.this,GenInformation.class);
                startActivity(genInfo);
                break;

            }

        }

}


