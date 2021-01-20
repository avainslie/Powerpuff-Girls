package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InterestsInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests_info);

        FloatingActionButton toUserProfile= (FloatingActionButton)findViewById(R.id.buttonToUserProfile);
        toUserProfile.setOnClickListener(userProfileView->openUserProfileActivity());

    }
    public void openUserProfileActivity(){
        Intent userProfileIntent=new Intent(this, UserProfileActivity.class);
        startActivity(userProfileIntent);
    }
}