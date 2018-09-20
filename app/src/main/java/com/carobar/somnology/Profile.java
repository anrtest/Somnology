package com.carobar.somnology;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.carobar.somnology.core.entities.UserEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String loginUser = SleepApp.get().getLoginUser();
        final UserEntity user = SleepApp.get().getDB().userDao().findByEmail(loginUser);
        final List<String> genderList = Arrays.asList(this.getResources().getStringArray(R.array.genderList));

        View headerView = findViewById(R.id.profile_header);

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Profile Info");

        Button backButton = headerView.findViewById(R.id.back);
        Button doneButton = headerView.findViewById(R.id.done);
        doneButton.setVisibility(View.VISIBLE);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        //Footer Menu
//        final Context ctxt = this;
//        final Footer footerObj = new Footer();
//        View footerView = findViewById(R.id.profile_footer);
        //Footer Menu Buttons
//        Button profileBtn = footerView.findViewById(R.id.ProfileFooter);
//        Button reportsBtn = footerView.findViewById(R.id.ReportsFooter);
//        Button storeBtn = footerView.findViewById(R.id.StoreFooter);
//        Button resourceBtn = footerView.findViewById(R.id.ResourcesFooter);
//
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

        ImageButton sleepImage = btmBarView.findViewById(R.id.imageButtonMain);
        sleepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomNavigationView.logSleep(view);
            }
        });



        final EditText userFname = findViewById(R.id.profileinfoFname);
        final EditText userLname = findViewById(R.id.profileinfoLname);
        final EditText userEmail = findViewById(R.id.profileinfoEmail);
        final EditText userBirthdate = findViewById(R.id.profileinfoBirthdate);
        final Spinner userGender = findViewById(R.id.profileinfoGender);
        final EditText userMobile = findViewById(R.id.profileinfoMobileN);
        final EditText userAddress = findViewById(R.id.profileinfoAddress);
        final EditText userCity = findViewById(R.id.profileinfoCity);
        final EditText userState = findViewById(R.id.profileinfoState);
        final EditText userZip = findViewById(R.id.profileinfoZipcode);
        Button medicalProblemBtn = findViewById(R.id.profileinfoMedicalproblem);
        Button medicationBtn = findViewById(R.id.profileinfoMedication);
        Button changePswd = findViewById(R.id.profileinfoChangepassword);


        final String dateFormat = "MM/dd/yyyy";
        final Calendar profileCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener pickDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                profileCalendar.set(Calendar.YEAR, year);
                profileCalendar.set(Calendar.MONTH, month);
                profileCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

                userBirthdate.setText(sdf.format(profileCalendar.getTime()));
            }
        };

        changePswd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetPswd(view);
            }
        });

        userBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Profile.this, pickDate, profileCalendar.get(Calendar.YEAR), profileCalendar.get(Calendar.MONTH), profileCalendar.get(Calendar.DAY_OF_MONTH) ).show();
            }
        });

        userFname.setText(user.getFirstName());
        userLname.setText(user.getLastName());
        userEmail.setText(user.getMailID());
        if(user.getGender() != null) {

            int genderId = genderList.indexOf(user.getGender());
            userGender.setSelection(genderId);
        }
        if(user.getBirthDate() != null){
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
            try {
                Date bDate = sdf.parse(user.getBirthDate());
                userBirthdate.setText(sdf.format(bDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        userMobile.setText(user.getMobileNo());
        userAddress.setText(user.getAddress());
        userCity.setText(user.getCity());
        userState.setText(user.getState());
        userZip.setText(user.getZipCode());

        //button functions
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setFirstName(userFname.getText().toString());
                user.setLastName(userLname.getText().toString());
                user.setMailID(userEmail.getText().toString());
                user.setBirthDate(userBirthdate.getText().toString());
                user.setGender(userGender.getSelectedItem().toString());
                user.setMobileNo(userMobile.getText().toString());
                user.setAddress(userAddress.getText().toString());
                user.setCity(userCity.getText().toString());
                user.setState(userState.getText().toString());
                user.setZipCode(userZip.getText().toString());
                SleepApp.get().getDB().userDao().updateUser(user);
                editSuccess(view);


            }
        });

    }
    public void editSuccess(View view){
        final View view1 = view;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title


        alertDialogBuilder.setTitle(Html.fromHtml("<center><font color='#000000'>MobileSleepDoc</font></center>"));

        // Setting Alert Dialog Message
//
        alertDialogBuilder.setMessage(Html.fromHtml("<center><font color='#000000'>Sleep Profile updated successfully</font></center>"));
//        alertDialogBuilder.setView()

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(Profile.this, Settings.class);
                startActivity(intent);
            }

        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        final Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        LinearLayout.LayoutParams positiveBtnLL = (LinearLayout.LayoutParams)positiveButton.getLayoutParams();
        positiveBtnLL.gravity = Gravity.CENTER;
        positiveButton.setLayoutParams(positiveBtnLL);
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.background_light);
        //alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorBlue));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorBlue));
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setLayoutParams(positiveBtnLL);

    }
    public void goBack(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void resetPswd(View view){
        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);
    }

}
