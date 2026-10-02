package com.example.mytruecallerapp;

public class Contact {
    String nom,pseudo,numero;
    int id;

    public Contact(int id,String nom, String pseudo, String numero) {
        this.id = id;
        this.nom = nom;
        this.numero = numero;
        this.pseudo = pseudo;

    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }



}
