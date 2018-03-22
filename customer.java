package com.example.dharaa.foodcall;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class customer extends AppCompatActivity implements View.OnClickListener{


    Button cust_sign_in;
    Button cust_register;
    FirebaseAuth auth;
    EditText email;
    EditText pwd;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.user_name_customer);
        pwd=findViewById(R.id.password);
        cust_sign_in=(Button)findViewById(R.id.sign_in);
        cust_sign_in.setOnClickListener(this);
        cust_register=(Button)findViewById(R.id.register);
        cust_register.setOnClickListener(this);
    }


    public void onClick(View view) {
        if(view.getId()==R.id.sign_in) {

            final Intent cust_sign_in_1 = new Intent(this, register_vendor.class);
            auth.signInWithEmailAndPassword(email.getText().toString().trim(),pwd.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    startActivity(cust_sign_in_1);
                }
            });

        }
        if(view.getId()==R.id.register) {
            Intent cust_register_1 = new Intent(this, register_customer.class);
            startActivity(cust_register_1);
        }

    }
}