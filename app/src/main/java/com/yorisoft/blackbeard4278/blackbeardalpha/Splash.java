package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

    }

}
