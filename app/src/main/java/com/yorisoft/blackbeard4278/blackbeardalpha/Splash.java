package com.yorisoft.blackbeard4278.blackbeardalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splashScreen = new Thread() {
            public void run () {
                try {
                    sleep(4000);
                } catch (InterruptedException y){
                    y.printStackTrace();
                } finally {
                    Intent mainActivity = new Intent("com.yorisoft.blackbeard4278.blackbeard.MAINACTIVITY");
                    startActivity(mainActivity);

                }
            }
        };
        splashScreen.start();
    }
    @Override
    protected void onPause (){
        super.onPause();
        finish();
    }


}
