package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class branch extends AppCompatActivity {

    Button submit,back;
    TextView branch;
    EditText rno,name,sem,fname,contact,dob;
    DatePickerDialog datePickerDialog;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_branch);

        branch = findViewById(R.id.branch);
        rno = findViewById(R.id.rollno);
        name = findViewById(R.id.name);
        sem = findViewById(R.id.sem);
        fname = findViewById(R.id.fname);
        contact = findViewById(R.id.phoneno);
        dob = findViewById(R.id.dob);
        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);



        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                datePickerDialog = new
                        DatePickerDialog(branch.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        dob.setText(dayOfMonth + "/" + (monthOfYear + "/" + year));
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        Intent i = getIntent();
        String str = i.getStringExtra("branch");
        String action = i.getStringExtra("action");
        branch.setText(str);


        db = openOrCreateDatabase("Student_Management", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS '" + str + "'(branch VACHAR,rno INTEGER primary key,name VARCHAR,sem INTEGER, fname VARCHAR, contact INTEGER, dob VARCHAR);");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(branch.this, "Back", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(branch.this, Navigation1.class);
                startActivity(i2);

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (action.equals("ADD")) {
                    if (branch.getText().toString().trim().length() == 0 ||
                            rno.getText().toString().trim().length() == 0 ||
                            name.getText().toString().trim().length() == 0 ||
                            sem.getText().toString().trim().length() == 0 ||
                            fname.getText().toString().trim().length() == 0 ||
                            contact.getText().toString().trim().length() == 0 ||
                            dob.getText().toString().trim().length() == 0) {
                        showMessage("Error", "Please enter all values");
                        return;
                    }
                    db.execSQL("INSERT INTO '" + str + "' VALUES('" + branch.getText() + "','" + rno.getText() + "','" + name.getText() +
                            "','" + sem.getText() + "','" + fname.getText() + "','" + contact.getText() + "','" + dob.getText() + "');");
                    showMessage("Success", "Record added successfully");
                    clearText();


                } else if (action.equals("SEARCH")) {

                    if (rno.getText().toString().trim().length() == 0) {
                        showMessage("Error", "Please enter Roll Number");
                        return;
                    }
                    Cursor c = db.rawQuery("SELECT * FROM '" + str + "' WHERE rno='" + rno.getText() + "'", null);
                    if (c.moveToFirst()) {
                        name.setText(c.getString(2));
                        sem.setText(c.getString(3));
                        fname.setText(c.getString(4));
                        contact.setText(c.getString(5));
                        dob.setText(c.getString(6));
                        Toast.makeText(branch.this, "Record Searched", Toast.LENGTH_SHORT).show();
                    } else {
                        showMessage("Error", "Invalid Rollno");
                        clearText();
                    }

                }
                else if (action.equals("MODIFY")) {

                    if(rno.getText().toString().trim().length()==0)
                    {
                        showMessage("Error", "Please enter Rollno");
                        return;
                    }
                    Cursor c=db.rawQuery("SELECT * FROM '" + str + "' WHERE rno='"+rno.getText()+"'", null);
                    if(c.moveToFirst())
                    {
                        db.execSQL("UPDATE '" + str + "'  SET name='" + name.getText() + "',sem='" + sem.getText() + "', fname='" + fname.getText() + "', contact ='" + contact.getText() + "',dob='" + dob.getText() + "' WHERE rno='" +rno.getText()+ "'");
                        showMessage("Success", "Record Modified");
                    }
                    else
                    {
                        showMessage("Error", "Invalid Rollno");
                    }
                    clearText();

                        }


                else if (action.equals("DELETE")) {

                    if (rno.getText().toString().trim().length() == 0) {
                        showMessage("Error", "Please enter Rollno");
                        return;
                    }
                    Cursor c = db.rawQuery("SELECT * FROM '" + str + "' WHERE rno='" + rno.getText() + "'", null);
                    if (c.moveToFirst()) {
                        db.execSQL("DELETE FROM '"+ str + "' WHERE rno='" + rno.getText() + "'");
                        showMessage("Success", "Record Deleted");
                    } else {
                        showMessage("Error", "Invalid Rollno");
                    }
                    clearText();
                                  }

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
        rno.setText("");
        name.setText("");
        sem.setText("");
        fname.setText("");
        contact.setText("");
        dob.setText("");

    }
    }

