package com.example.mytruecallerapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AffichageActivity extends AppCompatActivity {

    ListView listContacts;
    EditText edRecherche;

    DatabaseHelper db;

    ArrayList<Contact> data;

    MyContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.affichage);

        // Composants
        listContacts = findViewById(R.id.lv_affiche);
        edRecherche = findViewById(R.id.ed_recherche);

        // Database
        db = new DatabaseHelper(this);

        // Récupérer les contacts
        data = db.getAllContacts();

        // Adapter
        adapter = new MyContactAdapter(
                AffichageActivity.this,
                data
        );

        listContacts.setAdapter(adapter);
    }
}