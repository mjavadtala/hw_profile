package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

public class D extends AppCompatActivity {

    Button btnR;
    Button btnP;
    Button o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        btnR = findViewById(R.id.btnR);
        btnP = findViewById(R.id.btnP);
        o = findViewById(R.id.o);
        o.setOnClickListener((v)->{
            DrawerLayout drawer = findViewById(R.id.D);
            if (drawer.isDrawerOpen(Gravity.RIGHT))
                drawer.closeDrawer(Gravity.RIGHT);
            else
                drawer.openDrawer(Gravity.RIGHT);
        });
        btnR.setOnClickListener((v)->{
            Intent intent = new Intent(D.this,Register.class);
            startActivity(intent);
        });
        btnP.setOnClickListener((v)->{
            Intent intent = new Intent(D.this,Show.class);
            intent.putExtra("flag","1");
            startActivity(intent);
        });
    }
}
