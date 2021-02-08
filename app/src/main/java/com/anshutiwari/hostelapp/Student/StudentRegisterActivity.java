package com.anshutiwari.hostelapp.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anshutiwari.hostelapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentRegisterActivity extends AppCompatActivity {

    TextInputEditText mEtStudentRegName,mEtStudentRegMob,mEtStudentRegEmail,mEtStudentRegPassword,mEtStudentRegCllgNo;
    Button mBtnStudentReg;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        firebaseAuth=FirebaseAuth.getInstance();

        mEtStudentRegName=findViewById(R.id.til_register_student_name);
        mEtStudentRegEmail=findViewById(R.id.til_register_student_email);
        mEtStudentRegPassword=findViewById(R.id.til_register_student_password);
        mEtStudentRegMob=findViewById(R.id.til_register_student_phone);
        mEtStudentRegCllgNo=findViewById(R.id.til_register_student_regd);
        mBtnStudentReg=findViewById(R.id.btn_student_register);

        mBtnStudentReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mEtStudentRegEmail.getText().toString().trim();
                String pass=mEtStudentRegPassword.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(StudentRegisterActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),StudentLoginActivity.class));
                        }else {
                            Toast.makeText(StudentRegisterActivity.this,"Error in creating user",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}