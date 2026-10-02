package com.example.mytruecallerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ajout extends AppCompatActivity {

    EditText ednom, edpseudo, ednumero;
    Button btn_Valider, btn_Annuler;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ajout);

        ednom = findViewById(R.id.ednom_ajout);
        edpseudo = findViewById(R.id.edpseudo_ajout);
        ednumero = findViewById(R.id.ednumero_ajout);

        btn_Valider = findViewById(R.id.btn_Valider);
        btn_Annuler = findViewById(R.id.btn_annuler);

        // Database
        db = new DatabaseHelper(this);

        // Ajouter
        btn_Valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nom = ednom.getText().toString().trim();
                String pseudo = edpseudo.getText().toString().trim();
                String numero = ednumero.getText().toString().trim();

                // Vérifier les champs
                if (nom.isEmpty() || pseudo.isEmpty() || numero.isEmpty()) {

                    Toast.makeText(
                            Ajout.this,
                            "Remplissez tous les champs",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                // Ajouter dans SQLite
                long result = db.insertContact(
                        nom,
                        pseudo,
                        numero
                );

                if (result != -1) {

                    Toast.makeText(
                            Ajout.this,
                            "Contact ajouté",
                            Toast.LENGTH_SHORT
                    ).show();

                    // Retour à l'écran précédent
                    finish();

                } else {

                    Toast.makeText(
                            Ajout.this,
                            "Erreur lors de l'ajout",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        // Annuler
        btn_Annuler.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}