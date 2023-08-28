package com.example.foodapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button log1;
    TextView r1;
    EditText u1,p1;
FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Intent intent=getIntent();
        String stt =intent.getStringExtra("u11");
        String stt2 =intent.getStringExtra("u22");

        r1=findViewById(R.id.regs);
        u1=findViewById(R.id.user);
        p1=findViewById(R.id.lock);
        log1=(Button)findViewById(R.id.btnsub);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(u1.getText().toString().isEmpty()){
                    u1.setError("Enter username");
                }
                if(p1.getText().toString().isEmpty()){
                    p1.setError("Enter password");
                }
                if(!u1.getText().toString().isEmpty() && !p1.getText().toString().isEmpty()){
                   String uuu= u1.getText().toString();
                    String ppp=p1.getText().toString();


                        auth.signInWithEmailAndPassword(uuu,ppp).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isComplete())
                            {
                                Intent i = new Intent(MainActivity.this,Home.class);
                                startActivity(i);
                                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this, "Login decline", Toast.LENGTH_SHORT).show();
                            }
                            }
                        });


                }

            }
        });

    }
}