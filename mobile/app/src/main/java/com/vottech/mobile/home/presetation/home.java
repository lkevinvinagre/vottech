package com.vottech.mobile.home.presetation;

import android.icu.lang.UCharacter;
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
import com.vottech.mobile.home.data.Projects;

import java.util.List;

public class home extends AppCompatActivity {

    private RecyclerView projetosRv;
    private List<Projects> projects;

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
        projetosRv = findViewById(R.id.projetos_rv);
        projetosRv.setLayoutManager(new LinearLayoutManager(this));
        projetosRv.setHasFixedSize(true);

        ProjectAdapter adapter = new ProjectAdapter(this,projects);
        projetosRv.setAdapter(adapter);
    }
}