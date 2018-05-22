package com.example.genesis.amam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.etNombre);
        comenzar = (Button)findViewById(R.id.btComenzar);
    }

    public void comenzar(View v){
        Intent intent = new Intent(MainActivity.this,Inicio.class);
        Bundle b = new Bundle();
        b.putString("Nombre",nombre.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }





}
