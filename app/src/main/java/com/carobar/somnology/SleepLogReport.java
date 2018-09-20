package com.carobar.somnology;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class SleepLogReport extends AppCompatActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_log_report);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_sleep_log_report, menu);
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sleep_log_report, menu);
        final int currentItem =0;

        Spinner spinner = (Spinner) findViewById(R.id.spinner_nav);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.reportsToolBarSelection, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
//                Toast.makeText(getApplicationContext(), "This is " +
//                        parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                Log.d("Positionssssssssssss",parentView.getItemAtPosition(position).toString());
                String selected_val =parentView.getItemAtPosition(position).toString();
                Log.d("selected_val",selected_val);

                if (selected_val.equals("Avergae Hours Slept")) {
                    Log.d("ifffffffff 111",selected_val);
//                    sleepLogReport(parentView);
                }
                else if (selected_val.equals("Sleep Log Report")) {
                    Log.d("else if 222",selected_val);
//                    sleepLogReport(parentView);
                }
                else if (selected_val.equals("Avergae Sleep Efficency")) {
                    Log.d("else if 333",selected_val);
//                    averageHoursSlept(parentView);
                }
                else if (selected_val.equals("Sleep Efficency Per Night")) {
                    Log.d("else if 4444",selected_val);
                }
                else if (selected_val.equals("Wakeup Time Activity Report")) {
                    Log.d("else if 5555",selected_val);
                }
                else if (selected_val.equals("Hours Per Night")) {
                    Log.d("else if 666",selected_val);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public ProgressBar progressBar;
        public TextView text;
        public Handler mHandler = new Handler();
        public int mProgressStatus = 0;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sleep_log_report, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            //PieStroke view Orange
            progressBar =  rootView.findViewById(R.id.progressBar);
            text = rootView.findViewById(R.id.Progresstext);
            runProgress();

            //PieStroke view White
            int progress = 40; //TODO: set value of progress
            ProgressBar progressBarWhite = rootView.findViewById(R.id.progressBarWhite);
            TextView textWhite = rootView.findViewById(R.id.ProgresstextWhite);
            runProgressArgs(progress, mHandler, progressBarWhite, textWhite);

            //Line Chart REFERENCE:https://github.com/PhilJay/MPAndroidChart/wiki/Setting-Data
            LineChart lineAvgSleepEfficieny = rootView.findViewById(R.id.lineChart_hourSlection);

            ArrayList<String> xAXES = new ArrayList<>();
            ArrayList<Entry> valsComp1 = new ArrayList<>();
            ArrayList<Entry> valsComp2 = new ArrayList<>();

            Entry c1e1 = new Entry(0f, 0f);
            valsComp1.add(c1e1);

            Entry c1e2 = new Entry(1f, 81f);
            valsComp1.add(c1e2);

            Entry c1e3 = new Entry(2f, 0f);
            valsComp1.add(c1e3);

            Entry c1e4 = new Entry(3f, 0f);
            valsComp1.add(c1e4);

            Entry c1e5 = new Entry(4f, 81f);
            valsComp1.add(c1e5);

            Entry c1e6 = new Entry(5f, 0f);
            valsComp1.add(c1e6);

            Entry c1e7 = new Entry(6f, 0f);
            valsComp1.add(c1e7);

            LineDataSet setComp1 = new LineDataSet(valsComp1, "Avg. Sleep Efficiency");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setLineWidth(1);

            setComp1.setDrawFilled(true);

            setComp1.setDrawCircleHole(true);
            setComp1.setCircleHoleRadius(4f);
            setComp1.setDrawCircles(true);
            setComp1.setCircleRadius(6f);
//            setComp1.setCircleColorHole(R.color.colorChartUnprogressed);
//            setComp1.setColor(R.color.colorWhite);




            // use the interface ILineDataSet
            List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(setComp1);

            LineData data = new LineData(dataSets);
            lineAvgSleepEfficieny.setData(data);
            lineAvgSleepEfficieny.invalidate();

            // the labels that should be drawn on the XAxis
            final String[] quarters = new String[] { "D1", "D2", "D3", "D4", "D5", "D6", "D7" };

            XAxis xAxis = lineAvgSleepEfficieny.getXAxis();
            xAxis.setGranularity(50000f); // minimum axis-step (interval) is 1


            Description des = null;
            lineAvgSleepEfficieny.setDescription(des);

            lineAvgSleepEfficieny.getAxisLeft().setDrawLabels(false);
            lineAvgSleepEfficieny.getAxisRight().setDrawLabels(false);

            lineAvgSleepEfficieny.getAxisLeft().setDrawAxisLine(false);
            lineAvgSleepEfficieny.getAxisLeft().setDrawGridLines(false);

            lineAvgSleepEfficieny.getAxisRight().setDrawAxisLine(false);
            lineAvgSleepEfficieny.getAxisRight().setDrawGridLines(false);

            lineAvgSleepEfficieny.getXAxis().setDrawAxisLine(false);
            lineAvgSleepEfficieny.getXAxis().setDrawGridLines(false);



            lineAvgSleepEfficieny.getXAxis().setDrawLabels(false);
            lineAvgSleepEfficieny.getLegend().setEnabled(false);

            lineAvgSleepEfficieny.setDoubleTapToZoomEnabled(false);
            lineAvgSleepEfficieny.setPinchZoom(false);







            return rootView;
        }
        public void runProgress(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final int precentage=0;
                    while (mProgressStatus < 63) {
                        mProgressStatus += 1;
                        // Update the progress bar
                        mHandler.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(mProgressStatus);
                                text.setText(""+mProgressStatus+"%");

                            }
                        });
                        try {



                            Thread.sleep(30);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        public void runProgressArgs(final int mProgress1, final Handler mHandler1, final ProgressBar progressBar1, final TextView text1){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int mProgressStatus = 0;
                    while (mProgressStatus < mProgress1) {
                        mProgressStatus += 1;
                        // Update the progress bar
                        final int finalMProgressStatus = mProgressStatus;
                        final int finalMProgressStatus1 = mProgressStatus;
                        mHandler1.post(new Runnable() {
                            public void run() {
                                progressBar1.setProgress(finalMProgressStatus);
                                text1.setText(""+ finalMProgressStatus1);

                            }
                        });
                        try {
                            Thread.sleep(30);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

    public void averageHoursSlept(View view){
        Intent intent = new Intent(this, Average_hours_slept.class);
        startActivity(intent);
    }

    public void sleepLogReport(View view){
        Intent intent = new Intent(this, SleepLogReport.class);
        startActivity(intent);
    }

}
