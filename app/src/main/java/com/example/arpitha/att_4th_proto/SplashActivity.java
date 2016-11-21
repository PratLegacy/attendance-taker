package com.example.arpitha.att_4th_proto;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.arpitha.att_4th_proto.R;


//  import com.example.pavan.kmtabalavidyalaya.R;
        import com.skyfishjy.library.RippleBackground;

/**
 * Created by Pavan on 31-03-2016.
 */
public class SplashActivity extends AppCompatActivity {
    MediaPlayer ringSplash;
    RippleBackground rippleBackground;
    ImageView imageView;

    //git set
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
       // ringSplash.start();
        rippleBackground.startRippleAnimation();
        listeners();
    }


    private void init() {
       /* android.support.v7.app.ActionBar actionBar =  getSupportActionBar();
        actionBar.hide();*/
       // ringSplash = MediaPlayer.create(this, R.raw.nuc);
        rippleBackground = (RippleBackground)findViewById(R.id.content);
        imageView = (ImageView)findViewById(R.id.splash);
    }

    private void listeners() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       ringSplash.stop();
                Intent i = new Intent(SplashActivity.this , MainActivity.class);
                finish();
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // ringSplash.stop();
    }
}
