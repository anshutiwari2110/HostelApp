package com.anshutiwari.hostelapp.Admin;

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

public class AdminLoginActivity extends AppCompatActivity {

    TextInputEditText mEtAdminLoginEmail,mEtAdminLoginPassword;
    Button mBtnAdminLogin;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        firebaseAuth=FirebaseAuth.getInstance();

        mEtAdminLoginEmail=findViewById(R.id.admin_login_til_email);
        mEtAdminLoginPassword=findViewById(R.id.admin_login_til_password);
        mBtnAdminLogin=findViewById(R.id.btn_admin_login);

        mBtnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AdminEmail=mEtAdminLoginEmail.getText().toString().trim();
                String AdminPassword=mEtAdminLoginPassword.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(AdminEmail,AdminPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(AdminLoginActivity.this,"Sign In successful",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }else {
                            Toast.makeText(AdminLoginActivity.this,"Error Occured",Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });


    }
}