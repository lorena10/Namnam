package com.example.genesis.amam;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Cambios extends AppCompatActivity {
    EditText titulo, tiempo, ingredientes, procedimiento;
    Button modificar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);
        titulo = (EditText) findViewById(R.id.etTitulo);
        tiempo = (EditText) findViewById(R.id.etTiempo);
        ingredientes = (EditText) findViewById(R.id.etIngredientes);
        procedimiento = (EditText) findViewById(R.id.etProcedimiento);
        modificar = (Button) findViewById(R.id.btModificar);
        eliminar = (Button) findViewById(R.id.btEliminar);
    }

    public void modificar(View v){
        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("titulo",titulo.getText().toString());
            registro.put("tiempo",tiempo.getText().toString());
            registro.put("ingredientes",ingredientes.getText().toString());
            registro.put("procedimiento",procedimiento.getText().toString());
            db.update("receta",registro,"titulo='"+titulo.getText().toString()+"'",null);
            db.close();
            Toast.makeText(this,"Modificación exitosa de "+titulo.getText().toString(),Toast.LENGTH_SHORT).show();
            titulo.setText("");
            tiempo.setText("");
            ingredientes.setText("");
            procedimiento.setText("");
        }
        catch (Exception ex){
            Toast.makeText(this,"Error en modificación",Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View v){
        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase db = admin.getWritableDatabase();
            db.delete("receta","titulo='"+titulo.getText().toString()+"'",null);
            db.close();
            Toast.makeText(this,"Baja exitosa de "+titulo.getText().toString(),Toast.LENGTH_SHORT).show();
            titulo.setText("");
            tiempo.setText("");
            ingredientes.setText("");
            procedimiento.setText("");
        }
        catch (Exception ex){
            Toast.makeText(this,"Baja no exitosa",Toast.LENGTH_SHORT).show();
        }
    }

    public void consultaLlenarCampos(View v){
        AdminSQLLiteOpenHelper admin =new AdminSQLLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("select titulo, tiempo, ingredientes, procedimiento from receta where titulo='"+titulo.getText().toString()+"'",null );
        if(fila.moveToFirst()){
            titulo.setText(fila.getString(0));
            tiempo.setText(fila.getString(1));
            ingredientes.setText(fila.getString(2));
            procedimiento.setText(fila.getString(3));
            Toast.makeText(this,"Llenado exitoso",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"No existe la receta",Toast.LENGTH_SHORT).show();
    }
}
