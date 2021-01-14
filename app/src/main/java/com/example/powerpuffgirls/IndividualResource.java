package com.example.powerpuffgirls;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class IndividualResource extends AppCompatActivity {

    private String TAG = "IndividualResource";

    private TextView resourceName;
    private TextView resourceDescription;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Resources resourceRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_resource);

        resourceName = findViewById(R.id.Resource_name);
        resourceDescription = findViewById(R.id.Resource_description);

        setupTextViews();

    }

    public void setupTextViews() {

        String id = getIntent().getStringExtra("id");
        Log.d("New", "The id clicked is: " + id);
        DocumentReference docRef = db.collection("Resources").document(id);
        Log.d("docRef", docRef.getId());
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });

        Log.d(TAG, "omfg");
        resourceName.setText(resourceRef.getName());
        Log.d("resName", "Name is: "+ resourceRef.getName());
        resourceDescription.setText(resourceRef.getDescription());
        Log.d("res", "Name is: "+ resourceRef.getName());
        Log.d("resDesc", "Desc is: "+ resourceRef.getDescription());
    }
}
