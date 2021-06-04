package com.example.cinema;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinema.framents.MainFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static android.content.ContentValues.TAG;
import static com.example.cinema.MainActivity.fragmentManager;
import static com.example.cinema.MainActivity.listener;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.MyViewHolder> {

    private final int quantity = 5;
    int list[];
    View view;
    LinearLayout linearLayout;
    TextView age, space;
    FirebaseFirestore db;
    private ArrayList<ImageView> images;
    private ArrayList<String> time,time2,time3,time4,time5;
    FirebaseStorage storage;
    StorageReference storageRef;
    Uri imageUri;
    DatabaseReference databaseReference;
    File localFile;
    StorageReference pathReference;

    public SliderAdapter(int[] list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_pagerview2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("image");
        pathReference= storageRef.child("images/");

        final DocumentReference docRef = db.collection("movies").document("LA");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()&&position==0) {
                    holder.button.setText(Objects.requireNonNull(snapshot.getData().get("name")).toString());
                    time = (ArrayList<String>) snapshot.getData().get("time");
                    for (int i = 0; i < Objects.requireNonNull(time).size(); i++) {
                        Button b = new Button(view.getContext());
                        b.setOnClickListener(listener);
                        b.setTextColor(Color.WHITE);
                        b.setText(time.get(i));
                        b.setBackgroundResource(R.drawable.forbutton);
                        b.setTextSize(10);
                        holder.time_container.addView(b, new LinearLayout.LayoutParams(200, 100));
                    }

                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
//        final DocumentReference docRef2 = db.collection("movies").document("LA2");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w(TAG, "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()&&position==1) {
//                    holder.button.setText(snapshot.getData().get("name").toString());
//                    time2 = (ArrayList<String>) snapshot.getData().get("time");
//                    for (int i = 0; i < time2.size(); i++) {
//                        Button b = new Button(view.getContext());
//                        b.setOnClickListener(listener);
//                        b.setTextColor(Color.WHITE);
//                        b.setText(time.get(i));
//                        b.setBackgroundResource(R.drawable.forbutton);
//                        b.setTextSize(10);
//                        holder.time_container.addView(b, new LinearLayout.LayoutParams(200, 100));
//                    }
//
//                } else {
//                    Log.d(TAG, "Current data: null");
//                }
//            }
//        });
//        final DocumentReference docRef3 = db.collection("movies").document("LA3");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w(TAG, "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()&&position==2) {
//                    holder.button.setText(snapshot.getData().get("name").toString());
//                    time3 = (ArrayList<String>) snapshot.getData().get("time");
//                    for (int i = 0; i < time3.size(); i++) {
//                        Button b = new Button(view.getContext());
//                        b.setOnClickListener(listener);
//                        b.setTextColor(Color.WHITE);
//                        b.setText(time.get(i));
//                        b.setBackgroundResource(R.drawable.forbutton);
//                        b.setTextSize(10);
//                        holder.time_container.addView(b, new LinearLayout.LayoutParams(200, 100));
//                    }
//
//                } else {
//                    Log.d(TAG, "Current data: null");
//                }
//            }
//        });
//        final DocumentReference docRef4 = db.collection("movies").document("LA4");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w(TAG, "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()&&position==3) {
//                    holder.button.setText(snapshot.getData().get("name").toString());
//                    time4 = (ArrayList<String>) snapshot.getData().get("time");
//                    for (int i = 0; i < time4.size(); i++) {
//                        Button b = new Button(view.getContext());
//                        b.setOnClickListener(listener);
//                        b.setTextColor(Color.WHITE);
//                        b.setText(time.get(i));
//                        b.setBackgroundResource(R.drawable.forbutton);
//                        b.setTextSize(10);
//                        holder.time_container.addView(b, new LinearLayout.LayoutParams(200, 100));
//                    }
//
//                } else {
//                    Log.d(TAG, "Current data: null");
//                }
//            }
//        });
//        final DocumentReference docRef5 = db.collection("movies").document("LA5");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w(TAG, "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()&&position==4) {
//                    holder.button.setText(snapshot.getData().get("name").toString());
//                    time5 = (ArrayList<String>) snapshot.getData().get("time");
//                    for (int i = 0; i < time5.size(); i++) {
//                        Button b = new Button(view.getContext());
//                        b.setOnClickListener(listener);
//                        b.setTextColor(Color.WHITE);
//                        b.setText(time.get(i));
//                        b.setBackgroundResource(R.drawable.forbutton);
//                        b.setTextSize(10);
//                        holder.time_container.addView(b, new LinearLayout.LayoutParams(200, 100));
//                    }
//
//                } else {
//                    Log.d(TAG, "Current data: null");
//                }
//            }
//        });
        holder.imageButton.setBackgroundResource(R.drawable.grom);

    }

    @Override
    public int getItemCount() {
        return list != null ? list.length : 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageButton;
        Button button;
        LinearLayout time_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            db = FirebaseFirestore.getInstance();
            imageButton = itemView.findViewById(R.id.imageView);
            imageButton.setImageResource(R.drawable.grom);
            button = itemView.findViewById(R.id.button);
            button.setTextColor(Color.WHITE);
            time_container = itemView.findViewById(R.id.time_container);
            age = itemView.findViewById(R.id.textView);
            space = itemView.findViewById(R.id.space);
            space.setTextColor(Color.WHITE);
            space.setText("Расписание на сегодня");

        }
    }
}