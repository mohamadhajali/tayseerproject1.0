package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CustomerRecycler extends AppCompatActivity {

    private static final String url = "http://192.168.1.113:80/mobileProject/getRoom.php";
    List<Room> roomList;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_recycler);

        Intent intent = getIntent();

        recycler = findViewById(R.id.customer_recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        roomList = new ArrayList<>();

//        ArrayList<String> roomList = new ArrayList<>();
//
//        RecyclerView recycler = (RecyclerView) findViewById(R.id.customer_recycler);

//        String[] description = new String [Room.rooms.length];
//        int[] ids = new int[Room.rooms.length];
//
//        for(int i=0; i<description.length; i++){
//            description[i] = Room.rooms[i].getName();
//            ids[i] = Room.rooms[i].getImageId();
//        }



        loadRooms();
        /*
        RecyclerView recycler = (RecyclerView) findViewById(R.id.customer_recycler);

        String[] description = new String [Room.rooms.length];
        int[] ids = new int[Room.rooms.length];

        for(int i=0; i<description.length; i++){
            description[i] = Room.rooms[i].getName();
            ids[i] = Room.rooms[i].getImageId();
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter adapter = new RecyclerAdapter(description, ids);
        recycler.setAdapter(adapter);
         */
    }

    public void loadRooms(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray rooms = new JSONArray(response);

                    for(int i=0; i<rooms.length(); i++){
                        JSONObject roomObject = rooms.getJSONObject(i);

                        roomList.add(new Room(
                                roomObject.getInt("id"),
                                roomObject.getInt("capacity"),
                                roomObject.getInt("priceByDay"),
                                roomObject.getString("image")
                        ));
                        /*
                        int id = roomObject.getInt(id);
                        int capacity = roomObject.getInt(capacity);
                        int priceByDay = roomObject.getInt(priceByDay);
                        String image = roomObject.getString(image);

                        Room room = new Room(id, capacity, priceByDay, image);
                        roomList.add(room);

                         */
                    }
                    RecyclerAdapter adapter = new RecyclerAdapter(CustomerRecycler.this, roomList);
                    recycler.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CustomerRecycler.this, error.getMessage(), Toast.LENGTH_LONG);
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);

    }
/*
    private void custRec() {

    }



    public void btnLoginClick(View view) {
        String url = "http://192.168.1.113:80/mobileProject/login.php?userName="+usernameEdt.getText();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else{
            CustomerRecycler.CustomerRecyclerTask log = new CustomerRecycler.CustomerRecyclerTask();
            log.execute(url);

        }
    }

    private InputStream OpenHttpConnection(String urlString) throws IOException
    {
        InputStream in = null;
        int response = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }
        catch (Exception ex)
        {
            Log.d("Networking", ex.getLocalizedMessage());
            throw new IOException("Error connecting");
        }
        return in;
    }
    private String DownloadText(String URL)
    {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        try {
            in = OpenHttpConnection(URL);
        } catch (IOException e) {
            Log.d("Networking", e.getLocalizedMessage());
            return "";
        }

        InputStreamReader isr = new InputStreamReader(in);
        int charRead;
        String str = "";
        char[] inputBuffer = new char[BUFFER_SIZE];
        try {
            while ((charRead = isr.read(inputBuffer))>0) {
                //---convert the chars to a String---
                String readString =
                        String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        } catch (IOException e) {
            Log.d("Networking", e.getLocalizedMessage());
            return "";
        }
        return str;
    }


    private class CustomerRecyclerTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            return DownloadText(strings[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(CustomerRecycler.this,result,Toast.LENGTH_SHORT).show();
            if(result.equals("Log in successfully"))
                custRec();
        }
    }
    */


}