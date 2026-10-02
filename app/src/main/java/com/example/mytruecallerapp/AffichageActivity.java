package com.example.mytruecallerapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AffichageActivity extends AppCompatActivity {

    ListView listContacts;
    EditText edRecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.affichage);

        // Récupérer les composants
        listContacts = findViewById(R.id.lv_affiche);
        edRecherche = findViewById(R.id.ed_recherche);

        /*ArrayAdapter ad= new ArrayAdapter<>(AffichageActivity.this, android.R.layout.simple_list_item_1);*/

        MyContactAdapter ad=new MyContactAdapter(AffichageActivity.this,Accueil.data);

        listContacts.setAdapter(ad);












    }
}