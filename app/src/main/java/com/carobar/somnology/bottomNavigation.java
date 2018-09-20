package com.carobar.somnology;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class bottomNavigation extends AppCompatActivity {

    private TextView mTextMessage;
    public Context ctxt = this;


   public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    Intent intentProfile = new Intent(ctxt, UserProfile.class);
                    ctxt.startActivity(intentProfile);

                    break;
                case R.id.navigation_report:
                    Intent intentReport = new Intent(ctxt, Reports.class);
                    ctxt.startActivity(intentReport);
                    break;
                case R.id.navigation_store:
                    Intent intentStore = new Intent(ctxt, Store.class);
                    ctxt.startActivity(intentStore);
                    break;
                case R.id.navigation_resources:
                    Intent intentResources = new Intent(ctxt, resources.class);
                    ctxt.startActivity(intentResources);
                    break;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ImageButton sleepImageContainer = findViewById(R.id.imageButtonMain);

        ImageButton sleepImage = findViewById(R.id.imageButtonMain);
        sleepImage.getLayoutParams().height = sleepImageContainer.getHeight();
        sleepImage.getLayoutParams().width = sleepImageContainer.getWidth();

        sleepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logSleep(view);
            }
        });
    }

    public void logSleep(View view){
        Intent intent = new Intent(ctxt, LogSleep.class);
        ctxt.startActivity(intent);
    }



}
