package com.example.mytruecallerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Accueil extends AppCompatActivity {
    //declaration des composantes
    Button btnAjt,btnAffich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_accueil);

        //recuperation des composantes
        btnAjt = findViewById(R.id.btnAjt);
        btnAffich = findViewById(R.id.BtnAffich);

        //EVENement
        btnAjt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Accueil.this, Ajout.class);
                startActivity(i);
            }
        });

        btnAffich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Accueil.this, AffichageActivity.class);
                startActivity(i);
            }
        });


    }
}