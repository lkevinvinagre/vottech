package com.vottech.mobile.main.utils;

import com.vottech.mobile.main.data.SignIn;
import com.vottech.mobile.shared.data.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInService {

    @POST("api/v1/auth/signin")
    Call<ResponseModel> signUpUser(@Body SignIn signin);

}
