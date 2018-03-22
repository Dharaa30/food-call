package com.example.dharaa.foodcall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class vendor extends AppCompatActivity implements View.OnClickListener{


    Button v_sign_in;
    Button v_register;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        v_sign_in=(Button)findViewById(R.id.sign_in);
        v_sign_in.setOnClickListener(this);
        v_register=(Button)findViewById(R.id.register);
        v_register.setOnClickListener(this);
    }


    public void onClick(View view) {
        if(view.getId()==R.id.v_sign_in) {
            Intent cust_sign_in_1 = new Intent(this, register_vendor.class);
            startActivity(cust_sign_in_1);
        }
        if(view.getId()==R.id.v_register) {
            Intent cust_register_1 = new Intent(this, register_customer.class);
            startActivity(cust_register_1);
        }

    }
}