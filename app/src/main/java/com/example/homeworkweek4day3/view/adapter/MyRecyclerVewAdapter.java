package com.example.homeworkweek4day3.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.homeworkweek4day3.R;
import com.example.homeworkweek4day3.model.repo.repo.RepoResponse;

import java.util.ArrayList;

public class MyRecyclerVewAdapter extends RecyclerView.Adapter<MyRecyclerVewAdapter.ViewHolder>{
    //List of user that will be populated into the recycler view
    ArrayList<RepoResponse> repoArrayList;

    //Constructor for the Adapter
    public MyRecyclerVewAdapter(ArrayList<RepoResponse> repoArrayList) {
        this.repoArrayList = repoArrayList;
    }

    //Inflate the xml into active memory (renders)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        //return new instance of the viewholder( We need to inflate(render) the view to passing
        //                                           by telling the context of where this is going
        //                                           to be rendered, the layout to inflate, the viewgroup
        //                                            to  assign it to, and if we need a root level attachment)
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.repo_item, viewGroup, false));
    }

    // Once we have the viewholder, we then populated the data when we bind to the created viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        //Get the item's information which we wish to populate for that viewholder
        RepoResponse currentUserBeingPopulated = repoArrayList.get(position);
        //use the passed viewholder to access the items view and populate
        viewHolder.tvRepoName.setText(currentUserBeingPopulated.getName());
        viewHolder.tvRepolanguage.setText(currentUserBeingPopulated.getLanguagesUrl());
        viewHolder.tvLastUpdate.setText(currentUserBeingPopulated.getUpdatedAt());

    }

    @Override
    public int getItemCount() {
        return repoArrayList.size();
    }


    //Inner class view container.  This container holds the views that we will use for each item.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRepoName;
        TextView tvRepolanguage;
        TextView tvLastUpdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRepoName = itemView.findViewById(R.id.tvRepoName);
            tvRepolanguage = itemView.findViewById(R.id.tvRepolanguage);
            tvLastUpdate = itemView.findViewById(R.id.tvLastUpdate);

        }
    }
}

