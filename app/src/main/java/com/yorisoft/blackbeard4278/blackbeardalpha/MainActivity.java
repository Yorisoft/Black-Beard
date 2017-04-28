
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
import android.support.v7.app.NotificationCompat;
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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import org.w3c.dom.Text;

import java.io.File;
import java.util.prefs.PreferenceChangeListener;

import static android.R.attr.tag;


public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notific;
    private static final int notificID = 26535346;
    private AgeCalculation age = null;
    private Schedules bath = null;

    Button editBttn;
    Button saveButton;
    ImageButton moreEdits;

    TextView ageOne, weightOne, lengthOne, petName, newBath, lastBath, newVeggie, oldVeggie, newShedd, oldShedd, newBM, lastBM, newUvb, oldUvb,
            newVisit,oldVisit;

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
        notific = new NotificationCompat.Builder(this);
        notific.setAutoCancel(true);

        ageOne = (TextView) findViewById(R.id.ageOne);
        weightOne = (TextView) findViewById(R.id.weightOne);
        lengthOne = (TextView) findViewById(R.id.lengthOne);
        petName = (TextView) findViewById(R.id.petName);
        newBath = (TextView) findViewById(R.id.newBath);
        lastBath = (TextView) findViewById(R.id.lastBath);
        newVeggie = (TextView) findViewById(R.id.newFood);
        oldVeggie = (TextView) findViewById(R.id.lastFood);
        newShedd = (TextView) findViewById(R.id.newShed);
        oldShedd = (TextView) findViewById(R.id.oldShed);
        newBM = (TextView) findViewById(R.id.newBM);
        lastBM = (TextView) findViewById(R.id.lastBM);
        newUvb = (TextView) findViewById(R.id.newUvb);
        oldUvb = (TextView) findViewById(R.id.oldUvb);
        newVisit= (TextView) findViewById(R.id.newVisit);
        oldVisit= (TextView) findViewById(R.id.oldVisit);

        editBttn = (Button) findViewById(R.id.editBttn);
        saveButton = (Button) findViewById(R.id.saveButton);
        moreEdits = (ImageButton) findViewById(R.id.moreButton);

        petPicture = (ImageView) findViewById(R.id.imageView2);

        AdView adView =  (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);


//
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        String profile = prefs.getString("image_path", "choose image");

//populating views with values. if statements in case they are empty.
        getValues();


        Uri picturePath = Uri.parse(profile);

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




        DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
      //  newDrawerLayout.addView(adView);

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
//Age
        int birth_month = prefs.getInt("birth_month", 0);
        int birth_day = prefs.getInt("birth_day", 0);
        int birth_year = prefs.getInt("birth_year", 0);

        //String savedAge = prefs.getString("dragon_age", "");

        String weight = prefs.getString("dragon_weight", "");
        String length = prefs.getString("dragon_length", "");
//Bath
        int bathMonth = prefs.getInt("bath_month", 0);
        int bathDay = prefs.getInt("bath_day", 0);
        String old_bath = prefs.getString("bathed_date", "Last Bathed?");
//Vegg
        int veggMonth = prefs.getInt("vegg_month", 0);
        int veggDay = prefs.getInt("vegg_day", 0);
        String old_vegg = prefs.getString("veggies_date", "oldVegg");
//Shedd
        int sheddMonth = prefs.getInt("shedd_month", 0);
        int sheddDay = prefs.getInt("shedd_day", 0);
        int sheddYear = prefs.getInt("shedd_year", 0);
        String old_Shedd = prefs.getString("shedding_date", "oldShedd");
//BM
        int bmMonth = prefs.getInt("bm_month", 0);
        int bmDay = prefs.getInt("bm_day", 0);
        int bmYear = prefs.getInt("bm_year", 0);
        String old_BM = prefs.getString("BM_date", "oldBM");
//UVB
        int uvbMonth = prefs.getInt("uvb_month", 0);
        int uvbDay = prefs.getInt("uvb_day", 0);
        int uvbYear = prefs.getInt("uvb_year", 0);
        String old_UVB = prefs.getString("UVB_date", "oldUVB");
