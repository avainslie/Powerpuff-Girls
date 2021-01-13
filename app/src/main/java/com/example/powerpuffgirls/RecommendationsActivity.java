package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

// TODO: Add intent when click on resource and filter by user info on clicking filter btn

public class RecommendationsActivity extends AppCompatActivity implements FirestoreAdapter.OnListItemClick {

    private static final String TAG = "hello" ;
    private RecyclerView ResourceRecycler;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreAdapter adapter;


    // https://www.youtube.com/watch?v=cBwaJYocb9I&ab_channel=TVACStudio
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations2);

        ResourceRecycler = findViewById(R.id.ResourceRecycler);
        firebaseFirestore = FirebaseFirestore.getInstance();

        // Query
        Query query = firebaseFirestore.collection("Resources");


        // Options
        FirestoreRecyclerOptions<Resources> options = new FirestoreRecyclerOptions.Builder<Resources>()
                .setQuery(query, Resources.class).build();


        // Adapter
        adapter = new FirestoreAdapter(options, this);

        ResourceRecycler.setHasFixedSize(true);
        ResourceRecycler.setLayoutManager(new LinearLayoutManager( this));
        ResourceRecycler.setAdapter(adapter);

    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    User user = new User("Ainslie","Biology");


    /**
     * Filters what user sees based on their data
     * @param v
     */
    public void filter(View v){

    }

    @Override
    public void onItemClick(int position) {
        Log.d("ITEM CLICK", "THE ITEM IS CLICKED " + position);
        Intent i = new Intent(this, IndividualResource.class);
        startActivity(i);
    }

}