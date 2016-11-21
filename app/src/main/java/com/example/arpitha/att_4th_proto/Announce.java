package com.example.arpitha.att_4th_proto;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Announce extends AppCompatActivity {

    // Constant Value for Splash Screen time visibility
   // private static int SPLASH_SCREEN_TIME = 3000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce);

        /*// Create object of Handler class and call method postDelayed to make
        // Splash Screen visible for SPLASH_SCREEN_TIME
        new Handler().postDelayed(new Runnable() {

            public void run() {
                // This is method will be executed when SPLASH_SCREEN_TIME is
                // over, Now you can call your Home Screen
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);

                // Finish Current Splash Screen, as it should be visible only
                // once when application start
                finish();
            }

        }, SPLASH_SCREEN_TIME);*/
    }
}


