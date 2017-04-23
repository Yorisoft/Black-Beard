package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class Settings extends AppCompatActivity {

    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView nNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_main);

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
                        Intent userPets = new Intent(Settings.this,MainActivity.class);
                        startActivity(userPets);

                        break;
                    case R.id.careTips:
                        //Do some thing here
                        nDrawerLayout.closeDrawers();
                        Intent careGuide = new Intent(Settings.this,CareGuideSelect.class);
                        startActivity(careGuide);

                        break;

                    case R.id.settings:

                        nDrawerLayout.closeDrawers();

                        break;

                    case R.id.aboutUS:
                        nDrawerLayout.closeDrawers();
                        Intent aboutUs = new Intent(Settings.this,AboutUs.class);
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
}
