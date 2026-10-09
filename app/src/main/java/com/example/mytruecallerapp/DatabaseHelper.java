package com.example.mytruecallerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database
    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;

    // Table
    private static final String TABLE_CONTACTS = "contacts";

    // Columns
    private static final String COL_ID = "id";
    private static final String COL_NOM = "nom";
    private static final String COL_PSEUDO = "pseudo";
    private static final String COL_NUMERO = "numero";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOM + " TEXT, " +
                COL_PSEUDO + " TEXT, " +
                COL_NUMERO + " TEXT)";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    // Ajouter un contact
    public long insertContact(String nom, String pseudo, String numero) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_NOM, nom);
        values.put(COL_PSEUDO, pseudo);
        values.put(COL_NUMERO, numero);

        long result = db.insert(TABLE_CONTACTS, null, values);

        db.close();

        return result;
    }

    // Récupérer tous les contacts
    public ArrayList<Contact> getAllContacts() {

        ArrayList<Contact> contacts = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_CONTACTS,
                null
        );

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(
                        cursor.getColumnIndexOrThrow(COL_ID)
                );

                String nom = cursor.getString(
                        cursor.getColumnIndexOrThrow(COL_NOM)
                );

                String pseudo = cursor.getString(
                        cursor.getColumnIndexOrThrow(COL_PSEUDO)
                );

                String numero = cursor.getString(
                        cursor.getColumnIndexOrThrow(COL_NUMERO)
                );

                Contact contact = new Contact(
                        id,
                        nom,
                        pseudo,
                        numero
                );

                contacts.add(contact);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return contacts;
    }

    // Supprimer un contact
    public int deleteContact(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(
                TABLE_CONTACTS,
                COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );

        db.close();

        return result;
    }
}
