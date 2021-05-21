package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class optionActivity extends AppCompatActivity {

    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(optionActivity.this, "Login Has Been Clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(optionActivity.this, SignIn_Activity.class);
                startActivity(i);


            }
        });


        signup = findViewById(R.id.btnSignUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(optionActivity.this, "SignUp Has Been Clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(optionActivity.this, SignUp_Activity.class);
                startActivity(i);


            }
        });
    }

}