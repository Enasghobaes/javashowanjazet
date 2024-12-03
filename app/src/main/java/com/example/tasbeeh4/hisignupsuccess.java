package com.example.tasbeeh4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class hisignupsuccess extends AppCompatActivity {
TextView firstname;
    TextView lastname;
    TextView pass;
    TextView rpass;
    TextView email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hisignupsuccess);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        pass=findViewById(R.id.pass);
        rpass=findViewById(R.id.rpass);
        email=findViewById(R.id.email);
         getIntent().getStringExtra("fname");
        getIntent().getStringExtra("lname");
        getIntent().getStringExtra("pass");
        getIntent().getStringExtra("rpass");
        getIntent().getStringExtra("email");

        firstname.setText(getIntent().getStringExtra("fname"));
        lastname.setText(getIntent().getStringExtra("lname"));
        pass.setText(getIntent().getStringExtra("pass"));
        rpass.setText(getIntent().getStringExtra("rpass"));
        email.setText(getIntent().getStringExtra("email"));


    }
}