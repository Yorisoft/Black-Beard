package com.yorisoft.blackbeard4278.blackbeardalpha;


import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class AboutUs extends AppCompatActivity {

    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView nNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nDrawerLayout = (DrawerLayout)findViewById(R.id.drawerMain);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);

        nNavigation = (NavigationView)findViewById(R.id.navView);
        nNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                }
                return false;
            }

        });
        nToggle.syncState();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return(nToggle.onOptionsItemSelected(item));

    }

}
