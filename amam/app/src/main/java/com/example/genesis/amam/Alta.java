package com.example.genesis.amam;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alta extends AppCompatActivity {
    EditText titulo,tiempo,ingredientes,procedimiento;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        titulo = (EditText)findViewById(R.id.etTitulo);
        tiempo = (EditText)findViewById(R.id.etTiempo);
        ingredientes = (EditText)findViewById(R.id.etIngredientes);
        procedimiento = (EditText)findViewById(R.id.etProcedimiento);
    }

    private int generarNumReceta(){
        AdminSQLLiteOpenHelper admin =new AdminSQLLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("select max(numReceta) from receta",null );
        if(fila.moveToFirst()){
            num = fila.getInt(0);
            num = num + 1;
        }
        else
            num = 1;
        return num;
    }

    public void agregar(View v){
        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            num = generarNumReceta();
            registro.put("numReceta", num);
            registro.put("titulo",titulo.getText().toString());
            registro.put("tiempo",tiempo.getText().toString());
            registro.put("ingredientes",ingredientes.getText().toString());
            registro.put("procedimiento",procedimiento.getText().toString());
            db.insert("receta",null,registro);
            db.close();
            Toast.makeText(this,"Receta de "+titulo.getText().toString()+" guardada",Toast.LENGTH_LONG).show();
            titulo.setText("");
            tiempo.setText("");
            ingredientes.setText("");
            procedimiento.setText("");
        }
        catch (Exception ex){
            Toast.makeText(this,"ERROR: No se cargó la receta",Toast.LENGTH_SHORT).show();
        }
    }

}
