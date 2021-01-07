package com.example.powerpuffgirls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class FirestoreAdapter extends FirestoreRecyclerAdapter<Resources, FirestoreAdapter.ResourcesViewHolder> {

    private OnListItemClick onListItemClick;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirestoreAdapter(@NonNull FirestoreRecyclerOptions<Resources> options, OnListItemClick onListItemClick) {
        super(options);
        this.onListItemClick =  onListItemClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull ResourcesViewHolder holder, int position, @NonNull Resources model) {
        holder.ResourceName.setText(model.getName());
        holder.ResourceDescription.setText(model.getDescription());
    }

    @NonNull
    @Override
    public ResourcesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
        return new ResourcesViewHolder(view);
    }

    public class ResourcesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView ResourceName;
        private TextView ResourceDescription;


        // Adding in on click here
        public ResourcesViewHolder(@NonNull View itemView) {
            super(itemView);

            // Items to display
            ResourceName = itemView.findViewById(R.id.ResourceName);
            ResourceDescription = itemView.findViewById(R.id.ResourceDescription);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClick.onItemClick();
        }
    }

    public interface OnListItemClick {
        void onItemClick();
    }

}
