package com.carobar.somnology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.carobar.somnology.core.entities.UserEntity;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        View headerView = findViewById(R.id.changePassword_Header);
        TextView screenText = headerView.findViewById(R.id.headerViewScreenText);
        screenText.setText("Reset Password");

        Button backButton = headerView.findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

       Button resetPswdBtn = findViewById(R.id.btnResetPswd);

        resetPswdBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetPassword(view);
            }
        });


    }
    public void goBack(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void resetPassword(View view){
        MainActivity mainActivity = new MainActivity();
        EditText oldPswd = findViewById(R.id.ResetOldPswd);
        EditText newPassword = findViewById(R.id.ResetNewPswd);
        EditText verifyPassword = findViewById(R.id.ResetReTypeNewPswd);
        if(oldPswd.getText().toString().equals("") || newPassword.getText().toString().equals("") || verifyPassword.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "All fields are required.", Toast.LENGTH_LONG).show();
        }
        else{
            if (newPassword.getText().toString().equals(verifyPassword.getText().toString())){
                String loginUser = SleepApp.get().getLoginUser();
                final UserEntity user = SleepApp.get().getDB().userDao().findByEmail(loginUser);
                if(user.getPassword().equals(oldPswd.getText().toString())){
                    user.setPassword(newPassword.getText().toString());
                    SleepApp.get().getDB().userDao().updateUser(user);
                    Toast.makeText(getApplicationContext(), "Password Updated.", Toast.LENGTH_LONG).show();
                    goBack(view);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Entered old password doesn't match.", Toast.LENGTH_LONG).show();
                }
            }
            else{

//                mainActivity.customDialog("Wrong Password!","New password and re-type password are not matched.","","");
                Toast.makeText(getApplicationContext(), "New password and re-type password are not matched.", Toast.LENGTH_LONG).show();
                verifyPassword.setText("");
            }
        }

    }
}
