package com.example.newsapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button button;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView1 = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonEmail);
        editText3 = findViewById(R.id.editTextTextPersonPassword);
        editText4 = findViewById(R.id.editTextTextPersonConfirmPassword);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editText2.getText().toString().trim();
                String password = editText3.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    editText2.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    editText3.setError("Password is Reqired");
                    return;
                }
                if(password.length() < 6){
                    editText3.setError("Password must have at least 6 characters");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else{
                            Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }
}