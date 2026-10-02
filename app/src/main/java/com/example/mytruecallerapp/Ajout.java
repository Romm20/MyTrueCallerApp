package com.example.mytruecallerapp;

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

public class Ajout extends AppCompatActivity {
    EditText ednom,edpseudo,ednumero;
    Button btn_Valider, btn_Annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ajout);

        ednom=findViewById(R.id.ednom_ajout);
        edpseudo=findViewById(R.id.edpseudo_ajout);
        ednumero=findViewById(R.id.ednumero_ajout);
        btn_Valider=findViewById(R.id.btn_Valider);
        btn_Annuler=findViewById(R.id.btn_annuler);

        //evenement
        btn_Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=ednom.getText().toString();
                String pseudo=edpseudo.getText().toString();
                String numero=ednumero.getText().toString();

                Contact c =new Contact(nom,pseudo,numero);

                Accueil.data.add(c);
                Toast.makeText(Ajout.this, "Done", Toast.LENGTH_SHORT).show();


            }
        });









    }






}





