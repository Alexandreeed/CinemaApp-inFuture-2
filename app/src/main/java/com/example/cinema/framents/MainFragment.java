package com.example.cinema.framents;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cinema.MainActivity;
import com.example.cinema.R;
import com.example.cinema.SliderAdapter;
import com.example.cinema.TicketOrderActivity;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import static android.content.ContentValues.TAG;

public class MainFragment extends Fragment {


    FirebaseFirestore db;
    View mainFragment;

    LinearLayout linearLayout, time_container;
    SliderAdapter sliderAdapter;
    ViewPager2 viewPager2;
    int list[];
    TextView textView;
    TextView[] dots;
    String[] time = new String[]{"12:43", "12:43", "12:43", "12:43","12:43","12:43"};


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainFragment = inflater.inflate(R.layout.main_fragment, container, false);
        linearLayout = mainFragment.findViewById(R.id.dots_container);
        time_container = mainFragment.findViewById(R.id.time_container);
        viewPager2 = mainFragment.findViewById(R.id.view_pager2);
        db = FirebaseFirestore.getInstance();



        sliderAdapter = new SliderAdapter(list);
        viewPager2.setAdapter(sliderAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectedIndicator(position);
                super.onPageSelected(position);
            }
        });

        dots = new TextView[5];

        dotsIndicator();

        return mainFragment;
    }

    private void selectedIndicator(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setTextColor(getResources().getColor(R.color.white));
            } else {
                dots[i].setTextColor(getResources().getColor(R.color.design_default_color_primary));
            }
        }
    }

    private void dotsIndicator() {
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            linearLayout = mainFragment.findViewById(R.id.dots_container);
            linearLayout.addView(dots[i]);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}