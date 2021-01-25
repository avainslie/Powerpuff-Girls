package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EducationInfoActivity extends AppCompatActivity {

    Spinner studentSpinner;
    TextView mOutputSpinnerSection;
    //options to be displayed in spinner
    String[] studentTypes = {"Undergraduate Student", "Graduate Student", "High School Student", "Mature Student", "Diploma Student", "Certificate Student"};

    Spinner fieldOfStudySpinner;
    TextView studyOutputSpinnerSection;
    //options to be displayed in spinner
    String[] fieldsOfStudy = {"Art", "Business", "Science", "Engineering"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

                }
                if (position == 1) {
                    // mOutputSpinnerSection.setText("Graduate Student selected...");
                }
                if (position == 2) {
                    // mOutputSpinnerSection.setText("High School Student selected...");
                }
                if (position == 3) {
                    // mOutputSpinnerSection.setText("Mature Student is selected...");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

                }
                if (position == 1) {
                    // mOutputSpinnerSection.setText("Graduate Student selected...");
                }
                if (position == 2) {
                    // mOutputSpinnerSection.setText("High School Student selected...");
                }
                if (position == 3) {
                    // mOutputSpinnerSection.setText("Mature Student is selected...");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void openInterestsActivity(){
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");
        Intent interestsIntent=new Intent(this, InterestsInfoActivity.class);
        startActivity(interestsIntent);
        interestsIntent.putExtra("email",email);
        interestsIntent.putExtra("gender",gender);
        //interestsIntent.putExtra("interests?",interests);
    }
}