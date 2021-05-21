package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Navigation2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);

        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
        addListenerOnButton5();

    }

    public void addListenerOnButton() {
        ImageButton add = (ImageButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String str = i.getStringExtra("branch");
                Toast.makeText(Navigation2.this, "Add Records", Toast.LENGTH_SHORT).show();
                i = new Intent(getApplicationContext(), branch.class);
                i.putExtra("branch", str);
                i.putExtra("action","ADD");
                startActivity(i);
            }
        });

    }

    public void addListenerOnButton1() {
        ImageButton search = (ImageButton) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String str = i.getStringExtra("branch");
                Toast.makeText(Navigation2.this, "Search Records", Toast.LENGTH_SHORT).show();
                i = new Intent(getApplicationContext(), branch.class);
                i.putExtra("branch", str);
                i.putExtra("action","SEARCH");
                startActivity(i);
            }
        });
    }

    public void addListenerOnButton2() {
        ImageButton modify = (ImageButton) findViewById(R.id.modify);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String str = i.getStringExtra("branch");
                Toast.makeText(Navigation2.this, "Modify Records", Toast.LENGTH_SHORT).show();
                i = new Intent(getApplicationContext(), branch.class);
                i.putExtra("branch", str);
                i.putExtra("action","MODIFY");
                startActivity(i);
            }
        });
    }
    public void addListenerOnButton3() {
        ImageButton delete = (ImageButton) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String str = i.getStringExtra("branch");
                Toast.makeText(Navigation2.this, "Delete Records", Toast.LENGTH_SHORT).show();
                i = new Intent(getApplicationContext(), branch.class);
                i.putExtra("branch", str);
                i.putExtra("action","DELETE");
                startActivity(i);
            }
        });
    }
    public void addListenerOnButton4() {
        ImageButton logout = (ImageButton) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignIn_Activity.class);
                Toast.makeText(Navigation2.this, "LOGOUT", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }

    public void addListenerOnButton5() {
        ImageButton home = (ImageButton) findViewById(R.id.homebtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Navigation1.class);
                Toast.makeText(Navigation2.this, "HOME", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}