package com.example.cinema;

import android.content.Context;
import android.widget.TextView;

public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {

    public MyTextView(Context context) {
        super(context);
    }
    private int row;
    private int seat;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
