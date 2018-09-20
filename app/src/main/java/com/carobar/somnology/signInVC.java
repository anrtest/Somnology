package com.carobar.somnology;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.carobar.somnology.core.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class signInVC extends AppCompatActivity {
    public Context ctxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_vc);
        ctxt = this;

        if(SleepApp.get().checkSharedPref()){
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
            finish();
        }


        View headerView = findViewById(R.id.includedHeaderSignin);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        TextView btnFgtPswd = findViewById(R.id.signin_forget_password);

        TextView headerTextSwitcher = headerView.findViewById(R.id.headerViewScreenText);
        headerTextSwitcher.setText("Sign In");

        Button backButton = headerView.findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        btnFgtPswd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                forgetPassword(view);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(view);
            }
        });

    }
    public void forgetPassword(View view){
        Intent intent = new Intent(this, ForgetPassword.class);
        startActivity(intent);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, SignIn_Up.class);
        startActivity(intent);
    }
    public Boolean checkConnectivity(){
        ConnectivityManager cm =  (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    public void displayPopup(String title, String message, String posBtnTitle){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle(title);
        builder.setMessage(message).setCancelable(false)
                .setPositiveButton(posBtnTitle, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void signIn(View view){
        EditText email = findViewById(R.id.txtEmailSignin);
        EditText password = findViewById(R.id.txtPasswordSignin);
        if(TextUtils.isEmpty(email.getText()) || TextUtils.isEmpty(password.getText())){

            displayPopup( getString(R.string.alertBoxTitle), "Please enter both fields", "OK");

        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()){
            displayPopup( getString(R.string.alertBoxTitle), "Please enter a valid email address", "OK");
        }

        else {

            Boolean isConnected = checkConnectivity();
            if(!isConnected){
                displayPopup( getString(R.string.alertBoxTitle), "Application unable to connect to internet, please check your network connection", "OK");
            }
            else {
                UserEntity user = SleepApp.get().getDB().userDao().findByEmail(email.getText().toString());
                if (user != null) {
                    if (password.getText().toString().equals(user.getPassword())) {
                        SleepApp.get().setLoginUser(email.getText().toString());
                        SharedPreferences settings = getSharedPreferences(SleepApp.PREFS_LOGIN_SLEEPAPP, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("loginUser", email.getText().toString());
                        editor.commit();
                        Intent intentSettings = new Intent(this, UserProfile.class);
                        startActivity(intentSettings);
                        finish();
                    } else {
                        password.setText("");
                        displayPopup( getString(R.string.alertBoxTitle), "Login ID or Password does not match.", "OK");

                    }
                } else {
                    displayPopup( getString(R.string.alertBoxTitle), "Login ID or Password does not match.", "OK");

                }
            }
        }
    }
}
