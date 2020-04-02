package android.example.gaol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.gaol.login.LogIn;
import android.example.gaol.register.Register;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button mLogin;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mLogin=findViewById(R.id.btn_home_login);
        mSignUp=findViewById(R.id.btn_home_signup);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLogIn();
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignUp();
            }
        });


    }

    private void OpenSignUp() {
        Intent intent= new Intent (this, Register.class);
        startActivity(intent);
    }

    private void OpenLogIn() {
        Intent intent= new Intent (this, LogIn.class);
        startActivity(intent);
    }
}