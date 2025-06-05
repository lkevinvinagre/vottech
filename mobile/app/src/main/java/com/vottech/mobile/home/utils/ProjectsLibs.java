package com.vottech.mobile.home.utils;

import android.util.Log;

import com.vottech.mobile.home.data.Projects;
import com.vottech.mobile.shared.utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectsLibs {
    private static List<Projects> projects;

    public static void setProjects()
    {
        ProjectsService service = RetrofitClient
                .getRetrofitInstance()
                .create(ProjectsService.class);
        Call<List<Projects>> call = service.listProjects();
        call.enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, Response<List<Projects>> response) {
                if(!response.isSuccessful())
                {
                    Log.e("Erro ao listar projetos",response.message());
                    return;
                }
                projects = response.body();
            }
            @Override
            public void onFailure(Call<List<Projects>> call, Throwable throwable) {
                Log.e("Erro ao listar projetos",throwable.toString());
            }
        });
    }
    public static void updateProjects()
    {
        if(!isEmpty()) clearProjects();
        setProjects();
    }
    public static List<Projects> getProjects()
    {
        return projects;
    }
    public static void clearProjects()
    {
        projects = null;
    }
    public static boolean isEmpty()
    {
        if(projects == null) return true;
        return false;
    }
}
