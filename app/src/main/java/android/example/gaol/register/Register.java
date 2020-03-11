package android.example.gaol.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.gaol.splash.MainActivity;
import android.example.gaol.R;
import android.example.gaol.support.callback_register;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Register extends AppCompatActivity {
    private EditText mName, mUserName, mEmail, mPassword, mMobilePhone, mAddress;
    private Button mBtnSignUp;
    private static final String TAG = "MainActivity";


    //Validation
    String name, usrname, mobilePhone, email, pass, address;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mName = (EditText) findViewById(R.id.reg_name);
        mUserName= (EditText) findViewById(R.id.reg_username);
        mEmail = (EditText) findViewById(R.id.reg_email);
        mMobilePhone = (EditText)findViewById(R.id.reg_phone);
        mPassword = (EditText)findViewById(R.id.reg_password);
        mAddress = (EditText)findViewById(R.id.reg_address);
        mBtnSignUp = (Button)findViewById(R.id.reg_btn);


        //Button Register
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                usrname = mUserName.getText().toString();
                email = mEmail.getText().toString();
                pass = mPassword.getText().toString();
                mobilePhone= mMobilePhone.getText().toString();
                address= mAddress.getText().toString();


                //Validation Register
                if (name.isEmpty()){
                    mName.setError("Field Cannot be Empty");
                }
                else if(usrname.isEmpty()) {
                    mUserName.setError("Field Cannot be Empty");
                }else if(email.isEmpty()){
                    mEmail.setError("Field Cannot be Empty");
                }else if(!email.matches(emailPattern)){
                    mEmail.setError("Enter Valid Email");
                }
                else if(mobilePhone.isEmpty()){
                    mMobilePhone.setError("Field Cannot be Empty");
                }
                else if(address.isEmpty()){
                    mMobilePhone.setError("Field Cannot be Empty");
                }
                else if(pass.isEmpty()){
                    Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }else if(pass.length()<8){
                    Toast.makeText(Register.this, "Enter Password more than 8 character", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Register.this, "Email : "+email+"\npassword : "+pass+"\nname : "+name,
                            Toast.LENGTH_LONG).show();
                    //CALL WEB SERVICE
                    ArrayList<HashMap<String, String>> alBookPick = null;
                    //ArrayList alBookPick = new ArrayList<>();
                    alBookPick = Eksekusi(name,usrname,email,pass,mobilePhone, address);
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public ArrayList<HashMap<String, String>> Eksekusi(String v1, String v2,String v3,String v4, String v5, String v6){
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        callback_register update_book = new callback_register(Register.this);
        //Log.d("CEKIDBOOK",id_book);
        try {
            arrayList = update_book.execute(
                    v1
                    , v2
                    , v3
                    , v4
                    , v5
                    , v6

            ).get();
        }catch (Exception e){

        }

        return arrayList;
    }
}

