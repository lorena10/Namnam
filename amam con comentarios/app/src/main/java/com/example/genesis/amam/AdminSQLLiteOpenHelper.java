package com.example.genesis.amam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//Clase Base de Datos
public class AdminSQLLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Creación de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table receta(numReceta integer primary key, titulo text, tiempo text, ingredientes text, procedimiento text)");

    }

    //Si ya existe una base de datos con el mismo nombre, se elimina y se crea una nueva
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists receta");
        db.execSQL("create table receta(numReceta integer primary key, titulo text, tiempo text, ingredientes text, procedimiento text)");
    }

}
