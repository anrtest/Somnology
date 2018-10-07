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
    private TextView buttons[] = new TextView[10];
    private boolean isButtonRed[] = new boolean[]{false, false, false, false, false, false, false, false, false, false};

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
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        buttons[9] = findViewById(R.id.button10);

        setButton(buttons);
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

    private void setButton(final TextView buttons[]) {
        for (int i = 0; i < buttons.length; i++){
            final int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("hi--------->", "clicked");
                    Drawable drawable = buttons[finalI].getBackground();
                    if (!isButtonRed[finalI]) {
                        Log.e("hi------>", "white to orange");
                        buttons[finalI].setBackgroundResource(R.drawable.rounded_button_bg_white_orange_border);
                    }else{
                        Log.e("hi------>", "  <---white to orange");
                        buttons[finalI].setBackgroundResource(R.drawable.rounded_button_bg_white);
                    }
                    isButtonRed[finalI] = !isButtonRed[finalI];

                }
            });
        }
    }

}
