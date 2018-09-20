package com.carobar.somnology;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Intro_complete_profile extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        startAnimation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_complete_profile);

        Button btn1 = getParent().findViewById(R.id.introMainBtn3);
        btn1.setBackgroundResource(R.drawable.pagecontrol_normal_2x);

        if(SleepApp.get().checkSharedPref()){
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
            finish();
        }

        Button btnSignUp = findViewById(R.id.BtnInroCompleteProfileNext);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                introBuySleepTotems(view);
            }
        });
        startAnimation();
    }

    public void introBuySleepTotems(View view) {
        final ImageView imageOwl = findViewById(R.id.intro3_owlIcon);
        final TextView speechTextView = findViewById(R.id.introSpeech3TxtView);
        Intent intent = new Intent(this, Intro_buy_sleep_totems.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        imageOwl.setVisibility(View.INVISIBLE);
        speechTextView.setVisibility(View.INVISIBLE);
    }
    public void startAnimation(){
        final ImageView imageOwl = findViewById(R.id.intro3_owlIcon);
        final TextView speechTextView = findViewById(R.id.introSpeech3TxtView);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce_object);
        imageOwl.startAnimation(animation);
        Handler handlerImgOwl = new Handler();
        handlerImgOwl.postDelayed(new Runnable() {
            @Override
            public void run() {

                imageOwl.startAnimation(animation);
                imageOwl.setVisibility(View.VISIBLE);
            }
        }, 500);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                speechTextView.startAnimation(animation);
                speechTextView.setVisibility(View.VISIBLE);
            }
        }, 700);
    }
}
