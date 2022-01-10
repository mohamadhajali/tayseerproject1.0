/*package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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

    }
    private String processRequest(String restUrl) throws UnsupportedEncodingException {
        String userName  = username.getText().toString();
        String fullName  = fullname.getText().toString();
        String phoneNum  = phonenumber.getText().toString();

        String data = URLEncoder.encode("userName", "UTF-8")
                + "=" + URLEncoder.encode(userName, "UTF-8");

        data += "&" + URLEncoder.encode("fullName", "UTF-8") + "="
                + URLEncoder.encode(fullName, "UTF-8");

        data += "&" + URLEncoder.encode("phoneNum", "UTF-8")
                + "=" + URLEncoder.encode(phoneNum, "UTF-8");

        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL(restUrl);

            // Send POST data request

          //  URLConnection conn = url.openConnection();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        // Show response on activity
        return text;



    }


    public void btnAddOnClick(View view) throws UnsupportedEncodingException {
        String restUrl = "http://192.168.1.108:80/mobileProject/addCustomer.php";
        this.processRequest(restUrl);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else{
            SendPostRequest runner = new SendPostRequest();
            runner.execute(restUrl);
            StrictMode.ThreadPolicy gfgPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(gfgPolicy);

            /*Thread thread = new Thread(new MyTask2(restUrl));
            thread.start();
        }
    }
    protected class SendPostRequest extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {

            try{
                return processRequest(strings[0]);
            }catch (UnsupportedEncodingException ex){

            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(addnewcustomer.this,s,Toast.LENGTH_SHORT);
        }
    }
}


class MyTask2 implements Runnable{
    private String url;
    public MyTask2(String url){
        this.url = url;
    }
    @Override
    public void run() {

    }


}
*/
package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

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


    }
    public void btnAddOnClick(View view)
    {

        String url = "http://192.168.1.11:80/mobileProject/addCustomer.php";
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else{
            SendPostRequest runner = new SendPostRequest();
            runner.execute(url);

            //  Thread thread = new Thread(new MyTask2(url));
            //thread.start();
        }
    }


    private String processRequest(String restUrl) throws UnsupportedEncodingException {
        String userName = username.getText().toString();
        String fullName = fullname.getText().toString();
        String phoneNum = phonenumber.getText().toString();


        String data = URLEncoder.encode("userName", "UTF-8")
                + "=" + URLEncoder.encode(userName, "UTF-8");

        data += "&" + URLEncoder.encode("fullName", "UTF-8") + "="
                + URLEncoder.encode(fullName, "UTF-8");

        data += "&" + URLEncoder.encode("phoneNum", "UTF-8")
                + "=" + URLEncoder.encode(phoneNum, "UTF-8");

        String text = "";
        BufferedReader reader = null;

        // Send data
        try {

            // Defined URL  where to send data
            URL url = new URL(restUrl);

            // Send POST data request

            //  URLConnection conn = url.openConnection();
            // HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Show response on activity

        System.out.println(text);
        return text;


    }
    private class SendPostRequest extends AsyncTask<String ,Void,String>
    {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return processRequest(urls[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result){
            Toast.makeText(addnewcustomer.this,result,Toast.LENGTH_SHORT).show();
        }
    }
}