//VETVisit
        int vetMonth = prefs.getInt("vet_month", 0);
        int vetDay = prefs.getInt("vet_day", 0);
        int vetYear = prefs.getInt("vet_year", 0);
        String old_VET = prefs.getString("VET_date", "oldVET");


        if (birth_day == 0 && birth_month == 0) {
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

        } else {

            calculateBath();

        }
        if (veggDay == 0 && veggMonth == 0) {

        } else {

            calculateVegg();
        }

        if (old_vegg.equals("oldVegg")) {

        } else {
            oldVeggie.setText(old_vegg);
        }

        if (sheddDay == 0 && sheddMonth == 0) {

        } else {
            calculateShedd();
        }

        if (old_Shedd.equals("oldShedd")) {

        } else {

            oldShedd.setText(sheddMonth + "/" + sheddDay);
        }
        if (bmDay == 0 && bmMonth == 0) {

        } else {
            calculateBM();
        }
        if (old_BM.equals("oldBM")) {

        } else {
            lastBM.setText(old_BM);
        }

        if (uvbDay == 0 && uvbMonth == 0) {

        } else {
            calculateUVB();
        }
        if (old_UVB.equals("oldUVB")) {

        } else {
            oldUvb.setText(old_UVB);
        }

        if(vetDay == 0 && vetMonth == 0){

        } else {
            calculateVET();
        }
        if(old_VET.equals("oldVET")){

        } else {
            oldVisit.setText(old_VET);
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

    //Age
    private void calculateAge() {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int ageMonth = prefs.getInt("birth_month", 1); // Integer.valueOf(bMonth));
        int ageDay = prefs.getInt("birth_day", 1); // Integer.valueOf(bDay));
        int ageYear = prefs.getInt("birth_year", 1);

        age.setDateOfBirth(ageYear, ageMonth, ageDay);
        age.setCurrentDate();
        Log.i("calculateAge: ", age.toString());
        age.calculateYear();
        age.calculateMonth();
        age.calculateDay();
        age.calculateWeek();
        ageOne.setText(age.getResult());
    }

    //Bath
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

    //Veggies
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
        Log.i("vegg:", newVeggie.getText().toString());
    }

    //Shedding
    private void calculateShedd() {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int sheddMonth = prefs.getInt("shedd_month", 1); // Integer.valueOf(bMonth));
        int sheddDay = prefs.getInt("shedd_day", 1); // Integer.valueOf(bDay));
        int sheddYear = prefs.getInt("shedd_year", 1);

        bath.setSelectedDate(sheddYear, sheddMonth, sheddDay);
        Log.i("calculateShedd1: ", bath.toString());
        bath.setCurrentDate();
        Log.i("calculateShedd1: ", bath.toString());
        bath.calculateMonth();
        bath.calculateDay();
        bath.calculateWeek();
        bath.getFutureShedd();

        newShedd.setText(bath.getFutureShedd());
        //      newShedd.setText(sheddMonth+"/"+sheddDay+"/"+sheddYear);

    }

    //B.M.
    private void calculateBM() {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int bmMonth = prefs.getInt("bm_month", 0);
        int bmDay = prefs.getInt("bm_day", 0);
        int bmYear = prefs.getInt("bm_year", 0);

        bath.setSelectedDate(bmYear, bmMonth, bmDay);
        Log.i("calculateBath1: ", bath.toString());
        bath.setCurrentDate();
        Log.i("calculateBath1: ", bath.toString());
        bath.calculateMonth();
        bath.calculateDay();
        bath.calculateWeek();
        bath.getFutureBM();

        newBM.setText(bath.getFutureBM());

    }

    //UVB
    private void calculateUVB() {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int uvbMonth = prefs.getInt("uvb_month", 0);
        int uvbDay = prefs.getInt("uvb_day", 0);
        int uvbYear = prefs.getInt("uvb_year", 0);

        bath.setSelectedDate(uvbYear, uvbMonth, uvbDay);
        Log.i("calculateBath1: ", bath.toString());
        bath.setCurrentDate();
        Log.i("calculateBath1: ", bath.toString());
        bath.calculateMonth();
        bath.calculateDay();
        bath.calculateWeek();
        bath.getFutureUVB();

        newUvb.setText(bath.getFutureUVB());

    }

    //VETVisit
    private void calculateVET(){
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        int vetMonth = prefs.getInt("vet_month", 0);
        int vetDay = prefs.getInt("vet_day", 0);
        int vetYear = prefs.getInt("vet_year", 0);

        bath.setSelectedDate(vetYear, vetMonth, vetDay);
        Log.i("calculateBath1: ", bath.toString());
        bath.setCurrentDate();
        Log.i("calculateBath1: ", bath.toString());
        bath.calculateMonth();
        bath.calculateDay();
        bath.calculateWeek();
        bath.getFutureVET();

        newVisit.setText(bath.getFutureVET());

    }

}