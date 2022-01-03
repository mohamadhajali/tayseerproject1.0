package com.example.androidproject;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button res;
    Button cous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receptionistavtivity();
        customeractivity();
    }

    private void customeractivity() {
        cous = findViewById(R.id.customer);
        cous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, CustomerLogin.class);
                startActivity(intent);
            }
        });
    }

    private void receptionistavtivity() {
        res = findViewById(R.id.receptionist);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, LoginReceptionist.class);
                startActivity(intent);
            }
        });
    }


}