package com.example.androidproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Room {
    private int id,
            capacity,
            priceByDay;
    private String image;

//    private String name;
//    private int imageId;

//    public static final Room[] rooms = {
//            new Room ("room1", R.drawable.room1),
//            new Room ("room2", R.drawable.room2)
//    };


    public Room(int id, int capacity, int priceByDay, String image) {
        this.id = id;
        this.capacity = capacity;
        this.priceByDay = priceByDay;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPriceByDay() {
        return priceByDay;
    }

    public void setPriceByDay(int priceByDay) {
        this.priceByDay = priceByDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
