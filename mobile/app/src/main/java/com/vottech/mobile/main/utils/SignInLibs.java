package com.vottech.mobile.main.utils;

import android.util.Log;

import com.vottech.mobile.main.data.SignIn;
import com.vottech.mobile.main.data.SignInListener;
import com.vottech.mobile.shared.data.ResponseModel;
import com.vottech.mobile.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInLibs {

    private String resp;

    private final SignInListener listener = new SignInListener() {
        @Override
        public void onSignInSuccess(String response) {}
        @Override
        public void onSignInFailure(String response) {}
    };
    public SignInLibs(){}

    public void SignInUser(SignIn signin)
    {

        SignInService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignInService.class);
        Call<ResponseModel> call = service.signUpUser(signin);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(!response.isSuccessful())
                {
                    String aux = response.body().getResponse();
                    Log.e("Login sem sucesso",aux);
                    resp = aux;
                    listener.onSignInFailure(aux);
                }
                String aux = response.body().getResponse();
                Log.e("Mensagem esperada: ",aux);
                resp = aux;
                listener.onSignInSuccess(aux);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                Log.e("Falha de envio: ",t.toString());

            }
        });
    }
    public String getResp()
    {
        return this.resp;
    }

}
