package com.example.powerpuffgirls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

    public void filter(View v){
        if (user.getDegreeMajor().equals("Biology")){ // replace "biology" with get text from resource

        }
    }

    @Override
    public void onItemClick() {
        Log.d("ITEM CLICK", "THE ITEM IS CLICKED");
    }
}