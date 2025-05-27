package com.vottech.mobile.signup.presetation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vottech.mobile.R;
import com.vottech.mobile.shared.utils.RetrofitClient;
import com.vottech.mobile.signup.data.SignUp;
import com.vottech.mobile.signup.utils.SignUpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private String resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);

        SignUp signup = new SignUp();
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

                resp = "User not found";

            }
        });
    }
}