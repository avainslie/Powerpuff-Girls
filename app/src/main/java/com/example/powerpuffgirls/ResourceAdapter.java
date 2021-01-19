package com.example.powerpuffgirls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import org.w3c.dom.Text;

public class ResourceAdapter extends FirestoreRecyclerAdapter<Resources, ResourceAdapter.ResourceHolder> {

    private OnItemClickListener listener;

    public ResourceAdapter(@NonNull FirestoreRecyclerOptions<Resources> options) {
        super(options);
    }

    /**
     * Where the recycling happens
     * @param holder
     * @param position
     * @param model
     */
    @Override
    protected void onBindViewHolder(@NonNull ResourceHolder holder, int position, @NonNull Resources model) {
        holder.ResourceName.setText(model.getName());
        holder.ResourceDescription.setText(model.getDescription());
    }


    /**
     *
     * @param parent basically just the recycler view
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ResourceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
        return new ResourceHolder(v);
    }

    /**
     * Inner class
     */
    class ResourceHolder extends RecyclerView.ViewHolder{
        // Variables for views in the layout for the recycler
        TextView ResourceName;
        TextView ResourceDescription;

        public ResourceHolder(@NonNull View itemView) {
            super(itemView);
            ResourceName = itemView.findViewById(R.id.ResourceName);
            ResourceDescription = itemView.findViewById(R.id.ResourceDescription);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position = getAdapterPosition();
                    // Can get a snapshot here and send it to another activity
                    // Pass context to adapter
                    // Call start activity right here

                    // but better approach to send click to underlying activity and decide what we want to do there
                    // so lets create an interface

                    // Prevent some crashing in case theres a deletion of a document
                    if(position != RecyclerView.NO_POSITION && listener != null){
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
