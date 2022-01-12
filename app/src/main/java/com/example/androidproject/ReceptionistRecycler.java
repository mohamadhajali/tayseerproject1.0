package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ReceptionistRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_recycler);
/*
        Intent intent = getIntent();

        RecyclerView recycler = (RecyclerView) findViewById(R.id.customer_recycler);

        String[] description = new String [Room.rooms.length];
        int[] ids = new int[Room.rooms.length];

        for(int i=0; i<description.length; i++){
            description[i] = Room.rooms[i].getName();
            ids[i] = Room.rooms[i].getImageId();
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        ReceptionistAdapter adapter1 = new ReceptionistAdapter(description, ids);
        recycler.setAdapter(adapter1);

 */
    }
}