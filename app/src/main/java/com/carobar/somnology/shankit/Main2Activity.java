package com.carobar.somnology.shankit;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carobar.somnology.R;
import com.carobar.somnology.shankit.adapter.HourSelectionRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity {

    private RecyclerView recyclerView;
    private HourSelectionRecyclerAdapter adapter;
    private Activity activity;
    private TextView title;
    private Button nextBtn;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activity = Main2Activity.this;
        recyclerView = findViewById(R.id.rv_screen1);
        cardView = findViewById(R.id.cardView);
        title = findViewById(R.id.headerViewScreenText);
        title.setText("Sleep Summary");
        nextBtn = findViewById(R.id.done);
        nextBtn.setText("Next");
        nextBtn.setVisibility(View.VISIBLE);
        adapter = new HourSelectionRecyclerAdapter(activity);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setVerticalScrollBarEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        dummyData();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, SetTimeValueActivity.class));
            }
        });
    }

    private void dummyData() {
        List<HourSelectionModel> list = new ArrayList<>();
        list.add(new HourSelectionModel(false, "0"));
        list.add(new HourSelectionModel(false, "1"));
        list.add(new HourSelectionModel(false, "2"));
        list.add(new HourSelectionModel(false, "3"));
        list.add(new HourSelectionModel(false, "4"));
        list.add(new HourSelectionModel(false, "5"));
        list.add(new HourSelectionModel(false, "6"));
        list.add(new HourSelectionModel(false, "7"));
        list.add(new HourSelectionModel(false, "8"));
        list.add(new HourSelectionModel(false, "9"));
        list.add(new HourSelectionModel(false, "10"));
        list.add(new HourSelectionModel(false, "11"));
        list.add(new HourSelectionModel(false, "12"));
        list.add(new HourSelectionModel(false, "13"));
        list.add(new HourSelectionModel(false, "14"));
        list.add(new HourSelectionModel(false, "15"));
        list.add(new HourSelectionModel(false, "16"));
        list.add(new HourSelectionModel(false, "17"));
        list.add(new HourSelectionModel(false, "18"));
        list.add(new HourSelectionModel(false, "19"));

        adapter.setList(list);
    }
}
