package com.anshutiwari.hostelapp.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anshutiwari.hostelapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminRegisterActivity extends AppCompatActivity {

    TextInputEditText mEtAdminName,mEtAdminMob,mEtAdminEmail,mEtAdminPassword,mEtAdminRole;
    Button btnAdminRegister;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        firebaseAuth=FirebaseAuth.getInstance();

        mEtAdminName=findViewById(R.id.til_register_admin_name);
        mEtAdminMob=findViewById(R.id.til_register_admin_phone);
        mEtAdminEmail=findViewById(R.id.til_register_admin_email);
        mEtAdminPassword=findViewById(R.id.til_register_admin_password);
        mEtAdminRole=findViewById(R.id.til_register_admin_role);
        btnAdminRegister=findViewById(R.id.btn_admin_register);


        btnAdminRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin_reg_email=mEtAdminEmail.getText().toString().trim();
                String admin_reg_password=mEtAdminPassword.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(admin_reg_email,admin_reg_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AdminRegisterActivity.this,"Admin is Registered..",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),AdminLoginActivity.class));

                        }else {
                            Toast.makeText(AdminRegisterActivity.this,"Error Occured while creating the admin",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}