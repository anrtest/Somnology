package com.carobar.somnology;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        View headerView = findViewById(R.id.reports_Header);
        TextView screenText = headerView.findViewById(R.id.headerViewScreenText);
        screenText.setText("Reports");

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.reportsIncludeFooter);

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

        Intent reportExist = new Intent(this, SleepLogReport.class);
        startActivity(reportExist);
        finish();
    }
}
