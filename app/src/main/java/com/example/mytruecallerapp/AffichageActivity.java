package com.example.mytruecallerapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AffichageActivity extends AppCompatActivity {

    ListView listContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.affichage);

        listContacts = findViewById(R.id.listContacts);

        String[] contacts = {
                "Ahmed - 22 123 456",
                "Mohamed - 55 456 789",
                "Ali - 98 111 222",
                "Sami - 20 333 444",
                "Yassine - 25 555 666",
                "Amine - 29 777 888"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contacts
        );

        listContacts.setAdapter(adapter);
    }
}