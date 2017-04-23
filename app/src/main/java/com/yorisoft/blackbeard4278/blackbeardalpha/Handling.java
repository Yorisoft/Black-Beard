package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yoris on 3/14/2017.
 */

public class Handling extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handling);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
