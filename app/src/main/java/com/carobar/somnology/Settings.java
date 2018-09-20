package com.carobar.somnology;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;
import android.util.Log;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        View headerView = findViewById(R.id.profile_header);
        //Header Buttons
        TextView headerText = headerView.findViewById(R.id.headerViewScreenText);
        headerText.setText("Settings");
        Button backButton = headerView.findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        final Context ctxt = this;

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.settingsIncludeFooter);

        final bottomNavigation bottomNavigationView = new bottomNavigation();
        bottomNavigationView.ctxt = this;

        BottomNavigationView btmNavigationLeft = btmBarView.findViewById(R.id.navigationView);
        btmNavigationLeft.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        BottomNavigationView btmNavigationRight = btmBarView.findViewById(R.id.navigationViewRight);
        btmNavigationRight.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        ImageButton sleepImage = btmBarView.findViewById(R.id.imageButtonMain);
        sleepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomNavigationView.logSleep(view);
            }
        });


//        final Footer footerObj = new Footer();
//        View footerView = findViewById(R.id.profile_footer);
//        //Footer Menu Buttons
//        Button profileBtn = footerView.findViewById(R.id.ProfileFooter);
//        Button reportsBtn = footerView.findViewById(R.id.ReportsFooter);
//        Button storeBtn = footerView.findViewById(R.id.StoreFooter);
//        Button resourceBtn = footerView.findViewById(R.id.ResourcesFooter);
//
//        profileBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                footerObj.show_profile(ctxt,view);
//            }
//        });
//        resourceBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                footerObj.show_resources(ctxt, view);
//            }
//        });

        Button myinfo = findViewById(R.id.myInfoBtn);
        myinfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                myProfileInfo(view);
            }
        });

        Button mySettings = findViewById(R.id.settingsBtn);
        mySettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mySettings(view);
            }
        });

        Button privacyPolicy = findViewById(R.id.privacyPolicyBtn);
        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                privacyPolicy(view);
            }
        });

        Button logOut = findViewById(R.id.logoutBtn);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit(view);
            }
        });

    }

//    public void exitLogout(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle(Html.fromHtml("<font color='#FF7F27'>This is a test</font>"));
//        builder.setPositiveButton(Html.fromHtml("<font color='#FF7F27'>Yes</font>"), new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int arg1) {
//
//            }
//        });
//        builder.setNegativeButton(Html.fromHtml("<font color='#FF7F27'>No</font>"), new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int arg1) {
//
//            }
//        });
//        builder.create();
//        builder.show();
//    }

    public void exit(View view){
        final View view1 = view;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title


        alertDialogBuilder.setTitle(Html.fromHtml("<font color='#000000'>MobileSleepDoc</font>"));

        // Setting Alert Dialog Message
//
        alertDialogBuilder.setMessage(Html.fromHtml("<font color='#000000'>Are you sure you want to logout?</font>"));
//        alertDialogBuilder.setView()

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                logOut(view1);
            }

        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.background_light);
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorBlue));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorBlue));

    }
    public void goBack(View view){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }
    public void mySettings(View view){
        Intent intent = new Intent(this, settings_config.class);
        startActivity(intent);
    }
    public void myProfileInfo(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void privacyPolicy(View view){
        Intent intent = new Intent(this, webPage.class);
        intent.putExtra("URL","file:///android_asset/PrivacyPolicy.html");
        startActivity(intent);
    }
    public void logOut(View view){
        SharedPreferences settings = getSharedPreferences(SleepApp.PREFS_LOGIN_SLEEPAPP, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove("loginUser");
        editor.remove("popup");
        editor.commit();
        SleepApp.get().setLoginUser(null);
        Intent intent = new Intent(this, MainIntro.class);
        startActivity(intent);
        finish();
    }


}
