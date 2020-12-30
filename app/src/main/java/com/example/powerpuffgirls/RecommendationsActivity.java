package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RecommendationsActivity extends AppCompatActivity {

    public RecommendationsActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
    }

    String result = " ";
    String DBendpoint = "db-powerpuff.cehjjw63yvf7.ca-central-1.rds.amazonaws.com";
    String charset = "UTF-8";


    // https://openjdk.java.net/groups/net/httpclient/recipes.html


    // https://www.trustingeeks.com/displaying-data-in-listview-fetched-from-a-webservice/
    //ArrayList<Flowers> flowersList = new ArrayList<Flowers>();

    // https://stackoverflow.com/questions/8376072/whats-the-readstream-method-i-just-can-not-find-it-anywhere
    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public void practice(View v) throws IOException {
        Toast.makeText(getApplicationContext(),"Hello Javatpoint", Toast.LENGTH_SHORT).show();
    }

}