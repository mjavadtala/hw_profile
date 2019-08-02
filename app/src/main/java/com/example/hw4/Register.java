package com.example.hw4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText name;
    EditText family;
    EditText mail;
    EditText phone;

    Button btnP;
    Button btnB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        btnP = findViewById(R.id.btn_preview);
        btnB = findViewById(R.id.btn_back);

        name = findViewById(R.id.edt_name);
        family = findViewById(R.id.edt_family);
        mail = findViewById(R.id.edt_mail);
        phone = findViewById(R.id.edt_phone);

        btnP.setOnClickListener((v)->{
            Intent intent = new Intent(Register.this,Show.class);
            intent.putExtra("name",name.getText().toString());
            intent.putExtra("family",family.getText().toString());
            intent.putExtra("mail",mail.getText().toString());
            intent.putExtra("phone",phone.getText().toString());
            intent.putExtra("flag","0");
            startActivityForResult(intent,113);


        });
        btnB.setOnClickListener((v)->{
            Intent intent = new Intent(Register.this,D.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 113){
            if (resultCode == Activity.RESULT_OK){
                name.setText(data.getStringExtra("name"));
                family.setText(data.getStringExtra("family"));
                mail.setText(data.getStringExtra("mail"));
                phone.setText(data.getStringExtra("phone"));
            }
        }
    }
}
