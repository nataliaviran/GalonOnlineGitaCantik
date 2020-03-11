package android.example.gaol.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.gaol.Home;
import android.example.gaol.R;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(MainActivity.this, Home.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);
    }
}
