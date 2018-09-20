package com.carobar.somnology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        View headerView = findViewById(R.id.forgetPassword_Header);

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Forget Passwrod");
    }

    public void goBack(View view){
        Intent intent = new Intent(this, SignIn_Up.class);
        startActivity(intent);
    }
}
