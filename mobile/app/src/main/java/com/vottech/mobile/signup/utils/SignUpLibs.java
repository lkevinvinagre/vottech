package com.vottech.mobile.signup.utils;

import com.vottech.mobile.signup.data.SignUp;

import com.vottech.mobile.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpLibs {

    private String resp;
    public SignUpLibs(){}

    public String SignupUser(SignUp signup)
    {
        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);
        Call<String> call = service.signUpUser(signup);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                {
                    resp = response.body();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                resp = t.getMessage();

            }
        });

        return resp;
    }
}
