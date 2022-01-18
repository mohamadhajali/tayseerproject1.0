package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
    private static final String url = "http://192.168.1.115:80/mobileProject/get_items.php";
    public static final String DEFAULT = "N/A";

    private ArrayList<Room> roomList = new ArrayList<>();
    private RecyclerView recycler;
    private String userName;
    onClickInterface  onclickInterface ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_recycler);

        Intent intent = getIntent();

       recycler = findViewById(R.id.customer_recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        userName = intent.getStringExtra("userName");
        Toast.makeText(this,userName,Toast.LENGTH_SHORT);
        loadItems();
        click();

    }
public void click(){
    onclickInterface = new onClickInterface() {
        @Override
        public void setClick(String id , String Capacity , String price) {
            //Toast.makeText(CustomerRecycler.this,"Position is"+abc,Toast.LENGTH_LONG).show();
            SharedPreferences sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("RoomID",id);
            editor.putString("Capacity",Capacity);
            editor.putString("Price",price);
            editor.commit();

        connn();

        }
    };
}
public  void connn(){
    SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
    String rid= sharedPreferences.getString("RoomID",DEFAULT);

    int id = Integer.parseInt(rid);
    String url2 = "http://192.168.1.115:80/mobileProject/isReserved.php?roomID="+id;
    if (ContextCompat.checkSelfPermission(this,
            Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED) {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET},
                123);

    } else{
        CustomerRecycler.LoginTask log = new CustomerRecycler.LoginTask();
        log.execute(url2);

    }
}
    private void loadItems() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {

                    try {
                        JSONArray array = new JSONArray(response);
                            System.out.println(array.toString());
                        for (int i = 0; i<array.length(); i++){
                            JSONObject roomObject = array.getJSONObject(i);

                            int id = roomObject.getInt("roomID");
                            int capacity = roomObject.getInt("capacity");
                            int priceByDay = roomObject.getInt("priceByDay");
                            String image = roomObject.getString("image");

                            Room room = new Room(id, capacity, priceByDay, image);
                            roomList.add(room);

                        }
                    }catch (Exception e){

                    }
                    RecyclerAdapter adapter = new RecyclerAdapter(CustomerRecycler.this,
                            roomList,onclickInterface);
                    recycler.setAdapter(adapter);
                    for (int i = 0 ;i<roomList.size();i++){
                        System.out.println(roomList.get(i).toString());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(CustomerRecycler.this, error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(CustomerRecycler.this).add(stringRequest);
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
        System.out.println(str);
        return str;
    }
    private class LoginTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {

            return DownloadText(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
         //   Toast.makeText(LoginReceptionist.this,result,Toast.LENGTH_SHORT).show();
            if(result.equals("This room is reserved")){
                Toast.makeText(CustomerRecycler.this,result,Toast.LENGTH_SHORT).show();

            }else if(result.equalsIgnoreCase("This room id doesn't exist")){
                Toast.makeText(CustomerRecycler.this,result,Toast.LENGTH_SHORT).show();

            }else{
                //click();
                Intent intent =new Intent(CustomerRecycler.this, CheckIn.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
            }
        }
    }
}