package com.example.powerpuffgirls;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.powerpuffgirls.ui.login.FilterFragment;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

// TODO: Add intent when click on resource and filter by user info on clicking filter btn

public class RecommendationsFragment extends Fragment implements View.OnClickListener, FilterFragment.FilterDialogListener {

    //TAG
    private String TAG = "RecommendationsFragment";

    // gets data
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<String> filterBy;
    private Query resourceRef;
    private ResourceAdapter adapter;
    private RecyclerView recyclerView;
    private Button rbtn;
    private Button ebtn;
    private Button gbtn;
    private ImageButton filter;
    private String currentView = "Resources";
    private View v;


    public RecommendationsFragment() {
        // Required empty public constructor
    }

    public static RecommendationsFragment newInstance() {
        RecommendationsFragment fragment = new RecommendationsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        resourceRef = db.collection(currentView);

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.activity_recommendations, container, false);
        setViews(v);

        rbtn.setOnClickListener(this);
        ebtn.setOnClickListener(this);
        gbtn.setOnClickListener(this);
        filter.setOnClickListener(v -> {
            //Create filter popup menu
            //Selected will be added to array
            //Array returned and used as filters for firebase calls
            //refresh recycler
            Toast.makeText(getContext(), "Filter clicked", Toast.LENGTH_SHORT);
            Log.d(TAG, "Hello World");
            showFilterDialog();
        });
        return v;


    }


    @Override
    public void onStart() {
        super.onStart();
        setUpRecyclerView();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void setViews(View v) {
        recyclerView = v.findViewById(R.id.ResourceRecycler);
        rbtn = v.findViewById(R.id.resourceButton);
        ebtn = v.findViewById(R.id.eventButton);
        gbtn = v.findViewById(R.id.groupButton);
        filter = v.findViewById(R.id.filterButton);
    }

    private void setUpRecyclerView(){

        // Create options, how we get query into adapter
        FirestoreRecyclerOptions<Resources> options = new FirestoreRecyclerOptions.Builder<Resources>()
                .setQuery(resourceRef, Resources.class).build();

        // Assign adapter variable
        adapter = new ResourceAdapter(options);

        // Create ref to recycler view
        recyclerView.setHasFixedSize(true); // for performance
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((documentSnapshot, position) -> {
            Resources resource = documentSnapshot.toObject(Resources.class);
            String id = documentSnapshot.getId();
            Log.d("CLICK","CLICKED" + id);

            Intent i = new Intent(getContext(), IndividualResource.class);
            i.putExtra("id", id);

            startActivity(i);
        });
    }

    public void refreshRecycler() {
        resourceRef = db.collection(currentView).whereArrayContainsAny("filter_tags", filterBy);
        Log.d(TAG, resourceRef.toString());
        setUpRecyclerView();
        adapter.startListening();
        Log.d(TAG, "Showing filtered resources");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.resourceButton:
                currentView = "Resources";
                resourceRef = db.collection(currentView);
                setUpRecyclerView();
                adapter.startListening();
                break;
            case R.id.eventButton:
                currentView = "Upcoming Events";
                resourceRef = db.collection(currentView);
                setUpRecyclerView();
                adapter.startListening();
                break;
            case R.id.groupButton:
                currentView = "Community Groups";
                resourceRef = db.collection(currentView);
                setUpRecyclerView();
                adapter.startListening();
                break;
        }
    }

    private void showFilterDialog() {
        FragmentManager fm = getFragmentManager();
        FilterFragment filterFragment = FilterFragment.newInstance("Some Title");
        // SETS the target fragment for use later when sending results
        filterFragment.setTargetFragment(RecommendationsFragment.this, 300);
        filterFragment.show(fm, "fragment_filter");
    }

    @Override
    public void onFinishSelectingDialog(ArrayList<String> filterChoices) {
        filterBy = filterChoices;
        Log.d(TAG, filterBy.toString());
        refreshRecycler();
    }

}