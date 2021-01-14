package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class IndividualResource extends AppCompatActivity {

    private TextView resourceName;
    private TextView resourceDescription;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference resourceRef = db.collection("Resources");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_resource);

        resourceName = findViewById(R.id.Resource_name);
        resourceDescription = findViewById(R.id.Resource_description);

        setupTextViews();

    }

    public void setupTextViews(){

        String id = getIntent().getStringExtra("id");
        Log.d("New", "The id clicked is: "+ id);

        resourceRef.whereEqualTo("id", id);



        //resourceName.setText(res.getName());
        //resourceDescription.setText();
    }

}
