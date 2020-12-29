package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RecommendationsActivity extends AppCompatActivity {

    Button showRsrcBtn;
    RecyclerView resourceList;
    DataBaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        // Assigning the IDs to the variables
        showRsrcBtn = findViewById(R.id.showRsrcBtn);
        resourceList = findViewById(R.id.resourceList);

        // Creates the database and table
        myDb = new DataBaseHelper(RecommendationsActivity.this);

        showRsrcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Resources resource = new Resources(1, "PURE Award", "Research award for the summer. Need prof to apply" );

                Toast.makeText(RecommendationsActivity.this, resource.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void showResources(View v){

    }

}