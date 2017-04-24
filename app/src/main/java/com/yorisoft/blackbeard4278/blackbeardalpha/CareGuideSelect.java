package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class CareGuideSelect extends AppCompatActivity {

    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView nNavigation;
    LinearLayout guideLayout;

    Bitmap BM;

    Button enclosure,food,handling,behavior,genInfo ;

    Typeface odinFont,coffee_tea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.care_guide_options);

        odinFont = Typeface.createFromAsset(getAssets(),"font/OdinBold.ttf" );
        coffee_tea = Typeface.createFromAsset(getAssets(),"font/coffee_tea.ttf" );


        enclosure =(Button)findViewById(R.id.enclosureButton);
        enclosure.setTypeface(coffee_tea);
        food =(Button)findViewById(R.id.foodButton);
        food.setTypeface(coffee_tea);
        handling =(Button)findViewById(R.id.handlingButton);
        handling.setTypeface(coffee_tea);
        behavior =(Button)findViewById(R.id.behaviorButton);
        behavior.setTypeface(coffee_tea);
        genInfo =(Button)findViewById(R.id.generalInfoButton);
        genInfo.setTypeface(coffee_tea);



        guideLayout = (LinearLayout)findViewById(R.id.guideLayout);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerMain);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);

        nNavigation = (NavigationView) findViewById(R.id.navView);

        nNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                }
                return false;
            }
        });

        nToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(nToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);

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


