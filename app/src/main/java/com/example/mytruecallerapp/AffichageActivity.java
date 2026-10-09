package com.example.mytruecallerapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AffichageActivity extends AppCompatActivity {

    RecyclerView listContacts;
    EditText edRecherche;

    DatabaseHelper db;
    ArrayList<Contact> data;
    MyRecyclerContactAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.affichage);

        // Initialiser les composants
        listContacts = findViewById(R.id.rv_affiche);
        edRecherche = findViewById(R.id.ed_recherche);

        // Initialiser la base de données
        db = new DatabaseHelper(this);

        // Charger les contacts
        data = db.getAllContacts();

        // Initialiser l'adapter
        // adapter = new MyContactAdapter(this, data);
        // listContacts.setAdapter(adapter);

        ad = new MyRecyclerContactAdapter(this, data);
        listContacts.setAdapter(ad);

        //layout manager pour le recyler view

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                AffichageActivity.this,
                LinearLayoutManager.VERTICAL,
                false
        );
        // GridLayoutManager layoutManager = new GridLayoutManager(AffichageActivity.this,1,LinearLayoutManager.VERTICAL,true);
        listContacts.setLayoutManager(layoutManager);

        // Recherche en temps réel
        edRecherche.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                rechercher(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void rechercher(String texte) {

        ArrayList<Contact> resultats = new ArrayList<>();

        String recherche = texte.toLowerCase().trim();

        for (Contact c : db.getAllContacts()) {

            if ((c.nom != null &&
                    c.nom.toLowerCase().contains(recherche))
                    ||
                    (c.pseudo != null &&
                            c.pseudo.toLowerCase().contains(recherche))
                    ||
                    (c.numero != null &&
                            c.numero.contains(recherche))) {

                resultats.add(c);
            }
        }

        data.clear();
        data.addAll(resultats);

        ad.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (db != null && ad != null) {
            data.clear();
            data.addAll(db.getAllContacts());

            // Réappliquer la recherche actuelle
            rechercher(edRecherche.getText().toString());
        }
    }
}