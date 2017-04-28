package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainEdit extends AppCompatActivity {


    public static final int IMAGE_GALLERY_REQUEST = 20;
    static final int ageDatepicker = 0;
    static final int scheduleDatepicker = 1;
    static final int veggieDatepicker = 2;
    static final int sheddingDatepicker = 3;
    static final int BMDatepicker = 4;
    static final int UVBDatePicker = 5;
    static final int VetDatePicker = 6;
    private AgeCalculation age = null;
    private Schedules schd = null;
    private int bYear = 2017;
    private int bMonth = 0;
    private int bDay = 1;
    private int sYear = 2017;
    private int sMonth = 0;
    private int sDay = 1;
    private String futureDay;
    TextView ageSmall, agePreUpdate, imgFile, bathSmall, bathView,veggieView,veggSmallView,sheddingView,shedSmall,BMView,bmSmall,UVBEditView,uvbSmall,vetVisitView,visitSmall;
    EditText nameEdit, weightEdit, lengthEdit;
    Button bttnSave, ageEditBttn, bathEditBttn,veggieEdit,sheddingEdit,bmEdit,UVBEditBttn,vetVisitEdit;
    ImageButton imgEditBttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_edit_01);


        age = new AgeCalculation();
        schd = new Schedules();

        nameEdit = (EditText) findViewById(R.id.nameEdit);
        nameEdit.setSelectAllOnFocus(true);
        weightEdit = (EditText) findViewById(R.id.weightEdit);
        weightEdit.setSelectAllOnFocus(true);
        lengthEdit = (EditText) findViewById(R.id.lengthEdit);
        lengthEdit.setSelectAllOnFocus(true);


        ageSmall = (TextView) findViewById(R.id.ageSmall); // label with age calculation
        agePreUpdate = (TextView) findViewById(R.id.agePreUpdate);
        imgFile = (TextView) findViewById(R.id.imgFile);
        bathSmall = (TextView) findViewById(R.id.bathSmall);
        bathView = (TextView) findViewById(R.id.bathView);
        veggSmallView = (TextView) findViewById(R.id.vegSmall);
        veggieView = (TextView) findViewById(R.id.veggiesView);
        sheddingView = (TextView) findViewById(R.id.sheddingView);
        shedSmall = (TextView) findViewById(R.id.shedSmall);
        BMView =(TextView)findViewById(R.id.BMView);
        bmSmall =(TextView)findViewById(R.id.bmSmall);
        UVBEditView =(TextView)findViewById(R.id.UVBEditView);
        uvbSmall = (TextView)findViewById(R.id.uvbSmall);
        vetVisitView =(TextView)findViewById(R.id.vetVisitView);
        visitSmall =(TextView)findViewById(R.id.visitSmall);

        imgEditBttn = (ImageButton) findViewById(R.id.imgEditBttn);
        ageEditBttn = (Button) findViewById(R.id.ageEditBttn);
        bathEditBttn = (Button) findViewById(R.id.bathEditBttn);
        veggieEdit = (Button) findViewById(R.id.veggieEdit);
        sheddingEdit = (Button) findViewById(R.id.sheddingEdit);
        bmEdit = (Button) findViewById(R.id.bmEdit);
        UVBEditBttn = (Button)findViewById(R.id.UVBEditBttn);
        vetVisitEdit= (Button)findViewById(R.id.vetVisitEdit);


        bttnSave = (Button) findViewById(R.id.bttnSave);



        getValues();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getValues() {

        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        String nameHint = prefs.getString("dragon_name", "Pet name!");
        String ageHint = prefs.getString("birth_date", "Birthday");
        String birthHint = prefs.getString("dragon_age", "Age");
        String weightHint = prefs.getString("dragon_weight", "weight");
        String lengthHint = prefs.getString("dragon_length", "length");
        String bathingHint = prefs.getString("bathed_date", "Last Bathed?");
        String veggHint = prefs.getString("veggies_date", "Greens!");
        String sheddingHint = prefs.getString("shedding_date", "Shedding Day!");
        String bmHint = prefs.getString("BM_date", "Bowel Movement");
        String uvbHint = prefs.getString("UVB_date", "UVB Last Change");
        String vetHint = prefs.getString("VET_date", "Last Vet Visit");

        String lastBathHint = prefs.getString("bath_future", "Last bathed:Every 7 days");
        String smallVeggHint = prefs.getString("veggies_small", "Last veggie feeding:Every 4 days");
        String smallSheddHint = prefs.getString("Shedd_small", "Shedding Start-date");
        String smallBmHint = prefs.getString("bm_small", "Last B.M.");
        String smallUvbHint = prefs.getString("uvb_small", "Date First Used");
        String smallVetHint = prefs.getString("vet_small", "Last Vet Visit");



        if (nameHint.equals("Pet name!")) {

        } else {
            nameEdit.setText(nameHint);
        }

        if (ageHint.equals("Birthday")) {

        } else {
            agePreUpdate.setText(ageHint);
        }

        ageSmall.setText(birthHint);
        bathSmall.setText(lastBathHint);
        veggSmallView.setText(smallVeggHint);
        shedSmall.setText(smallSheddHint);
        bmSmall.setText(smallBmHint);
        uvbSmall.setText(smallUvbHint);
        visitSmall.setText(smallVetHint);

        if (weightHint.equals("weight")) {

        } else {
            weightEdit.setText(weightHint);
        }

        if (lengthHint.equals("length")) {

        } else {
            lengthEdit.setText(lengthHint);
        }
        if (bathingHint.equals("Last Bathed?")) {

        } else {
            bathView.setText(bathingHint);
        }
        if(veggHint.equals("Greens!")){

        } else {
            veggieView.setText(veggHint);
        }
        if(sheddingHint.equals("Shedding Day!")){

        } else {
            sheddingView.setText(sheddingHint);
        }
        if(bmHint.equals("Bowel Movement")){

        }else{
            BMView.setText(bmHint);
        }
        if(uvbHint.equals("UVB Last Change")){

        } else {
            UVBEditView.setText(uvbHint);
        }
        if(vetHint.equals("Last Vet Visit")){

        } else {
            vetVisitView.setText(uvbHint);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case ageDatepicker:
                return new DatePickerDialog(this,
                        ageDateSetListener,
                        bYear, bMonth, bDay);

            case scheduleDatepicker:
                return new DatePickerDialog(this,
                        schdDateSetListener,
                        sYear, sMonth, sDay);

            case veggieDatepicker:
                return new DatePickerDialog(this,
                        veggieDateSetListener,
                        sYear, sMonth, sDay);

            case sheddingDatepicker:
                return new DatePickerDialog(this,
                        sheddingDateSetListener,
                        sYear, sMonth, sDay);

            case BMDatepicker:
                return new DatePickerDialog(this,
                        BmDateSetListener,
                        sYear, sMonth, sDay);

            case UVBDatePicker:
                return new DatePickerDialog(this,
                        UVBDateSetListener,
                        sYear, sMonth, sDay);

            case VetDatePicker:
                return new DatePickerDialog(this,
                        VetDateSetListener,
                        sYear, sMonth, sDay);
        }
        return null;
    }

    // Age
    private DatePickerDialog.OnDateSetListener ageDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            bYear = selectedYear;
            bMonth = selectedMonth;
            bDay = selectedDay;
            age.setDateOfBirth(bYear, bMonth, bDay);
            agePreUpdate.setText((bMonth + 1) + "/" + bDay + "/" + bYear);

            SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putInt("birth_month", bMonth); // Integer.valueOf(bMonth));
            prefEdit.putInt("birth_day", bDay); // Integer.valueOf(bDay));
            prefEdit.putInt("birth_year", bYear); //  Integer.valueOf(bYear));
            prefEdit.apply();
