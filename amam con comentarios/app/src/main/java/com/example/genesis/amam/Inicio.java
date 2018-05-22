package com.example.genesis.amam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

//Clase del layout activity_inicio para accesar a la funcionalidad de aplicación
public class Inicio extends AppCompatActivity {

    //Atributos del layout activity_inicio que se utilizarán para acceder a las distintas vistas/funciones
    ImageButton ibtRecetas, ibtAgregar, ibtIdeas, ibtCambios;
    TextView tvBienvenido;
    Bundle bundle;

    //Método para relacionar las variables del layout activity_inicio con las de esta clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        ibtRecetas = (ImageButton)findViewById(R.id.ibtRecetas);
        ibtAgregar = (ImageButton)findViewById(R.id.ibtAgregar);
        ibtIdeas = (ImageButton)findViewById(R.id.ibtIdeas);
        ibtCambios = (ImageButton)findViewById(R.id.ibtCambios);
        tvBienvenido = (TextView)findViewById(R.id.tvBienvenido);

        //Obtiene lo que se tenía en el bundle (nombre ingresado) y se le agrega al text view para personalizar
        bundle = this.getIntent().getExtras();
        tvBienvenido.setText("Bienvenid@ "+bundle.get("Nombre"));
    }

    //Intent para llevar de activity Inicio a la alta de recetas
    public void agregar(View v){

        Intent intent = new Intent(Inicio.this,Alta.class);
        startActivity(intent);
    }

    //Intent para llevar de activity Inicio a activity ideas y visuallizar opciones en una página de internet a través de una WebView
    public void ideas(View v){

        Intent intent = new Intent(Inicio.this,Ideas.class);
        startActivity(intent);
    }

    //Intent para llevar de activity Inicio a la modificación o elimnación de recetas
    public void cambios(View v){

        Intent intent = new Intent(Inicio.this,Cambios.class);
        startActivity(intent);
    }

    //Intent para llevar de activity Inicio a la visalización de todas las recetas ingresadas posteriormente
    public void recetas(View v){

        Intent intent = new Intent(Inicio.this,MisRecetas.class);

        //Se agrega el nombre a un bundle para utilizarlo posteriormente y personalizar un mensaje en otra activity
        Bundle b = new Bundle();
        b.putString("Nombre",bundle.get("Nombre").toString());
        intent.putExtras(b);

        startActivity(intent);
    }


}
