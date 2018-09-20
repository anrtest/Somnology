package com.carobar.somnology;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EditAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        //Header
        final View editAlarmHeader = findViewById(R.id.editAlarm_Header);
        TextView screenText = editAlarmHeader.findViewById(R.id.headerViewScreenText);
        screenText.setText("Edit Alarm");
        final Button headerBackButton = editAlarmHeader.findViewById(R.id.back);
        headerBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goBack(view);
            }
        });

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.editAlarmIncludeFooter);

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
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, LogSleep.class);
        startActivity(intent);
    }
}
