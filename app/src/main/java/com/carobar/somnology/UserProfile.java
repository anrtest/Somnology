package com.carobar.somnology;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.carobar.somnology.core.SleepVideoView;
import com.carobar.somnology.core.entities.UserEntity;

public class UserProfile extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public FragmentManager fragmentManager;
    public Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        final Context ctxt = this;
        fragmentManager = getSupportFragmentManager();

        final TypedArray styledAttributes = getBaseContext().getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize });
        int mActionBarSize = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        final View profileHeader = findViewById(R.id.userProfile_Header);
        final Button headerBackButton = profileHeader.findViewById(R.id.back);
        headerBackButton.setVisibility(View.GONE);
        TextView screenTitle = profileHeader.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("My Sleep Profile");

        Button settingBtn = findViewById(R.id.userProfile_settingBtn);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctxt, Settings.class);
                ctxt.startActivity(intent);
            }
        });
        //Totems Progress
        int totems = 40;  //TODO: set earned totems
        ProgressBar progressBar =  findViewById(R.id.imageView4);
        TextView text = findViewById(R.id.userProfile_TotemNumber);




        runProgress(totems, mHandler, progressBar, text);

        //Sheep Animation Starts here

        int profilecompletion = 100; //TODO:get profile completion from db

        final VideoView profileVideo = findViewById(R.id.userProfile_Video);
        final ConstraintLayout dashView = findViewById(R.id.userProfileDashView);
        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sheep_profile_nodithered);
        profileVideo.setVideoURI(videoUri);

        if(profilecompletion < 40){
            profileVideo.start();
            videoPlayBack(profileVideo, 1500);
        }
        else if(profilecompletion >= 40 && profilecompletion < 60){
            profileVideo.start();
            videoPlayBack(profileVideo, 2600);
        }
        else if(profilecompletion >= 60 && profilecompletion < 80){
            profileVideo.start();
            videoPlayBack(profileVideo, 5350);
        }
        else if(profilecompletion >= 80 && profilecompletion < 100){
            profileVideo.start();
            videoPlayBack(profileVideo, 6600);
        }
        else {
            if (SleepApp.get().profileCheckSharedPref()) {
                profileVideo.start();
                Handler delayScreen = new Handler();
                delayScreen.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        profileVideo.setVisibility(View.INVISIBLE);
                        dashView.setVisibility(View.VISIBLE);

                        displayCompletionPopUp(getString(R.string.congratulations), getString(R.string.pc_shortDesc), "100");

                    }
                }, 8000);
            }else{
                profileVideo.setVisibility(View.INVISIBLE);
                dashView.setVisibility(View.VISIBLE);
            }
        }

        //end sheep Animation

        String loginUser = SleepApp.get().getLoginUser();
        final UserEntity user = SleepApp.get().getDB().userDao().findByEmail(loginUser);

        final TextView profileName = findViewById(R.id.userProfile_Name);
        String userName = user.getFirstName() + ' ' + user.getLastName();
        profileName.setText(userName);

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.userProfileIncludeFooter);

        final bottomNavigation bottomNavigationView = new bottomNavigation();
        bottomNavigationView.ctxt = this;

        BottomNavigationView btmNavigationLeft = btmBarView.findViewById(R.id.navigationView);
        btmNavigationLeft.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);
        btmNavigationLeft.getMenu().findItem(R.id.navigation_profile).setIcon(R.drawable.profile_icon_select_2x);//To chnage the bottom icon on selected

        BottomNavigationView btmNavigationRight = btmBarView.findViewById(R.id.navigationViewRight);
        btmNavigationRight.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        ImageButton sleepImage = btmBarView.findViewById(R.id.imageButtonMain);
        sleepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomNavigationView.logSleep(view);
            }
        });

