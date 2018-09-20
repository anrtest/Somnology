package com.carobar.somnology;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlexPreorder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plex_preorder);
        //Header
        final View editAlarmHeader = findViewById(R.id.plexPreOrder_Header);
        TextView screenText = editAlarmHeader.findViewById(R.id.headerViewScreenText);
        screenText.setText("Plex");
        final Button headerBackButton = editAlarmHeader.findViewById(R.id.back);
        headerBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goBack(view);
            }
        });

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.plexPreOrderIncludeFooter);

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

        //PreOrder
        Button preOrderBtn = findViewById(R.id.plexOrder_orderBtn);
        preOrderBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), webPage.class);
                intent.putExtra("URL","https://www.somnologymd.com/plex-preorder-terms-and-conditions/");
                intent.putExtra("screenName", "Plex");
                startActivity(intent);
            }
        });
    }
    public void goBack(View view) {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }
}