//
            calculateAge();

        }
    };
    // Bath
    private DatePickerDialog.OnDateSetListener schdDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            sYear = selectedYear;
            sMonth = selectedMonth;
            sDay = selectedDay;
            bathView.setText((sMonth + 1) + "/" + sDay);
            schd.setSelectedDate(sYear, sMonth, sDay);

            SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putInt("bath_month", sMonth); // Integer.valueOf(bMonth));
            prefEdit.putInt("bath_day", sDay); // Integer.valueOf(bDay));
            prefEdit.putInt("bath_year", sYear); //  Integer.valueOf(bYear));
            prefEdit.apply();

            calculateBath();

        }
    };
//Veggies
    private DatePickerDialog.OnDateSetListener veggieDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            sYear = selectedYear;
            sMonth = selectedMonth;
            sDay = selectedDay;
            veggieView.setText((sMonth + 1) + "/" + sDay);
            schd.setSelectedDate(sYear, sMonth, sDay);

            SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putInt("vegg_month", sMonth); // Integer.valueOf(bMonth));
            prefEdit.putInt("vegg_day", sDay); // Integer.valueOf(bDay));
            prefEdit.putInt("vegg_year", sYear); //  Integer.valueOf(bYear));
            prefEdit.apply();

            calculateVegg();

        }
    };
