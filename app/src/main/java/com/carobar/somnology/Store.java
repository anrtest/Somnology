package com.carobar.somnology;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.LinearLayout;
import android.view.Gravity;

public class Store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        View headerView = findViewById(R.id.store_header);
        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.INVISIBLE);

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Store");

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.storeIncludeFooter);

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
        Button seeAllBtn = (Button) findViewById(R.id.storeSleeptotems_seeall);
        seeAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment sleepGrid=new sleep_totem_grid();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.store_mainRelativeLayout,sleepGrid); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();


            }
        });

        LinearLayout layout = findViewById(R.id.store_image_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        try {

            // to reach asset
            AssetManager assetManager = getAssets();
            // to get all item in dogs folder.
            final String[] images = assetManager.list("sleep_totems_large_2x");
            // to keep all image

            for (int i = 0; i < images.length; i++) {
                InputStream inputStream = getAssets().open("sleep_totems_large_2x/" + images[i]);
                Drawable drawable = Drawable.createFromStream(inputStream, null);

                layoutParams.gravity = Gravity.CENTER;
                layoutParams.height = 300;
                layoutParams.width = 250;
                layoutParams.leftMargin=80;
                ImageView imageView = new ImageView(this);
                imageView.setImageDrawable(drawable);
                imageView.setLayoutParams(layoutParams);
                imageView.setTag(images[i]);
                imageView.setId(i);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String imageName = (String) view.getTag();
                        Log.d("image nameeee",imageName);
                        String[] imagname=imageName.split("_");
                        String imagName1=imagname[1];
                        Bundle bundle = new Bundle();
                        bundle.putString("edttext", imagName1);
                        Fragment sleepTotemFragment=new sleep_totems_single();
                        sleepTotemFragment.setArguments(bundle);
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.store_mainRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                        transaction.commit();
//                        imageSelected(imageName);
                    }
                });

                layout.addView(imageView);


            }


        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
//        Button fab = (Button) findViewById(R.id.sleepQuestion_interview_questions);
//        fab.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Fragment newCase=new interview_questions();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.sleep_question_relativeLayout,newCase); // give your fragment container id in first parameter
//                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//                transaction.commit();
//
//            }
//        });

//        LinearLayout layoutStars = findViewById(R.id.store_image_container_stars);
//        LinearLayout.LayoutParams layoutParamsStars = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        try {
//
//            // to reach asset
//            AssetManager assetManagerStars = getAssets();
//            // to get all item in dogs folder.
//            String[] imagesStars = assetManagerStars.list("stars_3x");
//            // to keep all image
//
//            for (int i = 0; i < imagesStars.length; i++) {
//                InputStream inputStreamStars = getAssets().open("stars_3x/" + imagesStars[i]);
//                Drawable drawable = Drawable.createFromStream(inputStreamStars, null);
//
//                layoutParams.gravity = Gravity.CENTER;
//                layoutParams.height = 200;
//                layoutParams.width = 150;
//                layoutParams.leftMargin=50;
//                ImageView imageViewStars = new ImageView(this);
//                imageViewStars.setImageDrawable(drawable);
//                imageViewStars.setLayoutParams(layoutParams);
//
//                layoutStars.addView(imageViewStars);
//                TextView tv = new TextView(this);
//                if (i == 0) {
//                    tv.setText("100 Stars" );
//                    tv.setId(i + 5);
//                }
//                if (i == 1) {
//                    tv.setText("250 Stars" );
//                }
//                if (i == 2) {
//                    tv.setText("500 Stars" );
//                }
//                layoutStars.addView(tv);
//
//            }
//
//        } catch (IOException e) {
//            System.out.print(e.getMessage());
//        }
    }

    public void imageSelected(String imgname) {
//        String[] imagName=imgname.split(Pattern.quote("."));
        String[] imagName=imgname.split("_");
        String imagName1=imagName[1];
        Log.d("in image fnc",imagName1);

    }
}
