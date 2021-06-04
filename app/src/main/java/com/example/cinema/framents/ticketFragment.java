package com.example.cinema.framents;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cinema.MainActivity;
import com.example.cinema.MyAdapter;
import com.example.cinema.R;
import com.example.cinema.Ticket;
import com.example.cinema.framents.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class ticketFragment extends Fragment {
    ListView l;

    public ticketFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ticketFragment newInstance(int columnCount) {
        return new ticketFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_list, container, false);
        l = view.findViewById(R.id.list);
        Ticket [] tickets = new Ticket[20];
        MyAdapter myAdapter = new MyAdapter(getContext(),R.layout.fragment_ticket_list,tickets);
        l.setAdapter(myAdapter);
        return view;
    }
}