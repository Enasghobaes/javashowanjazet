package com.example.tasbeeh4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
Button button;
EditText fname;
    EditText lname;
    EditText pass;
    EditText rpass;
    EditText email;
    private static final String emailRegex1 ="^(.+)@(\\S+)$";
    private static final String emailRegex2 ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final Integer passwordminimlength = 6;

    @SuppressLint("MissingInflatedId")
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
//        هنا لكي بنعرض النص المترجم لزمن بسيط
//        Toast.makeText(getApplicationContext(),getString(R.string.Firstname),Toast.LENGTH_LONG).show();
       /*
        هنا استدعاء المتغيرات عن طريق الid تبعها
        */
        button=findViewById(R.id.buttonCreateAccount);
        fname=findViewById(R.id.Firstname);
        lname=findViewById(R.id.Lastname);
        email=findViewById(R.id.Email);
        pass=findViewById(R.id.Password);
        rpass=findViewById(R.id.RePassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fname.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"first name field is empty ! please enter your first name",Toast.LENGTH_LONG).show();
                }
               else if(lname.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Last Name field is empty ! please enter your Last Name",Toast.LENGTH_LONG).show();
                }else if(email.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email field is empty ! please enter your Email",Toast.LENGTH_LONG).show();
                }else if (email.getText().toString().matches(emailRegex2)){
                    Toast.makeText(getApplicationContext(),"Email is not correct ! please enter another Email",Toast.LENGTH_LONG).show();
                }
               else if(pass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password field is empty ! please enter your Password",Toast.LENGTH_LONG).show();
                }else if(pass.getText().toString().length()>=passwordminimlength){
                    Toast.makeText(getApplicationContext(),"Password length is not valid",Toast.LENGTH_LONG).show();
                }
               else if(rpass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Re_Password field is empty ! please enter your Re_Password",Toast.LENGTH_LONG).show();
                }
               else {Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),hisignupsuccess.class);
                    intent.putExtra("fname",fname.getText().toString());
                    intent.putExtra("lname",lname.getText().toString());
                    intent.putExtra("email",email.getText().toString());
                    intent.putExtra("pass",pass.getText().toString());
                    intent.putExtra("rpass",rpass.getText().toString());

                    startActivity(intent);
                }



            }
        });
    }
}