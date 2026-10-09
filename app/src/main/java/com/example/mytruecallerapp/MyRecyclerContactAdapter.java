package com.example.mytruecallerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerContactAdapter extends RecyclerView.Adapter<MyRecyclerContactAdapter.MyViewHolder> {

    Context con;
    ArrayList<Contact> data ;

    public MyRecyclerContactAdapter(Context con) {
        this.con = con;
    }

    public MyRecyclerContactAdapter(ArrayList<Contact> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public MyRecyclerContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creation d'un view pour chaque position : VIEWHOLDER
        //convertir : parse xml to java
        LayoutInflater inf = LayoutInflater.from(con);
        View v =inf.inflate(R.layout.view_contact,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerContactAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
