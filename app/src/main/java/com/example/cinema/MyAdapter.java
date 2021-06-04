package com.example.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class MyAdapter extends ArrayAdapter<Ticket> {
    private int layout;
    public MyAdapter(Context context, int resource, Ticket[] objects) {
        super(context, resource, objects);
        layout= R.layout.fragment_ticket;
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(layout,null);
        }
        Ticket f = getItem(position);
        ImageView image = convertView.findViewById(R.id.image);
        image.setImageResource(R.drawable.ticket);
        return convertView;
    }
}