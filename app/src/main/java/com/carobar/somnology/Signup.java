package com.carobar.somnology;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.carobar.somnology.core.entities.UserEntity;

public class Signup extends AppCompatActivity {
    public Context ctxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ctxt = this;

        if(SleepApp.get().checkSharedPref()){
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
            finish();
        }

        Button createButton = findViewById(R.id.btnSignupCreateAccount);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(view);
            }
        });

        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        View headerView = findViewById(R.id.signUp_Header);

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Create Account");
    }
    public void createUser(View view){
        EditText emailField = findViewById(R.id.SignUpEmail);
        EditText passwordField = findViewById(R.id.SignUpPassword);
        TextView emailNotify = findViewById(R.id.signup_EmailNotify);
        TextView passwordNotify = findViewById(R.id.signup_PasswordNotify);

        UserEntity user = SleepApp.get().getDB().userDao().findByEmail(emailField.getText().toString());
        if(user != null){
            Toast.makeText(getApplicationContext(), "User with email '"+user.getMailID()+"' already registered.", Toast.LENGTH_LONG).show();
            emailNotify.setText("Email already registered.");
            emailNotify.setVisibility(View.VISIBLE);
            //Intent intent = new Intent(this, signInVC.class);
            //startActivity(intent);

        }
        else{
            UserEntity newUser = new UserEntity();
            newUser.setMailID(emailField.getText().toString());
            newUser.setPassword(passwordField.getText().toString());
            SleepApp.get().getDB().userDao().insertAll(newUser);
            SleepApp.get().setLoginUser(emailField.getText().toString());
            SharedPreferences settings = getSharedPreferences(SleepApp.PREFS_LOGIN_SLEEPAPP, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("loginUser", emailField.getText().toString());
            editor.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("MobileSleepDoc");
            builder.setMessage(R.string.successfulSignupMessage).setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(ctxt, Profile.class);
                            startActivity(intent);
                            finish();
                        }
                    });

        }

    }

    public void goBack(View view){
        Intent intent = new Intent(this, SignIn_Up.class);
        startActivity(intent);
    }
}
