package com.example.cinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.cinema.framents.MainFragment;
import com.example.cinema.framents.ProfileFragment;
import com.example.cinema.framents.ticketFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    public static View.OnClickListener listener;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_app_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomnavmethod);

        fragmentManager = getSupportFragmentManager();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainFragment()).commit();
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TicketOrderActivity.class);
                startActivity(intent);
            }
        };
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomnavmethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = new MainFragment();
                    break;
                case R.id.tickets:
                    fragment = new ticketFragment();
                    break;
                case R.id.profile:
                    fragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
    };
}