package com.carobar.somnology;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.carobar.somnology.core.MPagerAdapter;

public class MainIntro extends AppCompatActivity {
    protected ViewPager mPager;
    protected int[] layouts = {R.layout.activity_intro__tap_the_owl, R.layout.activity_intro__report_tab, R.layout.activity_intro_complete_profile, R.layout.activity_intro_buy_sleep_totems};
    protected MPagerAdapter mPagerAdapter;
    public Context ctxt;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;

    public TextView speechText;
    public ImageView intro_owl;



    @Override
    public void onBackPressed() {
        int currentPage = mPager.getCurrentItem();
        if(currentPage == 0) {
            moveTaskToBack(true);
        }else{
            mPager.setCurrentItem(currentPage - 1);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intro);

        ctxt = this;

        mPager = (ViewPager) findViewById(R.id.introViewPager);
        mPagerAdapter = new MPagerAdapter(layouts, this);
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(viewListner);

        btn1 = findViewById(R.id.introMainBtn1);
        btn1.setBackgroundResource(R.drawable.pagecontrol_selected_2x);
        btn2 = findViewById(R.id.introMainBtn2);
        btn3 = findViewById(R.id.introMainBtn3);
        btn4 = findViewById(R.id.introMainBtn4);

    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            btn1.setBackgroundResource(R.drawable.pagecontrol_normal_2x);
            btn2.setBackgroundResource(R.drawable.pagecontrol_normal_2x);
            btn3.setBackgroundResource(R.drawable.pagecontrol_normal_2x);
            btn4.setBackgroundResource(R.drawable.pagecontrol_normal_2x);
            if(position == 0) {

                btn1.setBackgroundResource(R.drawable.pagecontrol_selected_2x);
                Button nextButton = findViewById(R.id.BtnInroTapTheOwlNext);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPager.setCurrentItem(1);
                    }
                });
                intro_owl = findViewById(R.id.intro1_owlIcon);
//                intro_owl.setImageAlpha(0);
                speechText = findViewById(R.id.introSpeechTxtView);
//                startAnimation(intro_owl, speechText);


            }
            if(position == 1) {
                btn2.setBackgroundResource(R.drawable.pagecontrol_selected_2x);
                Button nextButton = findViewById(R.id.BtnInroReportTabNext);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPager.setCurrentItem(2);
                    }
                });
                intro_owl = findViewById(R.id.intro2_owlIcon);
//                intro_owl.setImageAlpha(0);
                speechText = findViewById(R.id.introSpeech2TxtView);
//                startAnimation(intro_owl, speechText);
            }
            if(position == 2) {
                btn3.setBackgroundResource(R.drawable.pagecontrol_selected_2x);
                Button nextButton = findViewById(R.id.BtnInroCompleteProfileNext);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPager.setCurrentItem(3);
                    }
                });
                intro_owl = findViewById(R.id.intro3_owlIcon);
//                intro_owl.setImageAlpha(0);
                speechText = findViewById(R.id.introSpeech3TxtView);
//                startAnimation(intro_owl, speechText);
            }
            if(position == 3) {
                btn4.setBackgroundResource(R.drawable.pagecontrol_selected_2x);
                Button nextButton = findViewById(R.id.BtnInroBuySleepTotemsFinish);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ctxt, SignIn_Up.class);
                        ctxt.startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                });
                intro_owl = findViewById(R.id.intro4_owlIcon);
//                intro_owl.setImageAlpha(0);
                speechText = findViewById(R.id.introSpeech4TxtView);
//                startAnimation(intro_owl, speechText);
            }

        }

        @Override
        public void onPageSelected(int position) {


        }

        @Override
        public void onPageScrollStateChanged(int state) {
            System.out.print(state);
            if(state==0){
//                intro_owl.setImageAlpha(0);
//                intro_owl.setVisibility(View.VISIBLE);
//                speechText.setVisibility(View.VISIBLE);
                startAnimation(intro_owl, speechText);
            }
//            else{
//                speechText.setScaleX(0.3f);
//                speechText.setScaleY(0.3f);
//                intro_owl.setScaleX(0.3f);
//                intro_owl.setScaleY(0.3f);
//                //intro_owl.setVisibility(View.INVISIBLE);
//            }
        }
    };
    public void startAnimation(ImageView owl, TextView speechText){
        final ImageView imageOwl = owl;
        final TextView speechTextView = speechText;
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce_object);
//        imageOwl.startAnimation(animation);
        Handler handlerImgOwl = new Handler();
        handlerImgOwl.postDelayed(new Runnable() {
            @Override
            public void run() {

                imageOwl.startAnimation(animation);
//                imageOwl.setImageAlpha(1);
//                if(Build.VERSION.SDK_INT > 15) {
//                    imageOwl.setImageAlpha(255);
//                }
//                else{
//                    imageOwl.setAlpha(1);
//                }

//                imageOwl.setVisibility(View.VISIBLE);
            }
        }, 100);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                speechTextView.startAnimation(animation);
                speechTextView.setAlpha(1);
                //speechTextView.setVisibility(View.VISIBLE);
            }
        }, 350);
    }
}
