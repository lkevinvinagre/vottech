package com.vottech.mobile.home.utils;

import com.vottech.mobile.home.data.Projects;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectsService {

    @GET("api/v1/projects/list")
    Call<List<Projects>> listProjects();

}
