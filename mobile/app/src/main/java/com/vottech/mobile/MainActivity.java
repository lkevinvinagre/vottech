package com.vottech.mobile;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vottech.mobile.main.data.SignIn;
import com.vottech.mobile.main.utils.SignInLibs;
import com.vottech.mobile.signup.presetation.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userOrMail_field;
    private EditText password_field;
    private TextView issue_lb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userOrMail_field = findViewById(R.id.userMail_field);
        password_field = findViewById(R.id.password_field);
        issue_lb = findViewById(R.id.issue_lb);
        issue_lb.setVisibility(GONE);
    }

    public void signInUser(View view)
    {
        String issue= "*";
        String userOrMail = userOrMail_field.getText().toString();
        String password = password_field.getText().toString();
        if(userOrMail.isEmpty()) issue += "Campo Usuario/email e obrigatorio \n";
        if(password.isEmpty()) issue += "Campo Senha e obrigatorio \n";
        if(issue.equals("*"))
        {
            SignInLibs libs = new SignInLibs();
            SignIn signin = new SignIn();
            signin.setUserOrMail(userOrMail);
            signin.setPassword(password);
            libs.SignInUser(signin);
            issue = libs.getResp();
        }
        issue_lb.setText(issue);
        issue_lb.setVisibility(VISIBLE);

    }

    public void gotoSignUpActivity(View view)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}