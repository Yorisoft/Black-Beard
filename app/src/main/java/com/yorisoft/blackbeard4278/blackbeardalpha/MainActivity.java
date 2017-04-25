
package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.w3c.dom.Text;

import java.io.File;
import java.util.prefs.PreferenceChangeListener;

import static android.R.attr.tag;


public class MainActivity extends AppCompatActivity {

    private AgeCalculation age = null;
    private Schedules bath = null;

    Button editBttn;
    Button saveButton;
    ImageButton moreEdits;

    TextView ageOne, weightOne, lengthOne, petName, newBath, lastBath,newVeggie,oldVeggie;

    ImageView petPicture;


    DrawerLayout newDrawerLayout;
    ActionBarDrawerToggle newToggle;
    NavigationView newNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = new AgeCalculation();
        bath = new Schedules();

        ageOne = (TextView) findViewById(R.id.ageOne);
        weightOne = (TextView) findViewById(R.id.weightOne);
        lengthOne = (TextView) findViewById(R.id.lengthOne);
        petName = (TextView) findViewById(R.id.petName);
        newBath = (TextView) findViewById(R.id.newBath);
        lastBath = (TextView) findViewById(R.id.lastBath);
        newVeggie = (TextView)findViewById(R.id.newFood);
        oldVeggie = (TextView)findViewById(R.id.lastFood);

        editBttn = (Button) findViewById(R.id.editBttn);
        saveButton = (Button) findViewById(R.id.saveButton);
        moreEdits = (ImageButton) findViewById(R.id.moreButton);

        petPicture = (ImageView) findViewById(R.id.imageView2);


        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        String profile = prefs.getString("image_path", "choose image");
        int birth_month = prefs.getInt("birth_month", 1);
        int birth_day = prefs.getInt("birth_day", 1);
        int birth_year = prefs.getInt("birth_year", 1);



        age.setDateOfBirth(birth_year, birth_month, birth_day);


        getValues();
//populating views with values. if statements in case they are empty.


        //lastBath.setText(old_bath);

        //  byte[] imageAsBytes = Base64.decode(profile, Base64.DEFAULT);
        // Bitmap bitmapPre = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);

        //  BitmapDrawable bitToImage = new BitmapDrawable(getResources(),bitmapPre);
        //  petPicture.setBackground(bitToImage);
        //no need to decode bitmap, Using Picasso!


        Uri picturePath = Uri.parse(profile);

        // Picasso.with(this)
        //         .load(picturePath)
        //         .fit()
        //         .into(petPicture);
        //Picasso sucks, all hail Glide (better  with portrait images and at c).

        Glide.with(this)
                .load(picturePath)
                .centerCrop()
                .into(petPicture);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        newDrawerLayout = (DrawerLayout) findViewById(R.id.drawerMain);
        newToggle = new ActionBarDrawerToggle(this, newDrawerLayout, R.string.open, R.string.close);
        newDrawerLayout.addDrawerListener(newToggle);

        newNavigation = (NavigationView) findViewById(R.id.navView);
        newNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.petDragons:
                        //Do some thing here
                        newDrawerLayout.closeDrawers();

                        break;
                    case R.id.careTips:
                        //Do some thing here
                        newDrawerLayout.closeDrawers();
                        Intent careGuide = new Intent(MainActivity.this, CareGuideSelect.class);
                        startActivity(careGuide);

                        break;

                    case R.id.settings:
                        newDrawerLayout.closeDrawers();
                        Intent nSetting = new Intent(MainActivity.this, Settings.class);
                        startActivity(nSetting);

                        break;

                    case R.id.aboutUS:
                        newDrawerLayout.closeDrawers();
                        Intent aboutUs = new Intent(MainActivity.this, AboutUs.class);
                        startActivity(aboutUs);

