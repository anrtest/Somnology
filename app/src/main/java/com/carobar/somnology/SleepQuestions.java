package com.carobar.somnology;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;


public class SleepQuestions extends AppCompatActivity {

    int progressBarValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_questions);

        View headerView = findViewById(R.id.sleep_question_header);
        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.VISIBLE);

//        Button skipButton = headerView.findViewById(R.id.skip);
//        skipButton.setVisibility(View.VISIBLE);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Sleep Questions");

        final ProgressBar progressBar1= (ProgressBar)findViewById(R.id.sleepQuestion_progressBar);
        final TextView percentComplete= (TextView)findViewById(R.id.sleepQuestion_textView1);
        percentComplete.setText("0/3 Completed");

        Button myinfo = findViewById(R.id.sleepQuestion_stopBang);
        myinfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                stopBangView(view);
            }
        });

        Button epworthBtn = findViewById(R.id.sleepQuestion_epworthSleepinessScale);
        epworthBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                epworthView(view);
            }
        });

        Button fab = (Button) findViewById(R.id.sleepQuestion_interview_questions);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Fragment newCase=new interview_questions();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.sleep_question_relativeLayout,newCase); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });

//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                while(progressBarValue < 100)
//                {
//                    progressBarValue++;
//
//                    .post(new Runnable() {
//
//                        @Override
//                        public void run() {
//
//                            progressBar1.setProgress(progressBarValue);
//                            percentComplete.setText(progressBarValue +"/"+progressBar1.getMax());
//
//                        }
//                    });try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                }
//            }
//        }).start();
    }

    public void stopBangView(View view){
        Intent intent = new Intent(this, stop_bang.class);
        startActivity(intent);
    }

    public void epworthView(View view){
        Intent intent = new Intent(this, epworth_sleepiness.class);
        startActivity(intent);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

}
