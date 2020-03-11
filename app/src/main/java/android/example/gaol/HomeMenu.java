package android.example.gaol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.gaol.support.information;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeMenu extends AppCompatActivity {
    private Button mIcon1;
    private Button mIcon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        mIcon1 = (Button)findViewById(R.id.btn_order) ;
        mIcon2 = (Button)findViewById(R.id.btn_information) ;

        mIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (HomeMenu.this, information.class);
                startActivity(intent);

            }
        });

        mIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (HomeMenu.this, information.class);
                startActivity(intent);

            }
        });
    }
}
