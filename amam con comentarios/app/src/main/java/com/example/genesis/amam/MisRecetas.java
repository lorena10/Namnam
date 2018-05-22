package com.example.genesis.amam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//Clase del layout activity_mis_recetas para visualizar todas las recetas registradas
public class MisRecetas extends AppCompatActivity {

    //Atributos del layout activity_mis_recetas que se utilizarán para conocer las recetas guardadas
    TextView misRecetas, recetas;
    Bundle bundle;

    //Método para relacionar las variables del layout activity_main con las de esta clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_recetas);

        misRecetas = (TextView)findViewById(R.id.tvMisRecetas);
        bundle = this.getIntent().getExtras();
        misRecetas.setText("     Recetas de "+bundle.get("Nombre"));
        recetas = (TextView)findViewById(R.id.tvRecetas);

        //Llama al método que genera la lista de recetas en la base de datos
        lista();

    }

    //Método para que obtiene todas las recetas en la base de datos y las despliega en la pantalla
    public void lista(){

        ArrayList<Receta> lista = new ArrayList();
        Receta receta;
        AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("select numReceta, titulo, tiempo, ingredientes, procedimiento from receta",null );
        if(fila.moveToFirst()){
            while(fila.moveToNext()){
                receta = new Receta(fila.getInt(0), fila.getString(1),fila.getString(2),fila.getString(3),fila.getString(4));
                lista.add(receta);
            }

            //Ingresa la lista en el EditText
            recetas.setText(lista.toString());
        }
        else{

            //Muestra un mensaje en caso de que no exista ninguna receta registrada
            Toast.makeText(this,"No hay recetas registradas",Toast.LENGTH_LONG).show();
        }
    }

}
