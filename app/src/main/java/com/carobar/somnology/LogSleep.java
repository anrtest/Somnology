package com.carobar.somnology;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogSleep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sleep);

        View headerView = findViewById(R.id.logSleep_Header);
        TextView screenText = headerView.findViewById(R.id.headerViewScreenText);
        screenText.setText("Log Sleep");

        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.INVISIBLE);

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.logSleepIncludeFooter);

        final bottomNavigation bottomNavigationView = new bottomNavigation();
        bottomNavigationView.ctxt = this;

        BottomNavigationView btmNavigationLeft = btmBarView.findViewById(R.id.navigationView);
        btmNavigationLeft.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        BottomNavigationView btmNavigationRight = btmBarView.findViewById(R.id.navigationViewRight);
        btmNavigationRight.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        final ImageButton sleepImage = btmBarView.findViewById(R.id.imageButtonMain);

        sleepImage.setBackgroundResource(R.drawable.owl_closed_eyes_2x);
        //sleepImage.getLayoutParams().width = imageButtonContainer.getWidth();
        //sleepImage.getLayoutParams().height = imageButtonContainer.getHeight();

//        Calendar calendar = Calendar.getInstance();
//        int hrs = calendar.get(Calendar.HOUR);
//        int mins = calendar.get(Calendar.MINUTE);
//        String am_pm;
//        if(calendar.get(Calendar.AM_PM) == 0){
//            am_pm = "AM";
//        }else{
//            am_pm = "PM";
//        }
//
//
//        TextView timeDispaly = findViewById(R.id.sleepLog_TimeDisplay);
//        TextView timeMeridian = findViewById(R.id.sleepLog_TimeMeridian);
        //String currentDateTime = DateFormat.getTimeInstance().format(new Date());
//        timeDispaly.setText(String.valueOf(hrs)+":"+String.valueOf(mins));
//        timeMeridian.setText(am_pm);

        sleepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepImage.setBackgroundResource(R.drawable.owl_closed_eyes_2x);
            }
        });

        sleepImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                sleepImage.setBackgroundResource(R.drawable.tabbar_middle_button_2x);
                return false;
            }

        });

        //Edit Alarm
        final TextView editAlarm = findViewById(R.id.logSleep_EditAlarm);
        editAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAlarm(view);
            }
        });

        Button fab = (Button) findViewById(R.id.sleepLog_LogSleepBtn);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Fragment newCase=new logsleep_image();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.logSleep_relativeLayout,newCase); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });
    }

    public void editAlarm(View view){
        Intent intentEditAlarm = new Intent(this, EditAlarm.class);
        startActivity(intentEditAlarm);
    }
}
