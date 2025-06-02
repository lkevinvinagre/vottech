package com.vottech.mobile.signup.utils;

import android.util.Log;

import com.vottech.mobile.shared.data.ResponseModel;
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
      
        Call<ResponseModel> call = service.signUpUser(signup);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(!response.isSuccessful())
                {
                    String aux = response.body().getResponse();
                    Log.e("Resposta Sem sucesso",aux);
                    resp = aux;
                }
                String aux = response.body().getResponse();
                Log.e("Mensagem esperada",aux);
                resp = aux;
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("falha de envio",t.toString());
            }
        });
    }
    public String getResp()
    {
        return this.resp;
    }
}
