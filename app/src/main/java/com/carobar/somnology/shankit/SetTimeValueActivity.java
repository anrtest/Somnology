package com.carobar.somnology.shankit;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
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
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

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
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        setButton(new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button10});
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

                        String strHrsToShow = (mcurrentTime.get(Calendar.HOUR) == 0) ? "12" : Integer.toString(mcurrentTime.get(Calendar.HOUR));
                        tv_answer1.setText(String.format("%d : %d %s", selectedHour, selectedMinute, am_pm));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final CountDownTimer countDownTimer = new CountDownTimer(24*60*60*1000, 1000) {
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//                        tv_answer2.setText(String.valueOf(millisUntilFinished / 1000));
//                        cancel();
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//                };
//                countDownTimer.start();
            }
        });
    }

    private void setButton(Button buttons[]) {
        for (final Button button : buttons){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("hi--------->", "clicked");
                    Drawable drawable = button.getBackground();
                    if (drawable == ContextCompat.getDrawable(activity, R.drawable.rounded_button_bg_white)){
                        Log.e("hi------>", "white to orange");
                        button.setBackgroundResource(R.drawable.rounded_button_bg_white_orange_border);
                    }else {
                        Log.e("hi------>", "orange to white");
                        button.setBackgroundResource(R.drawable.rounded_button_bg_white);
                    }
                    Drawable drawable2 = button.getBackground();
                    if (drawable2 == ContextCompat.getDrawable(activity, R.drawable.rounded_button_bg_white)){
                        Log.e("hi--------->", "equal white");
                    } if (drawable2 == ContextCompat.getDrawable(activity, R.drawable.rounded_button_bg_white_orange_border)){
                        Log.e("hi--------->", "equal orange");
                    }
                }
            });

        }
    }

}
