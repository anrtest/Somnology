package com.carobar.somnology;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Footer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footer);
//        Button showProfile = findViewById(R.id.ProfileFooter);
//        showProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                show_profile(view);
//            }
//        });
//
//        Button showResources = findViewById(R.id.ResourcesFooter);
//        showResources.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                show_resources(view);
//            }
//        });
    }
    public void show_profile(Context ctxt, View view){
        Intent intent = new Intent(ctxt, UserProfile.class);
        ctxt.startActivity(intent);
    }
    public void show_resources(Context ctxt, View view){
        Intent intent = new Intent(ctxt, resources.class);
        ctxt.startActivity(intent);
    }
}
