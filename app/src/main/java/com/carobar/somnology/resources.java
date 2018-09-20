package com.carobar.somnology;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.carobar.somnology.core.StickyAdapter;

public class resources extends AppCompatActivity {
    TextView headerViewText;
    Button headerBackButton;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        activity = this;
        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        final Context ctxt = this;
        //Header
        View headerView = findViewById(R.id.resourceIncludeHeader);
        headerViewText = headerView.findViewById(R.id.headerViewScreenText);
//        headerViewText.setVisibility(View.VISIBLE);
        headerViewText.setText("Resources");
        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });




//        final Footer footerObj = new Footer();
//        View footerView = findViewById(R.id.resourceIncludeFooter);
//        //Footer Menu Buttons
//        Button profileBtn = footerView.findViewById(R.id.ProfileFooter);
//        Button reportsBtn = footerView.findViewById(R.id.ReportsFooter);
//        Button storeBtn = footerView.findViewById(R.id.StoreFooter);
//        Button resourceBtn = footerView.findViewById(R.id.ResourcesFooter);

//        profileBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                footerObj.show_profile(ctxt,view);
//            }
//        });
//        resourceBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                footerObj.show_resources(ctxt, view);
//            }
//        });

        //Bottom Navigation View
        View btmBarView = findViewById(R.id.resourceIncludeFooter);

        final bottomNavigation bottomNavigationView = new bottomNavigation();
        bottomNavigationView.ctxt = this;

        BottomNavigationView btmNavigationLeft = btmBarView.findViewById(R.id.navigationView);
        btmNavigationLeft.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        BottomNavigationView btmNavigationRight = btmBarView.findViewById(R.id.navigationViewRight);
        btmNavigationRight.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);
        btmNavigationRight.getMenu().findItem(R.id.navigation_resources).setIcon(R.drawable.resource_icon_selected_2x);

        ImageButton sleepImage = btmBarView.findViewById(R.id.imageButtonMain);
        sleepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomNavigationView.logSleep(view);
            }
        });


        final ListView listView = findViewById(R.id.resourceListView);
        StickyAdapter listAdapter = new StickyAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StickyAdapter.Item item = (StickyAdapter.Item) listView.getAdapter().getItem(position);
                //Toast.makeText(getApplicationContext(),"Click ListItem Number " + item.toString(), Toast.LENGTH_LONG).show();
                if(item.dataType == "http" && item.getUrl() != null){
                    Intent intent = new Intent(getApplicationContext(), webPage.class);
                    intent.putExtra("URL",item.getUrl());
                    startActivity(intent);
                }
                else if(item.dataType == "pop"){
                    InfoDialogFragment ifDialog = new InfoDialogFragment();
                    Bundle bItem = new Bundle();
                    bItem.putString("Title", item.getName());
                    bItem.putString("shortDesc", item.getShortDesc());
                    bItem.putStringArray("infoSteps", item.getPopList());
                    ifDialog.setArguments(bItem);
                    ifDialog.show(fragmentManager,"PopDialog");
                }

            }
        });


    }
    public void goBack(View view){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }


}
