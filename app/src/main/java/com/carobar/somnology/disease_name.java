package com.carobar.somnology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class disease_name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_name);

        View headerView = findViewById(R.id.disease_nameHeader);
        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });
        final TextView screeText = headerView.findViewById(R.id.headerViewScreenText);
        String screenName = getIntent().getStringExtra("screenName");
        if (screenName.equalsIgnoreCase("insomnia")){
            screeText.setText("Insomnia");

            TextView insomniafirstHeader = findViewById(R.id.diseaseName_firstHeaderText);
            insomniafirstHeader.setText(R.string.insomnia_firstHeaderText);

            TextView insomniaFirstText =findViewById(R.id.diseaseName_firstTextDetails);
            insomniaFirstText.setText(R.string.insomniaDisease_textFirst);

            TextView insomniaSecondText = findViewById(R.id.diseaseName_secondTextDetails);
            insomniaSecondText.setText(R.string.insomniaDisease_textSecond);
        }
        else if (screenName.equalsIgnoreCase("Sleep Breathing Disorder")){
            screeText.setText("Sleep Breathing Disorder");

            TextView sleepBreathingFirstHeader = findViewById(R.id.diseaseName_firstHeaderText);
            sleepBreathingFirstHeader.setText(R.string.sleepBreath_firstHeaderText);

            TextView sleepBreathingFirstText = findViewById(R.id.diseaseName_firstTextDetails);
            sleepBreathingFirstText.setText(R.string.sleepBreath_firstText);

            TextView sleepBreathingSecondText = findViewById(R.id.diseaseName_secondTextDetails);
            sleepBreathingSecondText.setText(R.string.sleepBreath_secondText);
        }
        else {
            screeText.setText(screenName);

            TextView excessiveDaytimeFirstHeader = findViewById(R.id.diseaseName_firstHeaderText);
            excessiveDaytimeFirstHeader.setText(R.string.excessiveSleep_firstHeaderText);

            TextView excessiveDaytimeFirstText = findViewById(R.id.diseaseName_firstTextDetails);
            excessiveDaytimeFirstText.setText(R.string.excessiveSleep_firstText);

            TextView excessiveDaytimeSecondText = findViewById(R.id.diseaseName_secondTextDetails);
            excessiveDaytimeSecondText.setText(R.string.excessiveSleep_secondText);
        }

        Button moreInfoBtn = findViewById(R.id.diseaseName_moreInfoBtn);
        moreInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfView(view);
            }
        });

    }

    public void goBack(View view){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

    public void pdfView(View view){
        Intent intent = new Intent(this, disease_pdf_viewer.class);
        startActivity(intent);

    }
}
