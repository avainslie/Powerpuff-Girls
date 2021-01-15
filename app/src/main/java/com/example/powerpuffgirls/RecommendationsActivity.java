package com.example.powerpuffgirls;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

// TODO: Add intent when click on resource and filter by user info on clicking filter btn

public class RecommendationsActivity extends AppCompatActivity {

    // gets data
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference resourceRef = db.collection("Resources");
    private ResourceAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_recommendations2);

        setUpRecyclerView();

        }

        private void setUpRecyclerView(){
            // Create query
            Query query = resourceRef;


            // Create options, how we get query into adapter
            FirestoreRecyclerOptions<Resources> options = new FirestoreRecyclerOptions.Builder<Resources>()
                    .setQuery(query, Resources.class).build();

            // Assign adapter variable
            adapter = new ResourceAdapter(options);

            // Create ref to recycler view
            RecyclerView recyclerView = findViewById(R.id.ResourceRecycler);
            recyclerView.setHasFixedSize(true); // for performance
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener((documentSnapshot, position) -> {
                Resources resource = documentSnapshot.toObject(Resources.class);
                String id = documentSnapshot.getId();
                Log.d("CLICK","CLICKED" + id);

                Intent i = new Intent(RecommendationsActivity.this, IndividualResource.class);
                i.putExtra("id", id);

                startActivity(i);
            });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}