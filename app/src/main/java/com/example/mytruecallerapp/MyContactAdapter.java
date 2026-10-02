package com.example.mytruecallerapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class MyContactAdapter extends BaseAdapter {
    Context con;
    ArrayList<Contact> data ;
    DatabaseHelper db;
    MyContactAdapter(Context con, ArrayList<Contact> data){
        this.con=con;
        this.data=data;
        db = new DatabaseHelper(con);


    }


    @Override
    public int getCount() {
        //retourne le nombre de view a creer
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //creation d'un view pour chaque position : VIEWHOLDER
        //convertir : parse xml to java
        LayoutInflater inf = LayoutInflater.from(con);
        View v =inf.inflate(R.layout.view_contact,null);
        //recup des holders
        TextView tvnom=v.findViewById(R.id.tvnom_contact);
        TextView tvpseudo=v.findViewById(R.id.tvpeudo_contact);
        TextView tvnumero=v.findViewById(R.id.tvnumero_contact);

        ImageView imgCall=v.findViewById(R.id.imageViewCall_contact);
        ImageView imgDelete=v.findViewById(R.id.imageViewDelete_contact);
        ImageView imgEdit=v.findViewById(R.id.imageViewEdit_contact);




        //affectation des holders

        Contact c=data.get(position);
        tvnom.setText(c.nom);
        tvpseudo.setText(c.pseudo);
        tvnumero.setText(c.numero);


        //Event
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel"+c.numero));
                con.startActivity(i);
            }
        });
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //supprimer de la base de donner SQlite si c bon alors => a faire
                //afficher une boite de dialogue
                AlertDialog.Builder alert=new AlertDialog.Builder(con);
                alert.setTitle("suppresion");
                alert.setMessage("confirmer la suppression");
                alert.setPositiveButton("confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*data.remove(position);
                        notifyDataSetChanged();//refreched*/
                        Contact contact = data.get(position);

                        int result = db.deleteContact(contact.id);

                        if (result > 0) {

                            data.remove(position);

                            notifyDataSetChanged();
                        }

                    }
                });
                alert.setNegativeButton("Annuler",null);
                alert.show();

            }
        });



        return v;


    }
}
