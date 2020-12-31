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

public class RecommendationsActivity extends AppCompatActivity {

    private static final String TAG = "hello" ;
    private RecyclerView ResourceRecycler;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;


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
        adapter = new FirestoreRecyclerAdapter<Resources, ResourcesViewHolder>(options) {
            @NonNull
            @Override
            public ResourcesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
                return new ResourcesViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ResourcesViewHolder holder, int position, @NonNull Resources model) {
                holder.ResourceName.setText(model.getName());
                holder.ResourceDescription.setText(model.getDescription());
            }
        };

        ResourceRecycler.setHasFixedSize(true);
        ResourceRecycler.setLayoutManager(new LinearLayoutManager( this));
        ResourceRecycler.setAdapter(adapter);

    }

    private class ResourcesViewHolder extends RecyclerView.ViewHolder{

        private TextView ResourceName;
        private TextView ResourceDescription;

        public ResourcesViewHolder(@NonNull View itemView) {
            super(itemView);

            ResourceName = itemView.findViewById(R.id.ResourceName);
            ResourceDescription = itemView.findViewById(R.id.ResourceDescription);
        }
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
}