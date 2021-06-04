package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button button,logout;
    TextView phoneTv;

    private ProfileActivity binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.nextAct);
        logout = findViewById(R.id.logoutbtn);
        phoneTv = findViewById(R.id.phoneTv);
        firebaseAuth = FirebaseAuth.getInstance();

        checkUserStatus();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                checkUserStatus();
            }
        });
    }

    private void checkUserStatus() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            String phone = firebaseUser.getPhoneNumber();
            phoneTv.setText(phone);
        }
        else {
            finish();
        }
    }
}