package com.vottech.mobile.signup.utils;

import com.vottech.mobile.shared.data.ResponseModel;
import com.vottech.mobile.signup.data.SignUp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpService {

    @POST("api/v1/auth/signup")
    Call<ResponseModel> signUpUser(@Body SignUp signup);
}
