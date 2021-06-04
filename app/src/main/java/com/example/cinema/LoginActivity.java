package com.example.cinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.LocusId;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cinema.databinding.ActivityLogin2Binding;
import com.example.cinema.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private ActivityLogin2Binding binding;

    private PhoneAuthProvider.ForceResendingToken forceResendingToken;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    private String mVerificationId;

    private static final String TAG = "MAIN_TAG";

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogin2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.phoneLi.setVisibility(View.VISIBLE);
        binding.codeL.setVisibility(View.GONE);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait.....");
        progressDialog.setCanceledOnTouchOutside(false);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCrediental(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                progressDialog.dismiss();

                Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String VerificationId, @NonNull PhoneAuthProvider.ForceResendingToken Token) {
                super.onCodeSent(VerificationId, forceResendingToken);
                Log.d(TAG,"onCodeSent: "+VerificationId);

                mVerificationId = VerificationId;
                forceResendingToken = Token;
                progressDialog.dismiss();

                binding.phoneLi.setVisibility(View.GONE);
                binding.codeL.setVisibility(View.VISIBLE);

                Toast.makeText(LoginActivity.this, "Verification code sent...", Toast.LENGTH_SHORT).show();

                binding.phonesentdescription.setText("Please type the verification code we sent \nto"+binding.phoneEt.getText().toString().trim());
            }
        };
        binding.phoneContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = binding.phoneEt.getText().toString().trim();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(LoginActivity.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                }
                else {
                    startPhoneNumberVerification(phone);
                }
            }
        });
        binding.resendCodeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = binding.phoneEt.getText().toString().trim();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(LoginActivity.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                }
                else {
                    resendVerificationcode(phone, forceResendingToken);
                }
            }
        });
        binding.codeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = binding.codeEt.getText().toString().trim();
                if (TextUtils.isEmpty(code)){
                    Toast.makeText(LoginActivity.this, "Please endter code", Toast.LENGTH_SHORT).show();
                }
                else {
                    verifyPhoneNumberWithCode(mVerificationId,code);
                }
            }
        });
    }

    private void verifyPhoneNumberWithCode(String VerificationId, String code) {
        progressDialog.setMessage("Verifying code");
        progressDialog.show();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(VerificationId,code);
        signInWithPhoneAuthCrediental(credential);
    }

    private void signInWithPhoneAuthCrediental(PhoneAuthCredential credential) {
        progressDialog.setMessage("Logging in");
        progressDialog.show();

        firebaseAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                progressDialog.dismiss();
                String phone = firebaseAuth.getCurrentUser().getPhoneNumber();
                Toast.makeText(LoginActivity.this, "Logged in as"+phone, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void resendVerificationcode(String phone,PhoneAuthProvider.ForceResendingToken token) {
        progressDialog.setMessage("Resending code");
        progressDialog.show();
        PhoneAuthOptions phoneAuthOptions = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phone)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallbacks)
                .setForceResendingToken(token)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions);

    }

    private void startPhoneNumberVerification(String phone) {
        progressDialog.setMessage("Verifying phone number");
        progressDialog.show();
        PhoneAuthOptions phoneAuthOptions = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phone)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallbacks)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions);
    }
}