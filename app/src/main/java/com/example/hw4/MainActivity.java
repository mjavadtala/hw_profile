package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    Button call;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        call = findViewById(R.id.call);
        edt = findViewById(R.id.number);

        btnLogin.setOnClickListener((v)->{
            Intent intent = new Intent(MainActivity.this,D.class);
            startActivity(intent);
        });
        call.setOnClickListener((v)->{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(edt.getText().toString()));
            if (ActivityCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        });

    }
}
