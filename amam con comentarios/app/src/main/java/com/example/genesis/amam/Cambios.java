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

//Clase del layout activity_cambios para hacer modificaciones y eliminar recetas
public class Cambios extends AppCompatActivity {

    //Atributos del layout activity_cambios que se utilizarán para hacer modificaciones
    EditText titulo, tiempo, ingredientes, procedimiento;
    Button modificar, eliminar;

    //Método para relacionar las variables del layout activity_cambios con las de esta clase
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

    //Método para que a partir del título asignado a la receta, se hagan modificaciones
    public void modificar(View v){
        try{

            //Busca la receta por título asignado y actualiza los datos en la base de datos
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("titulo",titulo.getText().toString());
            registro.put("tiempo",tiempo.getText().toString());
            registro.put("ingredientes",ingredientes.getText().toString());
            registro.put("procedimiento",procedimiento.getText().toString());
            db.update("receta",registro,"titulo='"+titulo.getText().toString()+"'",null);
            db.close();

            //Cuando la modificación es exitosa, envía un toast con el nombre asignado a la receta para verificar
            Toast.makeText(this,"Modificación exitosa de "+titulo.getText().toString(),Toast.LENGTH_SHORT).show();

            //Pone todos los campos en blanco después de haber hecho los cambios
            titulo.setText("");
            tiempo.setText("");
            ingredientes.setText("");
            procedimiento.setText("");

        }
        catch (Exception ex){

            //Muestra un mensaje de error en caso de que los cambios no se hayan podido realizar
            Toast.makeText(this,"Error en modificación",Toast.LENGTH_SHORT).show();
        }
    }

    //Método para que se elimine una receta
    public void eliminar(View v){
        try{

            //A partir del título asignado a la receta se le busca y elimina
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase db = admin.getWritableDatabase();
            db.delete("receta","titulo='"+titulo.getText().toString()+"'",null);
            db.close();

            //Cuando la baja es exitosa, envía un toast con el nombre asignado a la receta para verificar
            Toast.makeText(this,"Baja exitosa de "+titulo.getText().toString(),Toast.LENGTH_SHORT).show();

            //Pone todos los campos en blanco después de haber eliminado de la base de datos
            titulo.setText("");
            tiempo.setText("");
            ingredientes.setText("");
            procedimiento.setText("");
        }
        catch (Exception ex){

            //Muestra un mensaje de error en caso de que la baja no haya sido exitosa
            Toast.makeText(this,"Baja no exitosa",Toast.LENGTH_SHORT).show();
        }
    }

    //Método de búsquea para llenar los campos con la información de una receta
    public void consultaLlenarCampos(View v){

        //A partir del título asignado a la receta se le busca y llenan los campos en la aplicación
        AdminSQLLiteOpenHelper admin =new AdminSQLLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("select titulo, tiempo, ingredientes, procedimiento from receta where titulo='"+titulo.getText().toString()+"'",null );
        if(fila.moveToFirst()){
            titulo.setText(fila.getString(0));
            tiempo.setText(fila.getString(1));
            ingredientes.setText(fila.getString(2));
            procedimiento.setText(fila.getString(3));

            //Cuando la búsqueda es exitosa, envía un toast de confirmación
            Toast.makeText(this,"Llenado exitoso",Toast.LENGTH_SHORT).show();
        }
        else
            //Muestra un mensaje de error en caso de que la receta buscada no exista
            Toast.makeText(this,"No existe la receta",Toast.LENGTH_SHORT).show();
    }
}
