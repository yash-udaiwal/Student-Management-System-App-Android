package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp_Activity extends AppCompatActivity {

    TextView singin;
    TextView uname,phn,mail,pass,rno;
    Button reg;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        uname = findViewById(R.id.userName);
        rno = findViewById(R.id.rno);
        phn = findViewById(R.id.phone);
        mail = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        reg = findViewById(R.id.btnRegister);
        singin = findViewById(R.id.signIn);

        db=openOrCreateDatabase("Student_Management", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(rno INTEGER primary key,userName VARCHAR,phone INTEGER, email VARCHAR, password VARCHAR);");

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rno.getText().toString().trim().length()==0||
                        uname.getText().toString().trim().length()==0||
                        phn.getText().toString().trim().length()==0||
                        mail.getText().toString().trim().length()==0||
                        pass.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO users VALUES('"+rno.getText()+"','"+uname.getText()+
                        "','"+phn.getText()+"','"+mail.getText()+"','"+pass.getText()+"');");
                showMessage("Success", "Record added successfully");
                clearText();
                Toast.makeText(SignUp_Activity.this, "SignIn", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                startActivity(i);


            }
        });
    }

    public void gotoSign(){
        Intent i = new Intent(SignUp_Activity.this, SignIn_Activity.class);
        startActivity(i);

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
        rno.setText("");
        uname.setText("");
        phn.setText("");
        mail.setText("");
        pass.setText("");
    }



        }
