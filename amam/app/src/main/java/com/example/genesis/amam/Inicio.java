package com.example.genesis.amam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    ImageButton ibtRecetas, ibtAgregar, ibtIdeas, ibtCambios;
    TextView tvBienvenido;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ibtRecetas = (ImageButton)findViewById(R.id.ibtRecetas);
        ibtAgregar = (ImageButton)findViewById(R.id.ibtAgregar);
        ibtIdeas = (ImageButton)findViewById(R.id.ibtIdeas);
        ibtCambios = (ImageButton)findViewById(R.id.ibtCambios);
        tvBienvenido = (TextView)findViewById(R.id.tvBienvenido);
        bundle = this.getIntent().getExtras();
        tvBienvenido.setText("Bienvenid@ "+bundle.get("Nombre"));
    }

    public void agregar(View v){
        Intent intent = new Intent(Inicio.this,Alta.class);
        startActivity(intent);
    }

    public void ideas(View v){
        Intent intent = new Intent(Inicio.this,Ideas.class);
        startActivity(intent);
    }

    public void cambios(View v){
        Intent intent = new Intent(Inicio.this,Cambios.class);
        startActivity(intent);
    }

    public void recetas(View v){
        Intent intent = new Intent(Inicio.this,MisRecetas.class);
        Bundle b = new Bundle();
        b.putString("Nombre",bundle.get("Nombre").toString());
        intent.putExtras(b);
        startActivity(intent);
    }


}
