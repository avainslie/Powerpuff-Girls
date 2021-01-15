package com.example.powerpuffgirls;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
    private TextView resourceLink;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Resources resourceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_individual_resource);

        resourceName = findViewById(R.id.resource_name);
        resourceDescription = findViewById(R.id.resource_description);
        resourceLink = findViewById(R.id.resource_link);
        resourceLink.setClickable(true);
        resourceLink.setMovementMethod(LinkMovementMethod.getInstance());

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
                resourceRef = document.toObject(Resources.class);
                resourceName.setText(resourceRef.getName());
                resourceDescription.setText(resourceRef.getDescription());
                String link = resourceRef.getLink();
                resourceLink.setText(Html.fromHtml("<a href=" + link + "> " + link + "</a>"));
            }
        });

    }
}