//Shedding
    private DatePickerDialog.OnDateSetListener sheddingDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int selectedYear,
                          int selectedMonth, int selectedDay) {
        sYear = selectedYear;
        sMonth = selectedMonth;
        sDay = selectedDay;
        sheddingView.setText((sMonth + 1) + "/" + sDay);
        schd.setSelectedDate(sYear, sMonth, sDay);

        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("shedd_month", sMonth); // Integer.valueOf(bMonth));
        prefEdit.putInt("shedd_day", sDay); // Integer.valueOf(bDay));
        prefEdit.putInt("shedd_year", sYear); //  Integer.valueOf(bYear));
        prefEdit.apply();

        calculateShedd();

    }
};
//BM
    private DatePickerDialog.OnDateSetListener BmDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                          int selectedMonth, int selectedDay) {
        sYear = selectedYear;
        sMonth = selectedMonth;
        sDay = selectedDay;
        BMView.setText((sMonth + 1) + "/" + sDay);
        schd.setSelectedDate(sYear, sMonth, sDay);

        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("bm_month", sMonth); // Integer.valueOf(bMonth));
        prefEdit.putInt("bm_day", sDay); // Integer.valueOf(bDay));
        prefEdit.putInt("bm_year", sYear); //  Integer.valueOf(bYear));
        prefEdit.apply();

        calculateBM();

    }
};
//UVB
    private DatePickerDialog.OnDateSetListener UVBDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            sYear = selectedYear;
            sMonth = selectedMonth;
            sDay = selectedDay;
            UVBEditView.setText((sMonth + 1) + "/" + sDay);
            schd.setSelectedDate(sYear, sMonth, sDay);

            SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putInt("uvb_month", sMonth); // Integer.valueOf(bMonth));
            prefEdit.putInt("uvb_day", sDay); // Integer.valueOf(bDay));
            prefEdit.putInt("uvb_year", sYear); //  Integer.valueOf(bYear));
            prefEdit.apply();

            calculateUVB();

        }

    };
