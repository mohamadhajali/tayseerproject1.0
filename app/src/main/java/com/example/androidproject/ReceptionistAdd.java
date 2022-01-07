package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceptionistAdd extends AppCompatActivity {
    Button addnewcou;
    Button viewdeatils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_add);
        addcoustmer();
        showroomdielis();
    }

    private void showroomdielis() {
        viewdeatils = findViewById(R.id.viewdeatils);
        viewdeatils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ReceptionistAdd.this, roomdielis.class);
                startActivity(intent);
            }
        });
    }

    private void addcoustmer() {
        addnewcou = findViewById(R.id.addnewcous);
        addnewcou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ReceptionistAdd.this, addnewcustomer.class);
                startActivity(intent);
            }
        });
    }
}