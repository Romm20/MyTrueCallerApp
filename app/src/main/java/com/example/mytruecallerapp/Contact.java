package com.example.mytruecallerapp;

public class Contact {
    String nom,pseudo,numero;

    public Contact(String numero, String pseudo, String nom) {
        this.numero = numero;
        this.pseudo = pseudo;
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }



}