//VetVisit
    private DatePickerDialog.OnDateSetListener VetDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            sYear = selectedYear;
            sMonth = selectedMonth;
            sDay = selectedDay;
            vetVisitView.setText((sMonth + 1) + "/" + sDay);
            schd.setSelectedDate(sYear, sMonth, sDay);

            SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putInt("vet_month", sMonth); // Integer.valueOf(bMonth));
            prefEdit.putInt("vet_day", sDay); // Integer.valueOf(bDay));
            prefEdit.putInt("vet_year", sYear); //  Integer.valueOf(bYear));
            prefEdit.apply();

            calculateVET();

        }
    };

    public void DatePickerMethod(View v) {
        switch (v.getId()) {
            case R.id.ageEditBttn:
                showDialog(ageDatepicker);
                age.getCurrentDate();
                break;
            case R.id.bathEditBttn:
                showDialog(scheduleDatepicker);
                schd.getCurrentDate();
                break;
            case R.id.veggieEdit:
                showDialog(veggieDatepicker);
                schd.getCurrentDate();
                break;
            case R.id.sheddingEdit:
                showDialog(sheddingDatepicker);
                schd.getCurrentDate();
                break;
            case R.id.bmEdit:
                showDialog(BMDatepicker);
                schd.getCurrentDate();
                break;
            case R.id.UVBEditBttn:
                showDialog(UVBDatePicker);
                schd.getCurrentDate();
                break;
            case R.id.vetVisitEdit:
                showDialog(VetDatePicker);
                schd.getCurrentDate();
                break;


            default:
                break;
        }
    }

    // Age
    private void calculateAge() {
        age.calculateYear();
        age.calculateMonth();
        age.calculateDay();
        age.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + age.getResult(), Toast.LENGTH_SHORT).show();
        ageSmall.setText(age.getResult());
    }

    // Bath
    private void calculateBath() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + schd.getResult(), Toast.LENGTH_SHORT).show();
        bathSmall.setText(schd.getResult());

    }
    // Veggies
    private void calculateVegg() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + schd.getResult(), Toast.LENGTH_SHORT).show();
        veggSmallView.setText(schd.getResult());

    }
    //Shedding
    private void calculateShedd() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + schd.getResult(), Toast.LENGTH_SHORT).show();
        shedSmall.setText(schd.getFutureShedd());

    }
    //BM
    private void calculateBM() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + schd.getResult(), Toast.LENGTH_SHORT).show();
        bmSmall.setText(schd.getFutureBM());

    }
    //UVB
    private void calculateUVB() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + schd.getResult(), Toast.LENGTH_SHORT).show();
        uvbSmall.setText(schd.getFutureUVB());

    }
    //VETVisit
    private void calculateVET() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        Toast.makeText(getBaseContext(), "set to" + schd.getResult(), Toast.LENGTH_SHORT).show();
        visitSmall.setText(schd.getFutureVET());

    }

    public void saveInfo(View view) {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("dragon_name", nameEdit.getText().toString());
        prefEdit.putString("dragon_age", ageSmall.getText().toString());
        prefEdit.putString("dragon_weight", weightEdit.getText().toString());
        prefEdit.putString("dragon_length", lengthEdit.getText().toString());
        prefEdit.putString("birth_date", agePreUpdate.getText().toString());
        prefEdit.putString("bathed_date", bathView.getText().toString());
        prefEdit.putString("veggies_date", veggieView.getText().toString());
        prefEdit.putString("shedding_date", sheddingView.getText().toString());
        prefEdit.putString("BM_date", BMView.getText().toString());
        prefEdit.putString("UVB_date", UVBEditView.getText().toString());
        prefEdit.putString("VET_date", vetVisitView.getText().toString());


        prefEdit.apply();

        Intent update = new Intent(this, MainActivity.class);
        startActivity(update);

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void pickImage(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        String pictureDirectoryPath = pictureDirectory.getPath();
        Uri picture = Uri.parse(pictureDirectoryPath);

        photoPickerIntent.setDataAndType(picture, "image/*");

        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {

        }
        if (requestCode == IMAGE_GALLERY_REQUEST) {

            Uri imgUri = data.getData();
            String path = imgUri.getPath();
            String fileName = path.substring(path.lastIndexOf("/") + 1);
            imgFile.setText(fileName);

            try {
                InputStream nInputStream = getContentResolver().openInputStream(imgUri);

                Bitmap nImage = BitmapFactory.decodeStream(nInputStream);

                String picturePath = String.valueOf(imgUri);

                Glide.with(this)
                        .load(imgUri)
                        .centerCrop()
                        .into(imgEditBttn);

//bitmap into byteArray base64 in order to save into prefs.
                ByteArrayOutputStream bToS = new ByteArrayOutputStream();
                nImage.compress(Bitmap.CompressFormat.PNG, 100, bToS);
                byte[] b = bToS.toByteArray();
                String temp = Base64.encodeToString(b, Base64.DEFAULT);
                Log.d("Image Log:", temp);

                SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("image_path", picturePath);
                prefEdit.apply();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Unable to open", Toast.LENGTH_LONG).show();
            }
        }
    }


}