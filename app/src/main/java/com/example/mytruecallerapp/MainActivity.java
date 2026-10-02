package com.example.mytruecallerapp;

import android.content.Intent;
import android.net.Uri;
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

public class MainActivity extends AppCompatActivity {

    //declaration des composantes
    Button btnVal,BtnQte;
    EditText edemail,edpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //mettre un xml sur l'ecran
        setContentView(R.layout.activity_main);



        //recuperation des composantes

        edemail =findViewById(R.id.edEmail_auth);
        edpwd = findViewById(R.id.edpwd_auth);

        btnVal = findViewById(R.id.btnVal_auth);
        BtnQte = findViewById(R.id.btnqte_auth);
        //EVENement



        BtnQte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edemail.getText().toString();
                String pwd = edpwd.getText().toString();

                if(email.equals("azer")&& pwd.equals("111"))
                {
                    //passage vers activite accuei
                    /* Intent i = new Intent();// intention de lancer une action
                    i.setAction(Intent.ACTION_DIAL);//numerotation
                    i.setData(Uri.parse("tel:123456789"));// donnees
                    startActivity(i);*/
                    Intent i = new Intent(MainActivity.this,Accueil.class);// intetn explicite
                    i.putExtra("EMAIL",email);
                    startActivity(i);
                }
                else {
                    //message d'erreur
                    Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}