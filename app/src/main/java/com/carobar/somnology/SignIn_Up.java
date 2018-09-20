package com.carobar.somnology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in__up);

        if(SleepApp.get().checkSharedPref()){
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
            finish();
        }

        Button btnSignIn = findViewById(R.id.BtnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInIntent(view);
            }
        });

        Button btnSignUp = findViewById(R.id.BtnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpIntent(view);
            }
        });

        TextView frgetPswd = findViewById(R.id.signin_forget_password);
        frgetPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPswdIntent(view);
            }
        });

        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

    }
    public void signInIntent(View view){
        Intent intent = new Intent(this, signInVC.class);
        startActivity(intent);
    }
    public void signUpIntent(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
    public void forgetPswdIntent(View view){
        Intent intent = new Intent(this, ForgetPassword.class);
        startActivity(intent);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainIntro.class);
        startActivity(intent);
    }
}
