package com.example.studentmanagement;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SignIn_Activity extends AppCompatActivity {

     TextView create;
     Button btnstart;
    SQLiteDatabase db;
    TextView uname,pass;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_sign_in_);
         uname = findViewById(R.id.uname);
         pass = findViewById(R.id.pass);
         create = findViewById(R.id.wantCreate);
         db = openOrCreateDatabase("Student_Management", Context.MODE_PRIVATE, null);
         create.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(SignIn_Activity.this, "Sign Up First", Toast.LENGTH_SHORT).show();

                 Intent i = new Intent(SignIn_Activity.this, SignUp_Activity.class);
                 startActivity(i);


             }
         });

         btnstart = findViewById(R.id.btnEnter);
         btnstart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (uname.getText().toString().trim().length() == 0 || pass.getText().toString().trim().length() == 0) {
                     showMessage("Error", "Please enter all necessary details");
                     Intent i = new Intent(SignIn_Activity.this, optionActivity.class);
                     startActivity(i);
                     return;
                 }
                 Cursor c = db.rawQuery("SELECT rno,userName,password FROM users WHERE rno='" + uname.getText() + "' or userName='" + uname.getText() + "'", null);
                // System.out.println(c.getString(2));
                 if (c.moveToFirst()) {
                     if (pass.getText().toString().equals(c.getString(2))) {
                         Toast.makeText(SignIn_Activity.this, "Welcome", Toast.LENGTH_SHORT).show();
                         Intent i = new Intent(SignIn_Activity.this, Navigation1.class);
                         startActivity(i);
                     }
                     else {
                         showMessage("Error", "Invalid Username or Password");
                         clearText();
                     }
                 }
                 else {
                     showMessage("Error", "Invalid Username or Password");
                     clearText();}
             }
         });
     }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        uname.setText("");
        pass.setText("");
    }
         }
