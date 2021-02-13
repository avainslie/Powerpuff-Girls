package com.example.powerpuffgirls;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InterestsInfoActivity extends AppCompatActivity {

    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fstore= FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests_info);

        FloatingActionButton toUserProfile= findViewById(R.id.buttonToUserProfile);
        toUserProfile.setOnClickListener(userProfileView->openUserProfileActivity());

    }
    public void openUserProfileActivity(){
        Intent mainApp =new Intent(this, MainActivity2.class);
        Log.d("interestsinfo", "Main Activity 2");

        CheckBox research= (CheckBox) findViewById(R.id.research);
        CheckBox volunteering= (CheckBox) findViewById(R.id.volunteering);
        CheckBox academics= (CheckBox) findViewById(R.id.academics);
        CheckBox religion= (CheckBox) findViewById(R.id.religion);
        CheckBox performing= (CheckBox) findViewById(R.id.performing);
        CheckBox sportacativities= (CheckBox) findViewById(R.id.sportactivities);
        CheckBox leadership= (CheckBox) findViewById(R.id.leadership);
        CheckBox reading= (CheckBox) findViewById(R.id.reading);
        CheckBox community= (CheckBox) findViewById(R.id.community);


        List extraCurricularActivities=new ArrayList<>();

        if (research.isChecked()){
            String extraCurricularActivity=research.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (volunteering.isChecked()){
            String extraCurricularActivity=volunteering.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (academics.isChecked()){
            String extraCurricularActivity=academics.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (religion.isChecked()){
            String extraCurricularActivity=religion.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (performing.isChecked()){
            String extraCurricularActivity=performing.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (sportacativities.isChecked()){
            String extraCurricularActivity=sportacativities.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (leadership.isChecked()){
        String extraCurricularActivity=leadership.getText().toString().trim();
        extraCurricularActivities.add(extraCurricularActivity);
        } if (reading.isChecked()){
            String extraCurricularActivity=reading.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        } if (community.isChecked()){
            String extraCurricularActivity=community.getText().toString().trim();
            extraCurricularActivities.add(extraCurricularActivity);
        }
        Switch gaming=(Switch)findViewById(R.id.gaming);
        Switch sports=(Switch)findViewById(R.id.sport);
        Switch music=(Switch)findViewById(R.id.music);
        Switch beauty=(Switch)findViewById(R.id.beauty5);
        Switch books=(Switch)findViewById(R.id.book);
        Switch arts=(Switch)findViewById(R.id.arts);

        ArrayList interests=new ArrayList<>();

        if (gaming.isChecked()){
        String interest=gaming.getText().toString().trim();
        interests.add(interest);
        }
        if (sports.isChecked()){
            String interest=sports.getText().toString().trim();
            interests.add(interest);
        }
        if (books.isChecked()){
            String interest=books.getText().toString().trim();
            interests.add(interest);
        }
        if (music.isChecked()){
            String interest=music.getText().toString().trim();
            interests.add(interest);
        }
        if (beauty.isChecked()){
            String interest=beauty.getText().toString().trim();
            interests.add(interest);
        }
        if (arts.isChecked()){
            String interest=arts.getText().toString().trim();
            interests.add(interest);
        }





        SignUpActivity a= new SignUpActivity();
        HashMap<String, String> map = a.getHashmap();
        map.put("Extra-Curricular Activities",extraCurricularActivities.toString());
        map.put("interests",interests.toString());

        CollectionReference data = fstore.collection("Users");
        data.add(map);

        ProfileImage pi = new ProfileImage();
        if (pi.getImgbytes() != null){
            data.add(pi.getImgbytes());
        }



        startActivity(mainApp);
    }




}

