package com.example.powerpuffgirls;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import android.content.*;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about_you);
        //FirebaseFirestore fstore = FirebaseFirestore.getInstance();

        TextView firstnameOutput = (TextView)findViewById(R.id.firstnameInput);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String firstname = intent.getStringExtra("message_key");

        // display the string into textView
        firstnameOutput.setText(firstname);


    }

}
