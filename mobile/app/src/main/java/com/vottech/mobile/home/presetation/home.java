package com.vottech.mobile.home.presetation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vottech.mobile.R;
import com.vottech.mobile.home.data.ProjectAdapter;
import com.vottech.mobile.home.utils.ProjectsLibs;


public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView projetosRv = findViewById(R.id.projetos_rv);
        projetosRv.setLayoutManager(new LinearLayoutManager(this));
        projetosRv.setHasFixedSize(true);
        
        ProjectsLibs.setProjects();
        ProjectAdapter adapter = new ProjectAdapter(this,ProjectsLibs.getProjects());
        projetosRv.setAdapter(adapter);
    }
}