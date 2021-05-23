package com.example.studentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Navigation1 extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle nToggle;
    NavigationView navi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation1);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navi = (NavigationView)findViewById(R.id.navi);

        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                int menu_id = item.getItemId();

                switch (menu_id) {
                    case R.id.web:
                        Toast.makeText(Navigation1.this, "ACET Home Opening", Toast.LENGTH_SHORT).show();
                        Intent i2 = new Intent(Navigation1.this, websiteadd.class);
                        startActivity(i2);
                        break;

                    case R.id.about:
                        Toast.makeText(Navigation1.this, "ACET Home", Toast.LENGTH_SHORT).show();
                        Intent i3 = new Intent(Navigation1.this, AboutActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.log:
                        Toast.makeText(Navigation1.this, "ACET", Toast.LENGTH_SHORT).show();
                        Intent i4 = new Intent(Navigation1.this, SignIn_Activity.class);
                        startActivity(i4);
                        break;
                }

                return true;
            }
        });


        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
        addListenerOnButton5();
    }

    public boolean onNavigationItemSelected(MenuItem item) {

    return true ;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        if(nToggle.onOptionsItemSelected(item)){
            return true;

        }

        return  super.onOptionsItemSelected(item);
    }

    public void addListenerOnButton() {
        ImageButton portal = (ImageButton) findViewById(R.id.portal);
        portal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Navigation1.this, "Portal Opening", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Navigation1.this, portal.class);
                startActivity(i);

            }
        });

    }

    public void addListenerOnButton1() {
        ImageButton home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Navigation1.this, "ACET Home Opening", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Navigation1.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

    public void addListenerOnButton2() {
        ImageButton cse = (ImageButton) findViewById(R.id.cse);
        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "CSE";
                Toast.makeText(Navigation1.this, "ACET CSE", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Navigation2.class);
                i.putExtra("branch", str);
                startActivity(i);

            }
        });
    }
    public void addListenerOnButton3() {
        ImageButton mech = (ImageButton) findViewById(R.id.mech);
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "MECHANICAL";
                Toast.makeText(Navigation1.this, "ACET MECHANICAL", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Navigation2.class);
                i.putExtra("branch", str);
                startActivity(i);

            }
        });
    }
        public void addListenerOnButton4() {
            ImageButton ee = (ImageButton) findViewById(R.id.ee);
            ee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = "ELECTRICAL";
                    Toast.makeText(Navigation1.this, "ACET ELECTRICAL", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Navigation2.class);
                    i.putExtra("branch", str);
                    startActivity(i);

                }
            });
    }
            public void addListenerOnButton5() {
                ImageButton civil = (ImageButton) findViewById(R.id.civil);
                civil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str = "CIVIL";
                        Toast.makeText(Navigation1.this, "ACET CIVIL", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Navigation2.class);
                        i.putExtra("branch", str);
                        startActivity(i);


                    }
                });
        }
}
