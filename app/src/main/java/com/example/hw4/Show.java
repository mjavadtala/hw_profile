package com.example.hw4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Show extends AppCompatActivity {
    TextView name;
    TextView family;
    TextView mail;
    TextView phone;
    Button btnS;
    Button btnE;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        name = findViewById(R.id.txtName);
        family = findViewById(R.id.txtFamily);
        mail = findViewById(R.id.txtMail);
        phone = findViewById(R.id.txtPhone);
        btnS = findViewById(R.id.btnSave);
        btnE = findViewById(R.id.btnEdit);
        Intent intent = getIntent();

        String flag = intent.getStringExtra("flag");

        if (flag.equals("1")) {


            name.setText(PreferenceManager.getDefaultSharedPreferences(Show.this)
                    .getString("name", "null"));
            family.setText(PreferenceManager.getDefaultSharedPreferences(Show.this)
                    .getString("family", "null"));
            mail.setText(PreferenceManager.getDefaultSharedPreferences(Show.this)
                    .getString("mail", "null"));
            phone.setText(PreferenceManager.getDefaultSharedPreferences(Show.this)
                    .getString("phone", "null"));
        }
        if (flag.equals("0")) {

            name.setText("name:" + intent.getStringExtra("name"));
            family.setText("family:" + intent.getStringExtra("family"));
            mail.setText("mail:" + intent.getStringExtra("mail"));
            phone.setText("phone:" + intent.getStringExtra("phone"));

            btnS.setOnClickListener((v)->{
                PreferenceManager.getDefaultSharedPreferences(Show.this).edit()
                        .putString("name",intent.getStringExtra("name"))
                        .putString("family",intent.getStringExtra("family"))
                        .putString("mail",intent.getStringExtra("mail"))
                        .putString("phone",intent.getStringExtra("phone")).apply();
                Intent intent1 = new Intent();
                setResult(Activity.RESULT_OK,intent1);
                finish();
            });
            btnE.setOnClickListener((v)->{
                Intent intent1 = new Intent();
                intent1.putExtra("name",intent.getStringExtra("name"));
                intent1.putExtra("family",intent.getStringExtra("family"));
                intent1.putExtra("mail",intent.getStringExtra("mail"));
                intent1.putExtra("phone",intent.getStringExtra("phone"));
                setResult(Activity.RESULT_OK,intent1);
                finish();
            });
        }


    }


}
