package com.example.powerpuffgirls;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InterestsInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests_info);

        FloatingActionButton toUserProfile= findViewById(R.id.buttonToUserProfile);
        toUserProfile.setOnClickListener(userProfileView->openUserProfileActivity());

    }
    public void openUserProfileActivity(){
        Intent mainApp =new Intent(this, MainActivity2.class);
        Log.d("interestsinfo", "Main Activity 2");
        startActivity(mainApp);
    }
}

