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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class StudentRegisterActivity extends AppCompatActivity {

    TextInputLayout mEtStudentRegName,mEtStudentRegMob,mEtStudentRegEmail,mEtStudentRegPassword,mEtStudentRegCllgNo;
    Button mBtnStudentReg;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
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
                String email=mEtStudentRegEmail.getEditText().getText().toString().trim();
                String pass=mEtStudentRegPassword.getEditText().getText().toString().trim();
                String studentName = mEtStudentRegName.getEditText().getText().toString();
                String studentPhone = mEtStudentRegMob.getEditText().getText().toString();
                String studentRegd = mEtStudentRegCllgNo.getEditText().getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            assert firebaseUser != null;
                            String userId = firebaseUser.getUid();

                            reference = database.getReference("Students").child(userId);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("student_fid",userId);
                            hashMap.put("student_regd_no",studentRegd);
                            hashMap.put("student_name",studentName);
                            hashMap.put("student_phone",studentPhone);
                            hashMap.put("student_email",email);
                            hashMap.put("imageURL","default");
                            hashMap.put("id_imageUrl","default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(StudentRegisterActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(StudentRegisterActivity.this, "Database failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //Toast.makeText(StudentRegisterActivity.this,"Student Account Created Successfully",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),StudentLoginActivity.class));
                        }else {
                            Toast.makeText(StudentRegisterActivity.this,"You can't register with the email",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}