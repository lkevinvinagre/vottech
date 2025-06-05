package com.vottech.mobile.home.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vottech.mobile.R;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    List<Projects> projects;
    public ProjectAdapter(Context context, List<Projects> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.project_item,parent,false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectViewHolder holder, int position)
    {
        holder.projectTitleLb.setText(projects.get(0).getName());
        holder.projectDescriptionLb.setText(projects.get(0).getDescription());
        holder.voteBtn.setText("Votar");
    }

    @Override
    public int getItemCount() {

        return projects.size();
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
