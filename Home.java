package com.example.dharaa.foodcall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity implements View.OnClickListener{


        Button vendor1;
        Button customer1;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            vendor1=(Button)findViewById(R.id.vendor);
            vendor1.setOnClickListener(this);
            customer1=(Button)findViewById(R.id.customer);
            customer1.setOnClickListener(this);
        }


        public void onClick(View view) {
            if(view.getId()==R.id.vendor) {
                Intent vendor2 = new Intent(this, vendor.class);
                startActivity(vendor2);
            }
            if(view.getId()==R.id.customer) {
                Intent customer2 = new Intent(this, customer.class);
                startActivity(customer2);
            }

        }
    }