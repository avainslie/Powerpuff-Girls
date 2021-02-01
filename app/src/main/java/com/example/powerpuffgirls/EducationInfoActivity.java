package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.*;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class EducationInfoActivity extends AppCompatActivity {

    FirebaseFirestore fstore;
    private FirebaseAuth fAuth;
    Spinner studentSpinner;
    TextView mOutputSpinnerSection;
    String studentType;
    //options to be displayed in spinner
    String[] studentTypes = {"Undergraduate Student", "Graduate Student", "High School Student", "Mature Student", "Diploma Student", "Certificate Student"};

    Spinner fieldOfStudySpinner;
    TextView studyOutputSpinnerSection;
    String fieldOfStudy;
    //options to be displayed in spinner
    String[] fieldsOfStudy = {"Art", "Business", "Science", "Engineering"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fstore=FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_info);

        FloatingActionButton toInterests = (FloatingActionButton) findViewById(R.id.buttonToInterests);
        toInterests.setOnClickListener(InterestsView -> openInterestsActivity());

        studentSpinner = findViewById(R.id.studentSpinnerButton);
        mOutputSpinnerSection = findViewById(R.id.outputSpinnerSection);

        fieldOfStudySpinner=findViewById(R.id.fieldOfStudySpinnerButton);
        studyOutputSpinnerSection=findViewById(R.id.fieldOfStudyTitle);



        //Creating the ArrayAdapter instance having the list of options
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, studentTypes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setting the ArrayAdapter data on the Spinner
        studentSpinner.setAdapter(aa);

        ArrayAdapter fs = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fieldsOfStudy);
        fs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fieldOfStudySpinner.setAdapter(fs);

        //spinner item click handler
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //METHOD 1: Get text from selected item's position & set it to TextView
                //mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());

                //METHOD 2: Get the position of item selected, & perform specific task
                if (position == 0) {
                    //mOutputSpinnerSection.setText("Undergraduate Student selected");
                    studentType = "Undergraduate Student";

                }
                if (position == 1) {
                    // mOutputSpinnerSection.setText("Graduate Student selected...");
                    studentType = "Graduate Student";
                }
                if (position == 2) {
                    // mOutputSpinnerSection.setText("High School Student selected...");
                    studentType = "High School Student";
                }
                if (position == 3) {
                    // mOutputSpinnerSection.setText("Mature Student is selected...");
                    studentType = "Mature Student";
                }
                if (position == 4) {
                    // mOutputSpinnerSection.setText("Mature Student is selected...");
                    studentType = "Diploma Student";
                }
                if (position == 5) {
                    // mOutputSpinnerSection.setText("Mature Student is selected...");
                    studentType = "Certificate Student";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please select a student type!",Toast.LENGTH_LONG).show();
            }
        });

        fieldOfStudySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //METHOD 1: Get text from selected item's position & set it to TextView
                //mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());

                //METHOD 2: Get the position of item selected, & perform specific task
                if (position == 0) {
                    //mOutputSpinnerSection.setText("Undergraduate Student selected");
                    fieldOfStudy = "Art";
                }
                if (position == 1) {
                    // mOutputSpinnerSection.setText("Graduate Student selected...");
                    fieldOfStudy = "Business";
                }
                if (position == 2) {
                    // mOutputSpinnerSection.setText("High School Student selected...");
                    fieldOfStudy = "Science";
                }
                if (position == 3) {
                    // mOutputSpinnerSection.setText("Mature Student is selected...");
                    fieldOfStudy = "Engineering";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please select a study area!",Toast.LENGTH_LONG).show();
            }
        });



    }

    public void openInterestsActivity(){

        SignUpActivity a= new SignUpActivity();
        HashMap<String, String> map = a.getHashmap();
        map.put("studentType",studentType);

        map.put("fieldOfStudy",fieldOfStudy);

        CollectionReference data = fstore.collection("Users");
        data.add(map);



        Intent interestsIntent=new Intent(this, InterestsInfoActivity.class);
        startActivity(interestsIntent);
    }
}