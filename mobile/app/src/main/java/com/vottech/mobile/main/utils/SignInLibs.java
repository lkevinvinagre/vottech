package com.vottech.mobile.main.utils;

import com.vottech.mobile.main.data.SignIn;
import com.vottech.mobile.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInLibs {

    private String resp;
    public SignInLibs(){}

    public String SignInUser(SignIn signin)
    {
        SignInService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignInService.class);
        Call<String> call = service.signUpUser(signin);
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

                resp = "Não foi possivel cadastrar o usuario";

            }
        });

        return resp;
    }

}
