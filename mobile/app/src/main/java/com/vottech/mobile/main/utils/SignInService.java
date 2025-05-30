package com.vottech.mobile.main.utils;

import com.vottech.mobile.main.data.SignIn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInService {

    @POST("api/v1/auth/signin")
    Call<String> signUpUser(@Body SignIn signin);

}
