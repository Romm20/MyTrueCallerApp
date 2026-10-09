package com.example.mytruecallerapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AffichageActivity extends AppCompatActivity {

    RecyclerView listContacts;
    EditText edRecherche;

    DatabaseHelper db;
    ArrayList<Contact> data;
    MyContactAdapter adapter;

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
        //*adapter = new MyContactAdapter(this, data);
        listContacts.setAdapter(adapter);

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

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (db != null && adapter != null) {
            String recherche = edRecherche.getText().toString();
            data.clear();
            data.addAll(db.getAllContacts());

            // Réappliquer la recherche actuelle
            rechercher(recherche);
        }
    }
}