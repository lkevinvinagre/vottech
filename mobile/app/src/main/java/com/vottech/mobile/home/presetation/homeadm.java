package com.vottech.mobile.home.presetation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.vottech.mobile.R;

public class homeadm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homeadm);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button projectsBtn = findViewById(R.id.projects_btn);
        Button visitorsBtn = findViewById(R.id.visitors_btn);
        projectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                renderFragment(new ProjectsF());
            }
        });
    }

    public void renderFragment(Fragment f)
    {
        FragmentManager fragmanager = getSupportFragmentManager();
        FragmentTransaction ft = fragmanager.beginTransaction();
        ft.replace(R.id.pf,f);
        ft.commit();
    }

}