package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Premium extends AppCompatActivity {

    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView newNavigation;


    Typeface Roboto,gravity,Congratulations, bebasKai,gravityBold;

    TextView premiumMainTitle,premiumTopTitle,premiumBottomTitle,premiumSumm,premiumSummTwo,premiumSummThree;

    Button premiumBttn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_option);



        //TypeFace
        Roboto = Typeface.createFromAsset(getAssets(),"font/Roboto-Light.ttf" );
        Congratulations = Typeface.createFromAsset(getAssets(),"font/Congratulations_DEMO.ttf" );
        gravity = Typeface.createFromAsset(getAssets(),"font/Gravity-Regular.ttf" );
        gravityBold = Typeface.createFromAsset(getAssets(),"font/Gravity-Bold.ttf" );
        bebasKai = Typeface.createFromAsset(getAssets(),"font/BebasKai-Regular.ttf" );
//TextViews
        premiumMainTitle = (TextView)findViewById(R.id.premiumMainTitle);
        premiumMainTitle.setTypeface(gravity);
        premiumTopTitle = (TextView)findViewById(R.id.premiumTopTitle);
        premiumTopTitle.setTypeface(gravity);
        premiumBottomTitle = (TextView)findViewById(R.id.premiumBottomTitle);
        premiumBottomTitle.setTypeface(gravity);
        premiumSumm = (TextView)findViewById(R.id.premiumSumm);
        premiumSumm.setTypeface(Roboto);
        premiumSummTwo = (TextView)findViewById(R.id.premiumSummTwo);
        premiumSummTwo.setTypeface(Roboto);
        premiumSummThree = (TextView)findViewById(R.id.premiumSummThree);
        premiumSummThree.setTypeface(Roboto);

//Button
        premiumBttn = (Button)findViewById(R.id.premiumBttn);
        premiumBttn.setTypeface(gravity);





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
                        Intent userPets = new Intent(Premium.this,MainActivity.class);
                        startActivity(userPets);

                        break;
                    case R.id.careTips:
                        //Do some thing here
                        nDrawerLayout.closeDrawers();
                        Intent careGuide = new Intent(Premium.this,CareGuideSelect.class);
                        startActivity(careGuide);

                        break;

                    case R.id.settings:
                        nDrawerLayout.closeDrawers();
                        Intent nSetting = new Intent(Premium.this,Settings.class);
                        startActivity(nSetting);

                        break;

                    case R.id.aboutUS:
                        nDrawerLayout.closeDrawers();
                        Intent aboutUs = new Intent(Premium.this,AboutUs.class);
                        startActivity(aboutUs);

                        break;

                    case R.id.premium:

                        nDrawerLayout.closeDrawers();

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


