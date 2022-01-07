package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addnewcustomer extends AppCompatActivity {
        EditText fullname;
        EditText username;
        EditText phonenumber;
        Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewcustomer);
        setup();
    }
    public void setup(){
        fullname = findViewById(R.id.userfullname);
        username = findViewById(R.id.username);
        phonenumber = findViewById(R.id.phonenumber);
        save = findViewById(R.id.savecustmer);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOnDataBase();
            }
        });
    }
    public void saveOnDataBase(){

    }
}