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

        // Liste des contacts
        String[] contacts = {
                "Ahmed - 22 123 456",
                "Mohamed - 55 456 789",
                "Ali - 98 111 222",
                "Sami - 20 333 444",
                "Yassine - 25 555 666",
                "Amine - 29 777 888",
                "Oussama - 21 234 567",
                "Hamza - 53 345 678",
                "Anis - 97 456 789",
                "Malek - 24 567 890",
                "Seif - 27 678 901",
                "Wassim - 52 789 012",
                "Aymen - 93 890 123",
                "Karim - 26 901 234",
                "Mehdi - 54 012 345",
                "Bilel - 22 345 678",
                "Houssem - 98 456 789",
                "Fares - 20 567 890",
                "Nader - 25 678 901",
                "Rami - 29 789 012",
                "Slim - 21 890 123",
                "Taha - 53 901 234",
                "Rayen - 97 012 345",
                "Marwen - 24 123 890",
                "Zied - 27 234 901",
                "Iheb - 52 345 012",
                "Mourad - 93 456 123",
                "Sofiene - 26 567 234",
                "Chaker - 54 678 345",
                "Hedi - 22 789 456"
        };

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contacts
        );

        // Afficher la liste
        listContacts.setAdapter(adapter);

        // Recherche
        edRecherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count
            ) {

                adapter.getFilter().filter(s);
            }
            //we dont need it
            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after
            ) {
            }
            //we dont need it
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}