package com.vottech.mobile.main.utils;

import android.util.Log;

import com.vottech.mobile.main.data.SignIn;
import com.vottech.mobile.main.data.SignInRM;
import com.vottech.mobile.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInLibs {

    private String resp;
    public SignInLibs(){}

    public void SignInUser(SignIn signin)
    {

        SignInService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignInService.class);
        Call<SignInRM> call = service.signUpUser(signin);
        call.enqueue(new Callback<SignInRM>() {
            @Override
            public void onResponse(Call<SignInRM> call, Response<SignInRM> response) {
                if(!response.isSuccessful())
                {
                    Log.e("Login sem sucesso",response.body().getResponse());
                }
                Log.e("Mensagem esperada: ",response.body().getResponse());
                resp = response.body().toString();
            }

            @Override
            public void onFailure(Call<SignInRM> call, Throwable t) {

                Log.e("Falha de envio: ",t.toString());

            }
        });
    }
    public String getResp()
    {
        return this.resp;
    }

}
