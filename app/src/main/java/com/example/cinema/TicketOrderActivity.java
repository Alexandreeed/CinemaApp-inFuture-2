package com.example.cinema;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialDatePicker.Builder;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import static com.example.cinema.MainActivity.fragmentManager;

@RequiresApi(api = Build.VERSION_CODES.N)
public class TicketOrderActivity extends AppCompatActivity {
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ImageView imageView;
    NestedScrollView nestedScrollView;
    TextView descriptins,title2,finar;
    String [] time = new String[]{"12:43","12:43","12:43","12:43","12:43","12:43"};
    Button button;
    LinearLayout linearLayout;
    static final int DATE_DIALOG_ID = 999;
    private int year;
    private int month;
    private int day;

    final Calendar c = Calendar.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_order);
        setViews();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        descriptins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descriptins.setMaxLines(Integer.MAX_VALUE);
            }
        });
        descriptins.setText("YfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdjYfhuehfuhoeifoaisjdfiosdjfoisdhufhsidfhiodjfiosdj");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        Builder builder = Builder.datePicker();
        MaterialDatePicker<Long>materialDatePicker =builder.build();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                materialDatePicker.show(getSupportFragmentManager(),"Data_Picker");
//            }
//        });
//        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
//            @Override
//            public void onPositiveButtonClick(Long selection) {
//                button.setText(selection.toString());
//            }
//        });
        
        setButtons(6, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TicketOrderActivity.this,SpaceActivity.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

    }

    private void setViews() {
        appBarLayout = findViewById(R.id.appvar);
        collapsingToolbarLayout = findViewById(R.id.toolbarLayout);
        toolbar = findViewById(R.id.toolbar);
        imageView = findViewById(R.id.imageView);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        descriptins = findViewById(R.id.descriptions);
        button = findViewById(R.id.date_show);
        title2 = findViewById(R.id.title2);
        finar = findViewById(R.id.finar);
        linearLayout = findViewById(R.id.time_container2);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void setButtons(int quantity, View.OnClickListener listener){
        for (int i = 0; i < quantity; i++) {
            Button b = new Button(this);
            b.setOnClickListener(listener);
            b.setTextColor(Color.GRAY);
            b.setText(time[i]);
            b.setBackgroundResource(R.drawable.white);
            b.setTextSize(10);
            linearLayout.addView(b);
            Space space = new Space(this);
            space.setPadding(20,20,20,20);
            linearLayout.addView(space);
        }
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener, year, month,
                        day);
        }
        return null;
    }

    public DatePickerDialog.OnDateSetListener datePickerListener =
            new    DatePickerDialog.   OnDateSetListener(){

                // when dialog box is closed, below method will be called.
                public void onDateSet(DatePicker view, int selectedYear,
                                      int selectedMonth, int selectedDay) {
                    year = selectedYear;
                    month = selectedMonth;
                    day = selectedDay;

                    // set selected date into edittext
                    button.setText(new StringBuilder().append(month + 1).append(".")
                            .append(day).append(".").append(year).append(" "));

                }
            };

}