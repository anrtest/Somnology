package com.carobar.somnology.shankit;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.carobar.somnology.R;

import java.util.Calendar;

public class SetTimeValueActivity extends AppCompatActivity {

    private Activity activity;
    private TextView tv_answer1, tv_answer2;
    private Button nextBtn;
    private CardView cardView, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time_value);
        activity = SetTimeValueActivity.this;
        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        tv_answer1 = findViewById(R.id.tv_answer1);
        tv_answer2 = findViewById(R.id.tv_answer2);

        // TODO Auto-generated method stub
        final Calendar mcurrentTime = Calendar.getInstance();
        final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        final int minute = mcurrentTime.get(Calendar.MINUTE);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog mTimePicker = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String am_pm = "";
                        if (mcurrentTime.get(Calendar.AM_PM) == Calendar.AM)
                            am_pm = "AM";
                        else if (mcurrentTime.get(Calendar.AM_PM) == Calendar.PM)
                            am_pm = "PM";

                        String strHrsToShow = (mcurrentTime.get(Calendar.HOUR) == 0) ?"12":Integer.toString( mcurrentTime.get(Calendar.HOUR) );
                        tv_answer1.setText(String.format("%d : %d %s", selectedHour, selectedMinute, am_pm));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

}
