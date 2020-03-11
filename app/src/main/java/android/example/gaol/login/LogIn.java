package android.example.gaol.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.example.gaol.HomeMenu;
import android.example.gaol.R;
import android.example.gaol.support.callback_login;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class LogIn extends AppCompatActivity {

    //Validation Email
    String mUname, mPass;

    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mLogin = (Button)findViewById(R.id.btn_login) ;
        mUsername =(EditText)findViewById(R.id.login_username);
        mPassword = (EditText) findViewById(R.id.login_password);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUname = mUsername.getText().toString();
                mPass = mPassword.getText().toString();

                if(mUname.isEmpty()) {
                    mUsername.setError("Field cannot be empty");

                }else if(mPass.isEmpty()){
                    Toast.makeText(LogIn.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }else if(mPass.length()<8){
                    Toast.makeText(LogIn.this, "Enter Password more than 8 character", Toast.LENGTH_SHORT).show();

                }else{
                    //CALL WEB SERVICE
                    ArrayList<HashMap<String, String>> alBookPick = null;
                    //ArrayList alBookPick = new ArrayList<>();
                    alBookPick = Eksekusi(mUname,mPass);
                    if (alBookPick.size()>0){
                        Intent intent = new Intent(LogIn.this, HomeMenu.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LogIn.this, "Anda Bukan Anggota", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }

    public ArrayList<HashMap<String, String>> Eksekusi(String v1, String v2){
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        callback_login update_book = new callback_login(LogIn.this);
        //Log.d("CEKIDBOOK",id_book);
        try {
            arrayList = update_book.execute(
                    v1
                    , v2
            ).get();
        }catch (Exception e){

        }

        return arrayList;
    }


}