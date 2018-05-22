package com.example.genesis.amam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//Clase del layout activity_main para accesar a la funcionalidad de aplicación
public class MainActivity extends AppCompatActivity {

    //Atributos del layout activity_main que se utilizarán para comenzar y personalizar la aplicación
    EditText nombre;
    Button comenzar;

    //Método para relacionar las variables del layout activity_main con las de esta clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.etNombre);
        comenzar = (Button)findViewById(R.id.btComenzar);
    }

    //Intent para llevar de activity Main a la visalización del inicio con todas las funciones
    public void comenzar(View v){

        Intent intent = new Intent(MainActivity.this,Inicio.class);

        //Se agrega el nombre a un bundle para utilizarlo posteriormente y personalizar un mensaje en la siguiente activity
        Bundle b = new Bundle();
        b.putString("Nombre",nombre.getText().toString());
        intent.putExtras(b);

        startActivity(intent);
    }





}
