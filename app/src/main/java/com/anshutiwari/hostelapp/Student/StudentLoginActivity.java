package com.anshutiwari.hostelapp.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anshutiwari.hostelapp.HomeActivity;
import com.anshutiwari.hostelapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLoginActivity extends AppCompatActivity {

    TextInputEditText mEtStudentLoginEmail,mEtStudentLoginPass;
    Button mBtnStudentLogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        firebaseAuth=FirebaseAuth.getInstance();

        mEtStudentLoginEmail=findViewById(R.id.student_login_til_email);
        mEtStudentLoginPass=findViewById(R.id.student_login_til_password);
        mBtnStudentLogin=findViewById(R.id.btn_student_login);

        mBtnStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mEtStudentLoginEmail.getText().toString().trim();
                String pass=mEtStudentLoginPass.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(StudentLoginActivity.this,"Sign IN Success",Toast.LENGTH_LONG).show();
                           startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                       }else {
                           Toast.makeText(StudentLoginActivity.this,"Error",Toast.LENGTH_LONG).show();
                       }
                    }
                });
            }
        });
    }
}