//        final ImageButton profileImage = btmBarView.findViewById(R.id.navigation_profile);
//
//        profileImage.setBackgroundResource(R.drawable.profile_icon_selec_2x);

        Button myinfo = findViewById(R.id.userProfile_Questions);
        myinfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                InterviewQuestions(view);
            }
        });

        //FitBit
        ImageButton fitbitImageBtn = findViewById(R.id.userProfile_FitbitImage);
        Button fitbitDeviceBtn = findViewById(R.id.userProfile_Devicefitbit);
        final Button connectFitbitBtn = findViewById(R.id.userProfile_connectFitbit);


        fitbitImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectFitbit(view);
            }
        });
        fitbitDeviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectFitbit(view);
            }
        });
        connectFitbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectFitbit(view);
            }
        });

        //Plex
        ImageButton plexImageBtn = findViewById(R.id.userProfile_plexImageBtn);
        Button PlexDeviceBtn = findViewById(R.id.userProfile_Deviceplex);
        plexImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plexPreOrder(view);
            }
        });
        PlexDeviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plexPreOrder(view);
            }
        });

        // You may have Disease
        Button insomniaBtn = findViewById(R.id.userProfile_insomnia);
        insomniaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insomniaView(view);
            }
        });

        Button sleepBreathingBtn = findViewById(R.id.userProfile_sleepBreathing);
        sleepBreathingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepBeathingView(view);
            }
        });

        Button excessiveDaytimeBtn = findViewById(R.id.userProfile_excessiveDaytimeSleep);
        excessiveDaytimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excessiveDaytimeView(view);
            }
        });

        Button virtualNSSeeAllBtn = findViewById(R.id.userProfile_seeAllVirtualNS);
        virtualNSSeeAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment VirtualNSGrid=new user_virtual_nightstand();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.userProfile_mainRelativeLayout,VirtualNSGrid); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });


    }
    public void displayCompletionPopUp(String title, String shortDesc, String starCount ){
        ProfileCompletionPopOver ifDialog = new ProfileCompletionPopOver();
        Bundle bItem = new Bundle();
        bItem.putString("Title", title);
        bItem.putString("shortDesc", shortDesc);
        bItem.putString("starCount", starCount);
        ifDialog.setArguments(bItem);
        try{
            ifDialog.show(fragmentManager,"PopDialog");
            SharedPreferences settings = getSharedPreferences(SleepApp.PREFS_LOGIN_SLEEPAPP, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("popup", "repeated");
            editor.commit();
        }
        catch (IllegalStateException e){
            finish();
        }

    }
    public void videoPlayBack(final VideoView sheepVideo, int timeDelay){
        Handler delayScreen = new Handler();
        delayScreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                sheepVideo.stopPlayback();
            }},timeDelay);
    }

    public void InterviewQuestions(View view){
        Intent intent = new Intent(this, SleepQuestions.class);
        startActivity(intent);
    }
    public void connectFitbit(View view){
        Uri uri = Uri.parse("http://fitbit.com");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void plexPreOrder(View view){
        Intent plexPreOrderIntent = new Intent(this, PlexPreorder.class);
        startActivity(plexPreOrderIntent);
    }
    public void insomniaView(View view){
        Intent intent = new Intent(this, disease_name.class);
        intent.putExtra("screenName","Insomnia");
        startActivity(intent);
    }

    public void sleepBeathingView(View view){
        Intent intent = new Intent(this, disease_name.class);
        intent.putExtra("screenName","Sleep Breathing Disorder");
        startActivity(intent);
    }
    public void excessiveDaytimeView(View view){
        Intent intent = new Intent(this, disease_name.class);
        intent.putExtra("screenName","Excessive Daytime Sleepiness");
        startActivity(intent);
    }
    public void runProgress(final int mProgress, final Handler mHandler, final ProgressBar progressBar, final TextView text){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int mProgressStatus = 0;
                while (mProgressStatus < mProgress) {
                    mProgressStatus += 1;
                    // Update the progress bar
                    final int finalMProgressStatus = mProgressStatus;
                    final int finalMProgressStatus1 = mProgressStatus;
                    mHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(finalMProgressStatus);
                            text.setText(""+ finalMProgressStatus1);

                        }
                    });
                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
