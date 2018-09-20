package com.carobar.somnology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class epworth_sleepiness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epworth_sleepiness);

        View headerView = findViewById(R.id.epworthSleepiness_Header);
        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

//        Button skipButton = headerView.findViewById(R.id.skip);
//        skipButton.setVisibility(View.VISIBLE);

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Epworth Sleepines");

        // Seekbar First
        SeekBar seekBarFirst = (SeekBar)findViewById(R.id.simpleSeekBar1);
        final TextView seekBarValue = (TextView)findViewById(R.id.seekbar1_TextViewValue);

        seekBarFirst.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Second
        SeekBar seekBarSecond = (SeekBar)findViewById(R.id.simpleSeekBar2);
        final TextView seekBar2Value = (TextView)findViewById(R.id.seekbar2_TextViewValue);

        seekBarSecond.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar2Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Third
        SeekBar seekBarThird = (SeekBar)findViewById(R.id.simpleSeekBar3);
        final TextView seekBar3Value = (TextView)findViewById(R.id.seekbar3_TextViewValue);

        seekBarThird.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar3Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Fourth
        SeekBar seekBarFourth = (SeekBar)findViewById(R.id.simpleSeekBar4);
        final TextView seekBar4Value = (TextView)findViewById(R.id.seekbar4_TextViewValue);

        seekBarFourth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar4Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Five
        SeekBar seekBarFive = (SeekBar)findViewById(R.id.simpleSeekBar5);
        final TextView seekBar5Value = (TextView)findViewById(R.id.seekbar5_TextViewValue);

        seekBarFive.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar5Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Six
        SeekBar seekBarSix = (SeekBar)findViewById(R.id.simpleSeekBar6);
        final TextView seekBar6Value = (TextView)findViewById(R.id.seekbar6_TextViewValue);

        seekBarSix.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar6Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Seven
        SeekBar seekBarSeven = (SeekBar)findViewById(R.id.simpleSeekBar7);
        final TextView seekBar7Value = (TextView)findViewById(R.id.seekbar7_TextViewValue);

        seekBarSeven.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar7Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Seekbar Eight
        SeekBar seekBarEight = (SeekBar)findViewById(R.id.simpleSeekBar8);
        final TextView seekBar8Value = (TextView)findViewById(R.id.seekbar8_TextViewValue);

        seekBarEight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBar8Value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }
    public void goBack(View view){
        Intent intent = new Intent(this, SleepQuestions.class);
        startActivity(intent);
    }
}
