package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class IndividualResource extends AppCompatActivity {

    private TextView resourceName;
    private TextView resourceDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_resource);

        resourceName = findViewById(R.id.Resource_name);
        resourceDescription = findViewById(R.id.Resource_description);
    }
}
