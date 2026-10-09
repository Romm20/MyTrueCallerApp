package com.example.mytruecallerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerContactAdapter extends RecyclerView.Adapter<MyRecyclerContactAdapter.MyViewHolder> {

    Context con;
    ArrayList<Contact> data ;

    public MyRecyclerContactAdapter(Context con,ArrayList<Contact> data) {
        this.con=con;
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
        //affectation des holders
        Contact c=data.get(position);
        holder.tvnom.setText(c.nom);
        holder.tvpseudo.setText(c.pseudo);
        holder.tvnumero.setText(c.numero);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvnom,tvpseudo,tvnumero;
        ImageView imgCall,imgDelete,imgEdit;

        public MyViewHolder(@NonNull View v) {

            super(v);

            //recup des holders
             tvnom=v.findViewById(R.id.tvnom_contact);
             tvpseudo=v.findViewById(R.id.tvpeudo_contact);
             tvnumero=v.findViewById(R.id.tvnumero_contact);

             imgCall=v.findViewById(R.id.imageViewCall_contact);
             imgDelete=v.findViewById(R.id.imageViewDelete_contact);
             imgEdit=v.findViewById(R.id.imageViewEdit_contact);

        }
    }
}
