package com.example.powerpuffgirls.ui.login;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.powerpuffgirls.IndividualResource;
import com.example.powerpuffgirls.R;
import com.example.powerpuffgirls.ResourceAdapter;
import com.example.powerpuffgirls.Resources;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Random;

public class ActivityFragment extends Fragment {

    //TAG
    private String TAG = "HomeFragment";
    // gets data
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Query resourceRef;
    private String currentView = "ActivitiesOfTheDay";
    private View v;
    private ArrayList<String> activities = new ArrayList<>();
    private TextView act;

    public ActivityFragment() {
        // Required empty public constructor
    }

    public static ActivityFragment newInstance() {
        return new ActivityFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        resourceRef = db.collection(currentView);

        resourceRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Collection<Object> values = document.getData().values();
                    for (Object value: values){
                        Log.d(TAG, value.toString());
                        activities.add(value.toString());
                        //Log.d(TAG, activities.get(0));
                    }
                }
                Random r = new Random();
                act.setText(activities.get(r.nextInt(4)));
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });

        v = inflater.inflate(R.layout.act_of_the_day, container, false);
        act = v.findViewById(R.id.activityName);
        Button skip = v.findViewById(R.id.skipBtn);
        skip.setOnClickListener(listener);

        // Inflate the layout for this fragment
        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getDayStringNew(LocalDate date, Locale locale) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getDisplayName(TextStyle.FULL, locale);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random r = new Random();
            act.setText(activities.get(r.nextInt(4)));
        }
    };

}