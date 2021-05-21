package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Navigation1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation1);

        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
        addListenerOnButton5();
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
