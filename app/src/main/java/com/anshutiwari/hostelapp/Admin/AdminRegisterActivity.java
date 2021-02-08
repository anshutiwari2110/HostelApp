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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AdminRegisterActivity extends AppCompatActivity {

    TextInputLayout mEtAdminName,mEtAdminMob,mEtAdminEmail,mEtAdminPassword,mEtAdminRole;
    Button btnAdminRegister;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference reference;

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
                String admin_reg_email=mEtAdminEmail.getEditText().getText().toString().trim();
                String admin_reg_password=mEtAdminPassword.getEditText().getText().toString().trim();
                String admin_Username = mEtAdminName.getEditText().getText().toString();
                String admin_Phone = mEtAdminMob.getEditText().getText().toString();
                String admin_role = mEtAdminRole.getEditText().getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(admin_reg_email,admin_reg_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            if (task.isSuccessful()){
                                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                assert firebaseUser != null;
                                String userId = firebaseUser.getUid();

                                reference = database.getReference("Admin").child(userId);

                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("admin_fid",userId);
                                hashMap.put("admin_name",admin_Username);
                                hashMap.put("admin_phone",admin_Phone);
                                hashMap.put("admin_email",admin_reg_email);
                                hashMap.put("admin_role",admin_role);
                                hashMap.put("admin_imageURL","default");


                                reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(AdminRegisterActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(AdminRegisterActivity.this, "Database failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }else {
                                Toast.makeText(AdminRegisterActivity.this, "You can't register with this email or password" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
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