package com.example.powerpuffgirls.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.powerpuffgirls.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FilterFragment extends DialogFragment{

    private ArrayList<String> filterBy = new ArrayList<>();
    private FloatingActionButton returnToFrag;

    public FilterFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public interface FilterDialogListener {
        void onFinishSelectingDialog(ArrayList<String> filterChoices);
    }

    public static FilterFragment newInstance(String title) {
        FilterFragment frag = new FilterFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.filter_layout, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        returnToFrag = (FloatingActionButton) view.findViewById(R.id.buttonToRecommendations);
        returnToFrag.setOnClickListener(toRecommendationsView -> storeFilterOps(view));
    }

    public void storeFilterOps(View v){
        CheckBox everyone= (CheckBox) v.findViewById(R.id.everyoneF);
        CheckBox women= (CheckBox) v.findViewById(R.id.womenF);
        CheckBox asian= (CheckBox) v.findViewById(R.id.asianF);
        CheckBox hispanic= (CheckBox) v.findViewById(R.id.hispanicF);
        CheckBox black= (CheckBox) v.findViewById(R.id.blackF);
        CheckBox indigenous= (CheckBox) v.findViewById(R.id.indigenousF);
        CheckBox middleEastern= (CheckBox) v.findViewById(R.id.middleeasternF);
        CheckBox scholarships= (CheckBox) v.findViewById(R.id.scholarshipsF);
        CheckBox bursaries= (CheckBox) v.findViewById(R.id.bursariesF);
        CheckBox research= (CheckBox) v.findViewById(R.id.researchF);
        CheckBox highSchool= (CheckBox) v.findViewById(R.id.highschoolF);
        CheckBox undergraduate= (CheckBox) v.findViewById(R.id.undergraduateF);
        CheckBox graduate= (CheckBox) v.findViewById(R.id.graduateF);
        CheckBox continuingEducation= (CheckBox) v.findViewById(R.id.continuingeducationF);
        CheckBox singleParent= (CheckBox) v.findViewById(R.id.singleparentF);
        CheckBox veteran= (CheckBox) v.findViewById(R.id.veteranF);
        CheckBox disability= (CheckBox) v.findViewById(R.id.disabilityF);

        if (everyone.isChecked()){
            String option=everyone.getText().toString().trim();
            filterBy.add(option);
        } if (women.isChecked()){
            String option=women.getText().toString().trim();
            filterBy.add(option);
        } if (asian.isChecked()){
            String option=asian.getText().toString().trim();
            filterBy.add(option);
        } if (hispanic.isChecked()){
            String option=hispanic.getText().toString().trim();
            filterBy.add(option);
        } if (black.isChecked()){
            String option=black.getText().toString().trim();
            filterBy.add(option);
        } if (indigenous.isChecked()){
            String option=indigenous.getText().toString().trim();
            filterBy.add(option);
        } if (middleEastern.isChecked()){
            String option=middleEastern.getText().toString().trim();
            filterBy.add(option);
        } if (scholarships.isChecked()) {
            String option = scholarships.getText().toString().trim();
            filterBy.add(option);
        } if (bursaries.isChecked()){
            String option=bursaries.getText().toString().trim();
            filterBy.add(option);
        } if (research.isChecked()){
            String option=research.getText().toString().trim();
            filterBy.add(option);
        } if (highSchool.isChecked()){
            String option=highSchool.getText().toString().trim();
            filterBy.add(option);
        } if (undergraduate.isChecked()){
            String option=undergraduate.getText().toString().trim();
            filterBy.add(option);
        } if (graduate.isChecked()){
            String option=graduate.getText().toString().trim();
            filterBy.add(option);
        } if (continuingEducation.isChecked()){
            String option=continuingEducation.getText().toString().trim();
            filterBy.add(option);
        } if (singleParent.isChecked()){
            String option=singleParent.getText().toString().trim();
            filterBy.add(option);
        } if (veteran.isChecked()){
            String option=veteran.getText().toString().trim();
            filterBy.add(option);
        } if (disability.isChecked()) {
            String option = disability.getText().toString().trim();
            filterBy.add(option);
        }

    sendBackResult();
    }

    // Call this method to send the data back to the parent fragment
    public void sendBackResult() {
        // Notice the use of `getTargetFragment` which will be set when the dialog is displayed
        FilterDialogListener listener = (FilterDialogListener) getTargetFragment();
        listener.onFinishSelectingDialog(filterBy);
        dismiss();
    }
}

