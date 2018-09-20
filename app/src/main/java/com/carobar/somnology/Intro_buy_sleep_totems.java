package com.carobar.somnology;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Intro_buy_sleep_totems extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        startAnimation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_buy_sleep_totems);

        Button btn1 = getParent().findViewById(R.id.introMainBtn4);
        btn1.setBackgroundResource(R.drawable.pagecontrol_normal_2x);

        if(SleepApp.get().checkSharedPref()){
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
            finish();
        }

        Button btnSignUp = findViewById(R.id.BtnInroBuySleepTotemsFinish);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                introFinish(view);
            }
        });
        startAnimation();
    }

    public void introFinish(View view) {
        final ImageView imageOwl = findViewById(R.id.intro4_owlIcon);
        final TextView speechTextView = findViewById(R.id.introSpeech4TxtView);
        Intent intent = new Intent(this, SignIn_Up.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        imageOwl.setVisibility(View.INVISIBLE);
        speechTextView.setVisibility(View.INVISIBLE);
    }

    public void startAnimation(){
        final ImageView imageOwl = findViewById(R.id.intro4_owlIcon);
        final TextView speechTextView = findViewById(R.id.introSpeech4TxtView);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce_object);
        imageOwl.startAnimation(animation);
        Handler handlerImgOwl = new Handler();
        handlerImgOwl.postDelayed(new Runnable() {
            @Override
            public void run() {

                imageOwl.startAnimation(animation);
                imageOwl.setVisibility(View.VISIBLE);
            }
        }, 100);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                speechTextView.startAnimation(animation);
                speechTextView.setVisibility(View.VISIBLE);
            }
        }, 350);
    }
}
