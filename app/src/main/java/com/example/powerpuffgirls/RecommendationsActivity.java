package com.example.powerpuffgirls;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

// TODO: Add intent when click on resource and filter by user info on clicking filter btn

public class RecommendationsActivity extends Fragment {

    // gets data
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference resourceRef = db.collection("Resources");
    private ResourceAdapter adapter;
    private RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public RecommendationsActivity() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SmsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecommendationsActivity newInstance(String param1, String param2) {
        RecommendationsActivity fragment = new RecommendationsActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        setUpRecyclerView();

    }

//    private void setUpRecyclerView(){
//        // Create query
//        Query query = resourceRef;
//
//
//        // Create options, how we get query into adapter
//        FirestoreRecyclerOptions<Resources> options = new FirestoreRecyclerOptions.Builder<Resources>()
//                .setQuery(query, Resources.class).build();
//
//        // Assign adapter variable
//        adapter = new ResourceAdapter(options);
//
//        // Create ref to recycler view
//        recyclerView.setHasFixedSize(true); // for performance
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//
//        adapter.setOnItemClickListener((documentSnapshot, position) -> {
//            Resources resource = documentSnapshot.toObject(Resources.class);
//            String id = documentSnapshot.getId();
//            Log.d("CLICK","CLICKED" + id);
//
//            Intent i = new Intent(getContext(), IndividualResource.class);
//            i.putExtra("id", id);
//
//            startActivity(i);
//        });
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_recommendations2, container, false);
//        recyclerView = v.findViewById(R.id.ResourceRecycler);
        return v;
    }




//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
//        setContentView(R.layout.activity_recommendations2);
//
//        setUpRecyclerView();
//
//    }
//
//    private void setUpRecyclerView(){
//        // Create query
//        Query query = resourceRef;
//
//
//        // Create options, how we get query into adapter
//        FirestoreRecyclerOptions<Resources> options = new FirestoreRecyclerOptions.Builder<Resources>()
//                .setQuery(query, Resources.class).build();
//
//        // Assign adapter variable
//        adapter = new ResourceAdapter(options);
//
//        // Create ref to recycler view
//        RecyclerView recyclerView = findViewById(R.id.ResourceRecycler);
//        recyclerView.setHasFixedSize(true); // for performance
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//        adapter.setOnItemClickListener((documentSnapshot, position) -> {
//            Resources resource = documentSnapshot.toObject(Resources.class);
//            String id = documentSnapshot.getId();
//            Log.d("CLICK","CLICKED" + id);
//
//            Intent i = new Intent(RecommendationsActivity.this, IndividualResource.class);
//            i.putExtra("id", id);
//
//            startActivity(i);
//        });
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }

}