package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Register extends AppCompatActivity {
    Button sub,can;
    EditText uname,pw1,pw2,city;
    public String un,pass,ct;
    Activity a=this;
    AlertDialog.Builder builder;
    FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        uname=findViewById(R.id.rname);
        pw1=findViewById(R.id.pass);
        pw2=findViewById(R.id.copass);
        city=findViewById(R.id.city);
        sub=findViewById(R.id.btnregi);
        can=findViewById(R.id.btncan);
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder= new AlertDialog.Builder(Register.this);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        a.finish();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setCancelable(false).setMessage("are you want to cancel Registration?");

                AlertDialog ad=builder.create();
                ad.show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!uname.getText().toString().isEmpty() && !pw1.getText().toString().isEmpty()  &&  !city.getText().toString().isEmpty())
                {
                    if(pw1.getText().toString().equals(pw2.getText().toString()))
                    {
                        un=uname.getText().toString();
                        pass=pw1.getText().toString();
                        ct=city.getText().toString();
                        auth.createUserWithEmailAndPassword(un,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Register.this, "Registeration Sucessfully", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(Register.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(Register.this, "Registration Not Complete", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                    else
                    {
                        Toast.makeText(Register.this, "password matching error", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Register.this, "enter details properly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}