                        break;
                }
                return false;
            }
        });

        newToggle.syncState();


        editBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchEditActivity = new Intent("com.yorisoft.blackbeard4278.blackbeard.MAINEDIT");
                startActivity(launchEditActivity);
            }

        });

    }

    private void getValues() {

        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        String name = prefs.getString("dragon_name", "Pet name!");

        int birth_year = prefs.getInt("birth_year", 1);


        String savedAge = prefs.getString("dragon_age", "");

        String weight = prefs.getString("dragon_weight", "");
        String length = prefs.getString("dragon_length", "");

        int bathMonth = prefs.getInt("bath_month", 1);
        int bathDay = prefs.getInt("bath_day", 1);
        String old_bath = prefs.getString("bathed_date", "Last Bathed?");

        int veggMonth = prefs.getInt("vegg_month", 1);
        int veggDay = prefs.getInt("vegg_day", 1);
        String old_vegg = prefs.getString("veggies_date","oldVegg");


        if (birth_year == 1) {
            //Keep Hint
        } else {
            calculateAge();
        }

        if (old_bath.equals("Last Bathed?")) {
            //Keep Hint
        } else {
            lastBath.setText(old_bath);
        }

        if (name.equals("Pet name!")) {
            //Keep Hint
        } else {
            petName.setText(name);
        }

        if (weight.equals("weight")) {
            //Keep Hint
        } else {
            weightOne.setText(weight);
        }

        if (length.equals("length")) {
            //Keep Hint
        } else {
            lengthOne.setText(length);
        }

        if (bathDay == 0 && bathMonth == 0) {

            newBath.setText("cake");

        } else {

            calculateBath();

        }
        if (veggDay == 0 && veggMonth == 0){

        } else {

            calculateVegg();
        }
        if (old_vegg.equals("oldVegg")){

        } else {
            oldVeggie.setText(old_vegg);
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (newToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void imageAndNameEdit(View v) {

        PopupMenu popUp = new PopupMenu(MainActivity.this, moreEdits);
        popUp.getMenuInflater().inflate(R.menu.popup_img_name, popUp.getMenu());


        popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.imaNameEdit:
                        Intent img_name_edit = new Intent(MainActivity.this, MainEdit.class);
                        startActivity(img_name_edit);
                        break;
                }
                return true;
            }
        });
        popUp.show();

    }

    private void calculateAge() {

        age.setCurrentDate();
        Log.i("calculateAge: ", age.toString());
        age.calculateYear();
        age.calculateMonth();
        age.calculateDay();
        age.calculateWeek();
        ageOne.setText(age.getResult());
    }

    private void calculateBath() {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int bathMonth = prefs.getInt("bath_month", 1); // Integer.valueOf(bMonth));
        int bathDay = prefs.getInt("bath_day", 1); // Integer.valueOf(bDay));
        int bathYear = prefs.getInt("bath_year", 1);

        bath.setSelectedDate(bathYear, bathMonth, bathDay);
        Log.i("calculateBath1: ", bath.toString());
        bath.setCurrentDate();
        Log.i("calculateBath1: ", bath.toString());
        bath.calculateMonth();
        bath.calculateDay();
        bath.calculateWeek();
        bath.getFutureBath();

        newBath.setText(bath.getFutureBath());
    }

    private void calculateVegg() {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int veggMonth = prefs.getInt("vegg_month", 1); // Integer.valueOf(bMonth));
        int veggDay = prefs.getInt("vegg_day", 1); // Integer.valueOf(bDay));
        int veggYear = prefs.getInt("vegg_year", 1);

        bath.setSelectedDate(veggYear, veggMonth, veggDay);
        Log.i("calculateVegg1: ", bath.toString());
        bath.setCurrentDate();
        Log.i("calculateVegg1: ", bath.toString());
        bath.calculateMonth();
        bath.calculateDay();
        bath.calculateWeek();
        bath.getFutureVegg();

        newVeggie.setText(bath.getFutureVegg());
        Log.i("vegg:",newVeggie.getText().toString());
    }


}