package com.vottech.mobile.home.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vottech.mobile.R;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.project_item,parent,false);

        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder
    {
        ImageView projectImg ;
        TextView projectTitleLb;
        TextView projectDescriptionLb;
        Button voteBtn;
        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            projectImg = itemView.findViewById(R.id.project_img);
            projectTitleLb = itemView.findViewById(R.id.projectTitle_lb);
            projectDescriptionLb = itemView.findViewById(R.id.projectDescription_lb);
            voteBtn = itemView.findViewById(R.id.button);
        }
    }
}
