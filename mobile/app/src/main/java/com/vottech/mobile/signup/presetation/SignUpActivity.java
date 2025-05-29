package com.vottech.mobile.signup.presetation;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vottech.mobile.R;
import com.vottech.mobile.shared.utils.RetrofitClient;
import com.vottech.mobile.signup.data.SignUp;
import com.vottech.mobile.signup.utils.SignUpLibs;
import com.vottech.mobile.signup.utils.SignUpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText name_field;
    private EditText mail_field;
    private EditText pass_field;
    private EditText cpass_field;
    private TextView issue_lb;

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

        name_field = findViewById(R.id.name_field);
        mail_field = findViewById(R.id.mail_field);
        pass_field = findViewById(R.id.pass_field);
        cpass_field = findViewById(R.id.confirmPass_field);
        issue_lb = findViewById(R.id.issue_lb);
        issue_lb.setVisibility(GONE);

    }
    
    public void SignUpUser(View view)
    {
        String issue = "*";
        String name = name_field.getText().toString();
        String mail = mail_field.getText().toString();
        String pass = pass_field.getText().toString();
        String cpass = cpass_field.getText().toString();
        if(name.isEmpty()) issue += "Campo nome e obrigatorio \n ";
        if(mail.isEmpty()) issue += "Campo email e obrigatorio\n ";
        if(pass.isEmpty() || !pass.equals(cpass)) issue += "O campo senha e obrigatorio e deve ser igual a confirmação \n";
        if(issue.equals("*"))
        {
            SignUpLibs libs = new SignUpLibs();
            SignUp signup = new SignUp();
            signup.setName(name);
            signup.setEmail(mail);
            signup.setPassword(pass);
            issue = libs.SignupUser(signup);
        }
        issue_lb.setText(issue);
        issue_lb.setVisibility(VISIBLE);
    }
}