package com.vottech.mobile.signup.utils;

import android.util.Log;

import com.vottech.mobile.signup.data.SignUp;

import com.vottech.mobile.shared.utils.RetrofitClient;
import com.vottech.mobile.signup.data.SignUpRM;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpLibs {

    String resp;
    public SignUpLibs(){}

    public void SignupUser(SignUp signup)
    {
        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);
      
        Call<SignUpRM> call = service.signUpUser(signup);
        call.enqueue(new Callback<SignUpRM>() {

            @Override
            public void onResponse(Call<SignUpRM> call, Response<SignUpRM> response) {
                if(!response.isSuccessful())
                {
                    Log.e("Resposta Sem sucesso",response.body().response);
                    return;
                }
                Log.e("Mensagem esperada",response.body().response);
                resp = response.body().response;
            }

            @Override
            public void onFailure(Call<SignUpRM> call, Throwable t) {
                Log.e("falha de envio",t.toString());
            }
        });
    }
    public String getResp()
    {
        return this.resp;
    }
}
