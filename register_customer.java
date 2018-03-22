package com.example.dharaa.foodcall;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dharaa.foodcall.models.UserDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register_customer extends AppCompatActivity implements View.OnClickListener {
    private Button reg;
    private EditText name;
    private EditText pwd;
    private  EditText mob_no;
    private  EditText email;
    private DatabaseReference databaseReference;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);
        firebaseAuth= FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        reg=(Button) findViewById(R.id.reg);


        name=(EditText)  findViewById(R.id.name);
        email=(EditText)  findViewById(R.id.email);
        pwd=(EditText)  findViewById(R.id.pwd);
        mob_no=(EditText)  findViewById(R.id.mob_no);

        reg.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if(view == reg){
            registerUser();
        }

    }

    private void registerUser() {

        final String name1= name.getText().toString().trim();
        final String pwd1= pwd.getText().toString().trim();
        final String email1= email.getText().toString().trim();
        final String mob_no1= mob_no.getText().toString().trim();

        firebaseAuth.createUserWithEmailAndPassword(email1,pwd1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                UserDetails details=new UserDetails(name1,pwd1,email1,mob_no1);
                databaseReference.child("User details").child(name1).setValue(details).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                       // Toast.makeText(getApplicationContext(),"SUCCESSFULLY REGISTERED!",Toast.LENGTH_SHORT).show();
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"SUCCESSFULLY REGISTERED!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"FAILED REGISTERED!",Toast.LENGTH_SHORT).show();

                        }
                    }

                    /*public void onComplete(@NonNull Task<Void> task) {


                        //return;

                    }*/
                });
            }
        });


        if(TextUtils.isEmpty(name1)){

            Toast.makeText(this,"PLEASE ENTER NAME!",Toast.LENGTH_SHORT).show();

            return;

        }

        if(TextUtils.isEmpty(pwd1)){

            Toast.makeText(this,"PLEASE ENTER PASSWORD!",Toast.LENGTH_SHORT).show();

            return;

        }

        if (pwd1.length()<4){
            pwd.setError("Minimum length of passwword should be 4");
            pwd.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(email1)){

            Toast.makeText(this,"PLEASE ENTER EMAIL ID!",Toast.LENGTH_SHORT).show();

            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("Please enter a valid Email Id!!!");
           // email.requestFocous();
            return;
        }

        if(TextUtils.isEmpty(mob_no1)){

            Toast.makeText(this,"PLEASE ENTER MOBILE NUMBER!",Toast.LENGTH_SHORT).show();

            return;

        }

        //firebaseAuth.signInWithCredential()

    }
}
