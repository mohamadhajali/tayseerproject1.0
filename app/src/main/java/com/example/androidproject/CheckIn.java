package com.example.androidproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CheckIn extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    TextView id;
    TextView cap;
    TextView pric;
    EditText checkindate;
    EditText checkoutdate;
    Button checkin;
    String price;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String rid= sharedPreferences.getString("RoomID",DEFAULT);
        String capacity =  sharedPreferences.getString("Capacity",DEFAULT);
         price =  sharedPreferences.getString("Price",DEFAULT);
        id = findViewById(R.id.roomId);
        cap = findViewById(R.id.roomCapacity);
        pric = findViewById(R.id.roomPriceByDay);
        id.setText(rid);
        cap.setText(capacity);
        pric.setText(price);
        checkindate = findViewById(R.id.checkindate);
        checkoutdate = findViewById(R.id.chekoutdate);
        checkin = findViewById(R.id.checkinbutton);


    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void calculateDate(View view){
        String startday = String.valueOf(checkindate.getText());
        String endDay = String.valueOf(checkoutdate.getText());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");
        LocalDate startDateValue = LocalDate.parse(startday, dateFormatter);
        LocalDate endDateValue = LocalDate.parse(endDay, dateFormatter);
        long days = ChronoUnit.DAYS.between(startDateValue, endDateValue)+1;

        System.out.println(days*Integer.parseInt(price));
    }
}