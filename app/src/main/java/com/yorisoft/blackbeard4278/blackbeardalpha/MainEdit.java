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
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainEdit extends AppCompatActivity {


    public static final int IMAGE_GALLERY_REQUEST = 20;
    static final int ageDatepicker = 0;
    static final int scheduleDatepicker = 1;
    private AgeCalculation age = null;
    private Schedules schd = null;
    private int bYear =2017;
    private int bMonth =0;
    private int bDay =1;
    private int sYear =2017;
    private int sMonth =0;
    private int sDay =1;
    private String futureDay;
    TextView ageSmall,agePreUpdate,imgFile,bathSmall,bathView;
    EditText nameEdit,weightEdit,lengthEdit;
    Button bttnSave,ageEditBttn,bathEditBttn;
    ImageButton imgEditBttn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_edit_01);


        age=new AgeCalculation();
        schd=new Schedules();

        nameEdit = (EditText)findViewById(R.id.nameEdit);
        weightEdit = (EditText) findViewById(R.id.weightEdit);
        lengthEdit = (EditText) findViewById(R.id.lengthEdit);


        ageSmall = (TextView)findViewById(R.id.ageSmall);
        agePreUpdate = (TextView)findViewById(R.id.agePreUpdate);
        imgFile = (TextView) findViewById(R.id.imgFile);
        bathSmall = (TextView)findViewById(R.id.bathSmall);
        bathView =(TextView)findViewById(R.id.bathView);


        bathEditBttn = (Button) findViewById(R.id.bathEditBttn);
        bttnSave = (Button)findViewById(R.id.bttnSave);
        ageEditBttn = (Button)findViewById(R.id.ageEditBttn);
        imgEditBttn = (ImageButton)findViewById(R.id.imgEditBttn);


        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        String nameHint = prefs.getString("dragon_name","Pet name!");
        String ageHint = prefs.getString("birth_date","Birthday");
        String birthHint = prefs.getString("dragon_age","Age");
        String weightHint = prefs.getString("dragon_weight","weight");
        String lengthHint = prefs.getString("dragon_length","length");
        String bathingHint = prefs.getString("bathed_date","Last Bathed?");
        String upcomingBathHint = prefs.getString("bath_future","Last bathed");

        nameEdit.setText(nameHint);
        agePreUpdate.setText(ageHint);
        ageSmall.setText(birthHint);
        bathSmall.setText(upcomingBathHint);
        weightEdit.setText(weightHint);
        lengthEdit.setText(lengthHint);
        bathView.setText(bathingHint);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                        sYear,sMonth,sDay);


        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener ageDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            bYear =selectedYear;
            bMonth =selectedMonth;
            bDay =selectedDay;
            age.setDateOfBirth(bYear, bMonth, bDay);
            agePreUpdate.setText((bMonth+1) +"/"+bDay+"/"+bYear);

       //     SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
       //     SharedPreferences.Editor prefEdit = prefs.edit();
       //     prefEdit.putInt("birth_month",Integer.valueOf(bMonth));
      //      prefEdit.putInt("birth_day",Integer.valueOf(bDay));
       //     prefEdit.putInt("birth_year", Integer.valueOf(bYear));
      //      prefEdit.apply();
//
            calculateAge();

        }
    };

    private DatePickerDialog.OnDateSetListener schdDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            sYear =selectedYear;
            sMonth =selectedMonth;
            sDay =selectedDay;
            bathView.setText((sMonth+1) +"/"+sDay);
            schd.setSelectedDate(sYear, sMonth, sDay);
            calculateDate();

        }
    };

    public void DatePickerMethod (View v) {
        switch (v.getId()) {
            case R.id.ageEditBttn:
                showDialog(ageDatepicker);
                age.getCurrentDate();
                break;
            case R.id.bathEditBttn:
                showDialog(scheduleDatepicker);
                schd.getCurrentDate();

            default:
                break;
        }
    }
    private void calculateAge()
    {
        age.calculateYear();
        age.calculateMonth();
        age.calculateDay();
        age.calculateWeek();
        Toast.makeText(getBaseContext(), "set to"+age.getResult() , Toast.LENGTH_SHORT).show();
        ageSmall.setText(age.getResult());
    }

    private void calculateDate() {
        schd.calculateMonth();
        schd.calculateDay();
        schd.calculateWeek();
        schd.getFutureDate();
        Toast.makeText(getBaseContext(), "set to"+schd.getResult() , Toast.LENGTH_SHORT).show();
        bathSmall.setText(schd.getResult());
        futureDay = schd.getFutureDate();
    }

    public void saveInfo(View view) {
        SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("dragon_name", nameEdit.getText().toString());
        prefEdit.putString("dragon_age", ageSmall.getText().toString());
        prefEdit.putString("dragon_weight", weightEdit.getText().toString());
        prefEdit.putString("dragon_length", lengthEdit.getText().toString());
        prefEdit.putString("birth_date", agePreUpdate.getText().toString());
        prefEdit.putString("bathed_date",bathView.getText().toString());
        prefEdit.putString("bath_future",futureDay);


        prefEdit.apply();

        Intent update = new Intent(this, MainActivity.class);
        startActivity(update);

        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
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
        if(resultCode == RESULT_OK) {

        }
        if(requestCode == IMAGE_GALLERY_REQUEST) {

            Uri imgUri = data.getData();
            String path= imgUri.getPath();
            String fileName=path.substring(path.lastIndexOf("/")+1);
            imgFile.setText(fileName);

            try {
                InputStream nInputStream = getContentResolver().openInputStream(imgUri);

                Bitmap nImage = BitmapFactory.decodeStream(nInputStream);

                String picturePath = String.valueOf(imgUri);

    //            Picasso.with(this)
      //                  .load(imgUri)
       //                 .centerCrop()
        //                .fit()
         //               .into(imgEditBttn);

                Glide.with(this)
                        .load(imgUri)
                        .centerCrop()
                        .into(imgEditBttn);

//Picasso as workaround.
                //BitmapDrawable bitToImage = new BitmapDrawable(getResources(),nImage);
               // imgEditBttn.setBackground(bitToImage);


//bitmap into byteArray base64 in order to save into prefs.
                ByteArrayOutputStream bToS = new ByteArrayOutputStream();
                nImage.compress(Bitmap.CompressFormat.PNG,100, bToS);
                byte [] b=bToS.toByteArray();
                String temp= Base64.encodeToString(b, Base64.DEFAULT);
                Log.d("Image Log:", temp);

                SharedPreferences prefs = getSharedPreferences("basic_dragon_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("image_path",picturePath);
                prefEdit.apply();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Unable to open",Toast.LENGTH_LONG).show();
            }
        }
    }


}

